package com.example.demo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistence.entity.Customer;

public interface ICustomerCrudRepository extends JpaRepository<Customer, String>{
	
	//@Query()
	 Optional<Customer> findByEmail(String email);
	 

}
