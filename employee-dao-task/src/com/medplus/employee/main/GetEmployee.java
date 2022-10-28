package com.medplus.employee.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class GetEmployee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		EmployeeService service = new EmployeeServiceImpl();
		System.out.println("Enter Employee Code");
		Employee emp = service.getById(Integer.parseInt(br.readLine()));
		if(emp != null) 
			System.out.println(emp);
		else
			System.out.println("Employee not exist");
	}
}
