package com.example.tts.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="user_Id")
	private int userId;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="user_Type")
	private String userType;
	
	@OneToOne(cascade=CascadeType.ALL )
	private Employee employee;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Employee getEmployee()
	{		
		
		
		return employee;
}
	public void setEmployee(Employee employee) {
	this.employee = employee;
	}
	


}
