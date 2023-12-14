package com.sarvagya.employeemanagementbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarvagya.employeemanagementbackend.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	

}
