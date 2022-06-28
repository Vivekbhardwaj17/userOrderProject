package com.garage.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.userlogin.dao.UserServiceDao;
import com.garage.userlogin.model.GeneralResponse;
import com.garage.userlogin.model.User;

@RestController
@RequestMapping("userlogin")
public class UserLoginController {

	@Autowired
	private UserServiceDao userDao;
	
	@PostMapping("/api/addUser")
	public GeneralResponse addNewUser(User user) {
		GeneralResponse response = new GeneralResponse();
		response.setValid(false);
		response.setStatusCode(401);
		response.setMessage("User cannot be null");
		if(user == null)
			return response;
		return userDao.addNewUser(user);
	}
	
	@PutMapping("/api/addOrder")
	public GeneralResponse addNewOrder(User user) {
		GeneralResponse response = new GeneralResponse();
		response.setValid(false);
		response.setStatusCode(401);
		response.setMessage("User cannot be null");
		if(user == null)
			return response;
		return userDao.addOrder(user);
	}
}
