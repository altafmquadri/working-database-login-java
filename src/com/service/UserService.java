package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBConnection;
import com.interfaces.User;
import com.model.Employee;
import com.model.Login;

public class UserService implements User {

	@Override
	public boolean register(Employee employee) {
		String SQL = "insert into employee(empName, email, city) values (?,?,?)";

		Connection conn = null;
		boolean isRegistered = false;

		try {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			PreparedStatement statement = conn.prepareStatement(SQL);

			System.out.println("Inserting values");

			statement.setString(1, employee.getEmpName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getCity());

			int i = statement.executeUpdate();
			if (i > 0) {
				isRegistered = true;
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isRegistered;
	}

	@Override
	public boolean login(Login login) {

		String SQL = "select empname, email from employee";
		Connection conn = null;
		PreparedStatement statement = null;
		boolean verified = false;

		try {
			DBConnection db = new DBConnection();
			conn = db.getConnection();
			statement = conn.prepareStatement(SQL);

			System.out.println("Fetching results");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (login.getEmpName().equals(rs.getString(1)) && login.getEmail().equals(rs.getString(2))) {
					verified = true;
					break;
				}
			}
			

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return verified;
	}

}
