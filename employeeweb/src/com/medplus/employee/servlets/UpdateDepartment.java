package com.medplus.employee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medplus.employee.beans.Department;
import com.medplus.employee.service.DepartmentService;
import com.medplus.employee.service.DepartmentServiceImpl;

/**
 * Servlet implementation class UpdateDepartment
 */
public class UpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = service.getDept(deptno);
		request.setAttribute("deptno", dept.getDeptno());
		request.setAttribute("deptname", dept.getDeptName());
		request.setAttribute("location", dept.getLocation());
		RequestDispatcher rd = request.getRequestDispatcher("UpdateDept.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptname = request.getParameter("deptname");
		String location = request.getParameter("location");
		Department dept = new Department(deptno, deptname, location);
		
		DepartmentService service = new DepartmentServiceImpl();
		service.updateDept(dept);
		
		RequestDispatcher rd = request.getRequestDispatcher("GetDepartments");
		rd.forward(request,response);
	}

}
