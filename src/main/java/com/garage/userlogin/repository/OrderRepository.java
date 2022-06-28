package com.garage.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.userlogin.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
