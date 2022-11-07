package com.medplus.employee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

/**
 * Servlet implementation class AddDepartment
 */
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptname = request.getParameter("deptname");
		String location = request.getParameter("location");
		
		DepartmentService service = new DepartmentServiceImpl();
		List<Department> depts = service.getAllDepartments();
		
		RequestDispatcher rd;
		
		boolean isDepartmentPresent = false;
		for(Department dept: depts) {
			if((dept.getDeptName()).equals(deptname)) {
				isDepartmentPresent = true;
				break;
			}
		}
		
		if(isDepartmentPresent) {
			rd = request.getRequestDispatcher("AddDepartment.jsp");
			request.setAttribute("location", location);
			request.setAttribute("deptnameError","<p style='color:red; margin-top:0px;'>*Department already exist</p>");
		}
		else {
			int deptno = 0;
			if(depts.size() == 0)
				deptno = 10;
			else
				deptno = depts.get(depts.size()-1).getDeptno() + 10;
			Department dept = new Department(deptno, deptname, location);
			service.addDepartment(dept);
			rd = request.getRequestDispatcher("GetDepartments");
		}
		
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
