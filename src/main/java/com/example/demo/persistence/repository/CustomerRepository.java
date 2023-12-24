package com.example.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.repository.ICustomerRepository;
import com.example.demo.persistence.entity.Customer;
import com.example.demo.persistence.entity.Usuario;
import com.example.demo.persistence.mapper.ICustomerMapper;


@Repository
public class CustomerRepository implements ICustomerRepository{
	
	private final ICustomerMapper iCustomerMapper;
	private final ICustomerCrudRepository iCustomerCrudRepository;
	
	

	public CustomerRepository(ICustomerMapper iCustomerMapper, ICustomerCrudRepository iCustomerCrudRepository) {
		this.iCustomerMapper = iCustomerMapper;
		this.iCustomerCrudRepository = iCustomerCrudRepository;
	}

	@Override
	public List<CustomerPojo> getAll() {
		// TODO Auto-generated method stub
		return iCustomerMapper.toCustomerPojo(iCustomerCrudRepository.findAll());
	}

	@Override
	public Optional<CustomerPojo> getCustomerById(String cardId) {
		// TODO Auto-generated method stub
		return iCustomerCrudRepository.findById(cardId).map(Customer->iCustomerMapper.toCustomerPojo(Customer));
	}

	@Override
	public Optional<CustomerPojo> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return iCustomerCrudRepository.findByEmail(email).map(Customer->iCustomerMapper.toCustomerPojo(Customer));
	}
	
	

	
	

	@Override
	public CustomerPojo save(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		Customer customer = iCustomerMapper.toCustomer(customerPojo);
		return iCustomerMapper.toCustomerPojo(iCustomerCrudRepository.save(customer));
	}

	@Override
	public void delete(String cardId) {
		// TODO Auto-generated method stub
		
		iCustomerCrudRepository.deleteById(cardId);
		
	}




}
