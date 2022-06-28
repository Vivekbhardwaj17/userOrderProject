package com.garage.userlogin.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.userlogin.dao.UserServiceDao;
import com.garage.userlogin.model.GeneralResponse;
import com.garage.userlogin.model.Order;
import com.garage.userlogin.model.User;
import com.garage.userlogin.repository.OrderRepository;
import com.garage.userlogin.repository.UserRepository;
import com.garage.userlogin.schedular.UserSchedular;
import com.garage.userlogin.util.Constants;

@Service
@Transactional
public class UserService implements UserServiceDao{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSchedular userSchedular;
	
	@Autowired
	private OrderRepository orderRepository;
	
	private final Logger USESR_LOGGER =  Logger.getLogger(UserService.class);
	
	@Override
	public GeneralResponse addNewUser(User user) {
		GeneralResponse response = new GeneralResponse();
		try {
			user.setNoOfOrders(1);
			user.setPlanId(1);
			userRepository.save(user);
			userSchedular.generateEmail();
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setBody(user);
			USESR_LOGGER.info("New user added: "+user.getUserName());
			
		}
		catch(Exception e) {
			USESR_LOGGER.error("Error: while saving user details in addNewUser method"+e);
			response.setStatusCode(500);
			response.setMessage("Something went wrong!!");
			return response;
		}
		return response;
	}

	@Override
	public GeneralResponse addOrder(User user) {
		GeneralResponse response = new GeneralResponse();
		try {
			Optional<User> existingUser = userRepository.findById(user.getUserId());
			Integer currentCommision = existingUser.get().getCommision();
			Integer newCommission =0;
			user.setNoOfOrders(existingUser.get().getNoOfOrders() + 1);
			if(user.getNoOfOrders() >= Constants.GOLD_MEMBERSHIP && 
					user.getNoOfOrders() < Constants.PLATINUM_MEMBERSHIP ) {
				newCommission  = (int) (currentCommision +( currentCommision * Constants.GOLD_PERCENTAGE * 0.01));
			}
			else if(user.getNoOfOrders() >= Constants.PLATINUM_MEMBERSHIP) {
				newCommission  = (int) (currentCommision +( currentCommision * Constants.PLATINUM_PERCENTAGE * 0.01));
			}
			user.setCommision(newCommission);
			response = updateOrder(user);
			if(response.isValid()) {
				response.setValid(true);
				response.setMessage("Added new order");
				response.setStatusCode(201);
				USESR_LOGGER.info("New new order for user: "+user.getUserName());
				return response;
			}
		}
		catch(Exception e) {
			USESR_LOGGER.error("Error: while adding new order in addOrder method"+e);
			response.setStatusCode(500);
			response.setMessage("Something went wrong!!");
		}
		return response;
	}

	private GeneralResponse updateOrder(User user) {
		GeneralResponse response = new GeneralResponse();
		try {
			Order order = new Order();
			order.setOrderName(user.getOrderName());
			order.setUserId(user.getUserId().intValue());
			order.setOrderCost(user.getOrderCost());
			orderRepository.save(order);
		}
		catch(Exception e) {
			response.setStatusCode(500);
			response.setMessage("Something went wrong!!");
		}
		return response;
	}
	
}
