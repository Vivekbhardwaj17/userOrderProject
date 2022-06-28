package com.garage.userlogin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.userlogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public List<User> findByUserId(User user);
}
