package com.medplus.employee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.dto.EmployeeDto;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strSalary = request.getParameter("salary");
		String name = request.getParameter("name");
		String date = request.getParameter("doj");
		String deptName = request.getParameter("deptname");
		
		request.setAttribute("doj",date);
		request.setAttribute("deptname", deptName);
		
		int rows = 0;
		RequestDispatcher rd = null;
		
		boolean salaryCheck = true;
		boolean nameCheck = true;
		
		for(int i=0; i<strSalary.length(); i++) {
			char letter = strSalary.charAt(i);
			if(!Character.isDigit(letter) && letter != '.') {
				salaryCheck = false;
				break;
			}
		}
		
		for(int i=0; i<name.length(); i++) {
			char letter = name.charAt(i);
			if(!Character.isLetter(letter)) {
				nameCheck = false;
				break;
			}
		}
		
		if(salaryCheck) {
			double salary = Double.parseDouble(request.getParameter("salary"));
			EmployeeService service = new EmployeeServiceImpl();
			List<EmployeeDto> emplist = service.getAll();
			int code;
			if(emplist.size() == 0) {
				code = 100;
			}
			else {
				code = emplist.get(emplist.size()-1).getEmpcode() + 1;
			}
			
			if(nameCheck) {
				Employee emp = new Employee(code, name, salary, date);
				rows = service.addEmployee(emp, deptName);
				rd = request.getRequestDispatcher("GetEmployees");
			}
			else {
				request.setAttribute("salary", salary);
				request.setAttribute("nameError", "<p style='color:red; margin-top:0px;'>*only alphabets allowed</p>");
				rd = request.getRequestDispatcher("AddEmployee.jsp");
				rd.include(request, response);
			}
		}
		else {
			request.setAttribute("name", name);
			request.setAttribute("salaryError","<p style='color:red; margin-top:0px'>*only numeric values accepted</p>");
			rd = request.getRequestDispatcher("AddEmployee.jsp");
			rd.include(request,response);
		}
			
		if(rows > 0)
			rd.forward(request, response);
	}

}
