package com.example.demo.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.ResponseCustomerPojo;

public interface ICustomerService {
List<CustomerPojo> getAll();
	
	
	Optional<CustomerPojo> getCustomerById(String cardId);
	
	Optional<CustomerPojo> getCustomerByEmail(String email);
	
	
	ResponseCustomerPojo save(CustomerPojo customerPojo);
	
	Optional<CustomerPojo> update(CustomerPojo customerPojo);
	
	
	boolean delete(String cardId);


}
