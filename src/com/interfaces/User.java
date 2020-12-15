package com.interfaces;

import com.model.Employee;
import com.model.Login;

public interface User {
	
	public boolean register(Employee employee);
	public boolean login(Login login);

}
