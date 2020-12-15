package com.model;

public class Employee {
	
	private String empName;
	private String email;
	private String city;
	
	public Employee(String empName, String email, String city) {
		super();
		this.empName = empName;
		this.email = email;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}

