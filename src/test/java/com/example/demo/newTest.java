package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.ResponseCustomerPojo;
import com.example.demo.domain.service.CustomerService;

public class newTest {
	
	private final CustomerService customerService;
	
	
	public newTest(CustomerService customerService) {
		this.customerService = customerService;
	}


	@Test
	 public ResponseCustomerPojo probar() {
		
		CustomerPojo customerPojo = new CustomerPojo();
		customerPojo.setActive(1);
		customerPojo.setCardId("123");
		customerPojo.setEmail("carlos@gmail.com");
		customerPojo.setFullName("danier");
		customerPojo.setNumberCellPhone(165465L);
		customerPojo.setPassword("123465");
		
		return customerService.save(customerPojo); 
	}
	
	@Test
	public void probarMetodo() {
		probar();
	}


}
