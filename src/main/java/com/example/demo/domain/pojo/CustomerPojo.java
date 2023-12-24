package com.example.demo.domain.pojo;

import lombok.Getter;
import lombok.Setter;

public class CustomerPojo {
	
	
	private String fullName;
	private String email;
	private Long numberCellPhone;
	private Integer active;
	private String password;


public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getNumberCellPhone() {
		return numberCellPhone;
	}
	public void setNumberCellPhone(Long numberCellPhone) {
		this.numberCellPhone = numberCellPhone;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
private String cardId;
	
	

}
