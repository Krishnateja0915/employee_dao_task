package com.medplus.employee.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

public class UpdateEmployee {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("Enter Details");
		Employee emp = new Employee(Integer.parseInt(br.readLine()), br.readLine(),
				Double.parseDouble(br.readLine()), br.readLine());
		EmployeeService service = new EmployeeServiceImpl();
		int rows = service.updateEmployee(emp, br.readLine());
		if(rows > 0)
			System.out.println("updated");
		else
			System.out.println("not updated");
	}
}
