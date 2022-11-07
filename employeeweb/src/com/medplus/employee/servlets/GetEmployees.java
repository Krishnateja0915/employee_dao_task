package com.medplus.employee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.employee.beans.Department;
import com.medplus.employee.dto.EmployeeDto;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;
import com.medplus.employee.service.EmployeeService;
import com.medplus.employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class GetEmployees
 */
public class GetEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService service = new EmployeeServiceImpl();
		DepartmentService dservice = new DepartmentServiceImpl();
		List<EmployeeDto> emplist = service.getAll();
		List<Department> depts = dservice.getAllDepartments();
		RequestDispatcher rd = request.getRequestDispatcher("GetEmployees.jsp");
		request.setAttribute("empls", emplist);
		
		HttpSession session = request.getSession();
		session.setAttribute("depts", (Object)depts);
		
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
