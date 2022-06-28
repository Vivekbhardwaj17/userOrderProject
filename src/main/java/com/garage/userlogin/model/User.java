package com.garage.userlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {

	
	@Id
	@Column(name  = "id")
	private Long userId;
	@Column(name  = "user_name")
	private String userName;
	@Column(name  = "user_plan_id")
	private Integer planId;
	@Column(name  = "no_of_orders")
	private Integer noOfOrders;
	@Column(name = "total_commision")
	private Integer commision;
	
	@Transient
	private String orderName;
	@Transient
	private Integer orderCost;
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Integer orderCost) {
		this.orderCost = orderCost;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Integer getNoOfOrders() {
		return noOfOrders;
	}
	public void setNoOfOrders(Integer noOfOrders) {
		this.noOfOrders = noOfOrders;
	}
	public Integer getCommision() {
		return commision;
	}
	public void setCommision(Integer commision) {
		this.commision = commision;
	}
}
