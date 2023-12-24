package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.ResponseCustomerPojo;

import com.example.demo.domain.service.ICustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
	private final ICustomerService iCustomerService;

	
	
	public CustomerController(ICustomerService iCustomerService) {
		this.iCustomerService = iCustomerService;
	}

	@GetMapping
	public ResponseEntity<List<CustomerPojo>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(iCustomerService.getAll());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<CustomerPojo> getCustomerByCardId(@PathVariable String id){
		return ResponseEntity.of(iCustomerService.getCustomerById(id));
	}
	
	@GetMapping(path="/email/{email}")
	public ResponseEntity<CustomerPojo> getCustomerByEmail(@PathVariable String email){
		return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
	}
	
	@PostMapping
	public ResponseEntity<ResponseCustomerPojo> save(@RequestBody CustomerPojo customerPojo){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerService.save(customerPojo));
		}
		catch(Exception e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
		}	
	}
	
	@PutMapping
	public ResponseEntity<CustomerPojo> update(@RequestBody CustomerPojo customerPojo){
		return ResponseEntity.of(iCustomerService.update(customerPojo));
		
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id){
		return new ResponseEntity<>(this.iCustomerService.delete(id)? HttpStatus.OK :HttpStatus.NOT_FOUND);
	}
	
	

	

}
