package com.garage.userlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_plan")
public class UserPlan {

	@Id
	@Column(name  = "id")
	private Long planId;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "no_of_reg")
	private Integer noOfRegUser;
}
