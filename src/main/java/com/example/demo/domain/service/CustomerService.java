package com.example.demo.domain.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.ResponseCustomerPojo;
import com.example.demo.domain.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	
	private final ICustomerRepository iCustomerRepository;
	
	

	public CustomerService(ICustomerRepository iCustomerRepository) {
		this.iCustomerRepository = iCustomerRepository;
	}

	@Override
	public List<CustomerPojo> getAll() {
		// TODO Auto-generated method stub
		return iCustomerRepository.getAll();
	}

	@Override
	public Optional<CustomerPojo> getCustomerById(String cardId) {
		// TODO Auto-generated method stub
		return iCustomerRepository.getCustomerById(cardId);
	}

	@Override
	public Optional<CustomerPojo> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return iCustomerRepository.getCustomerByEmail(email);
	}

	@Override
	public ResponseCustomerPojo save(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		String passwordGenerated = generateRandomPassword(8);
		customerPojo.setPassword(passwordGenerated);
		customerPojo.setActive(1);
		iCustomerRepository.save(customerPojo);
		//ResponseCustomerPojo responseCustomerPojo = new ResponseCustomerPojo(passwordGenerated);
		return new ResponseCustomerPojo(passwordGenerated);
	}
	
	

	@Override
	public boolean delete(String cardId) {
		// TODO Auto-generated method stub
		
		if(iCustomerRepository.getCustomerById(cardId).isEmpty()) {
			return false;
		}
		
		iCustomerRepository.delete(cardId);
		return true;
	}
	
	private String generateRandomPassword(int len) {
		
		final String chars ="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<len; i++) {
			int randombIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randombIndex));
		}
		
		return sb.toString();
	}

	@Override
	public Optional<CustomerPojo> update(CustomerPojo customerPojo) {
		// TODO Auto-generated method stub
		if(iCustomerRepository.getCustomerById(customerPojo.getCardId()).isPresent()) {
			return Optional.empty();
		}
		return Optional.of(iCustomerRepository.save(customerPojo));
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
