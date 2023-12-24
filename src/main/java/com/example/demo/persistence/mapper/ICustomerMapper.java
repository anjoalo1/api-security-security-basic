package com.example.demo.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.persistence.entity.Customer;

@Mapper(componentModel="spring")
public interface ICustomerMapper {
	
	
	CustomerPojo toCustomerPojo(Customer customer);
	
	Customer toCustomer(CustomerPojo customerPojo);
	
	List<CustomerPojo> toCustomerPojo(List<Customer> customer);

}
