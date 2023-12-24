package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.CustomerPojo;



public interface ICustomerRepository {
	
List<CustomerPojo> getAll();
	
	
	Optional<CustomerPojo> getCustomerById(String cardId);
	
	Optional<CustomerPojo> getCustomerByEmail(String email);
	

	
	CustomerPojo save(CustomerPojo customerPojo);
	
	
	void delete(String cardId);

}
