package com.medplus.employee.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employee.beans.Employee;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeService service = new EmployeeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("UpdateEmp.jsp");
		int code = Integer.parseInt(request.getParameter("code"));
		
		Employee emp = service.getById(code);
		DepartmentService deptService = new DepartmentServiceImpl();
		String deptname = deptService.getDeptName(emp.getDeptno());
		
		request.setAttribute("emp",emp);
		request.setAttribute("deptname",deptname);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println(code);
		String strSalary = request.getParameter("salary");
		String name = request.getParameter("name");
		String date = request.getParameter("doj");
		String deptName = request.getParameter("deptname");
		
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
			double salary = Double.parseDouble(strSalary);
			
			if(nameCheck) {
				EmployeeService service = new EmployeeServiceImpl();
				Employee emp = new Employee(code, name, salary, date);
				rows = service.updateEmployee(emp, deptName);
				rd = request.getRequestDispatcher("GetEmployees");
			}
			else {
				Employee emp = new Employee();
				emp.setEmpcode(code);
				emp.setDoj(date);
				emp.setSalary(salary);
				request.setAttribute("emp", emp);
				request.setAttribute("nameError", "<p style='color:red; margin-top:0px;'>*only alphabets allowed</p>");
				rd = request.getRequestDispatcher("UpdateEmp.jsp");
				rd.include(request, response);
			}
		}
		else {
			Employee emp = new Employee();
			emp.setEmpname(name);
			emp.setEmpcode(code);
			emp.setDoj(date);
			request.setAttribute("emp", emp);
			request.setAttribute("salaryError","<p style='color:red; margin-top:0px;'>*only numeric values accepted</p>");
			rd = request.getRequestDispatcher("UpdateEmp.jsp");
			rd.include(request,response);
		}
			
		if(rows > 0)
			rd.forward(request, response);
			
	}

}
