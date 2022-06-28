package com.garage.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.userlogin.model.UserPlan;

@Repository
public interface UserPlanRepository extends JpaRepository<UserPlan,Long>{

}
