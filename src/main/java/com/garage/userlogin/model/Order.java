package com.garage.userlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@Column(name = "id")
	private Integer orderId;
	@Column(name = "order_name")
	private String orderName;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "order_cost")
	private Integer orderCost;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Integer orderCost) {
		this.orderCost = orderCost;
	}
}
