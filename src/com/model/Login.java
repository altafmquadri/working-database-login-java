package com.model;

public class Login {
	
	private String empName;
	private String email;
	
	
	
	public Login(String empName, String email) {
		super();
		this.empName = empName;
		this.email = email;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
