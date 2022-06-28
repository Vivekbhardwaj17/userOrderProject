package com.garage.userlogin.dao;

import org.springframework.stereotype.Component;

import com.garage.userlogin.model.GeneralResponse;
import com.garage.userlogin.model.User;

@Component
public interface UserServiceDao {

	GeneralResponse addNewUser(User user);
	
	GeneralResponse addOrder(User user);
}
