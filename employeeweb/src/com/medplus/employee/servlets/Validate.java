package com.medplus.employee.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medplus.employee.beans.User;
import com.medplus.employee.service.UserService;
import com.medplus.employee.service.UserServiceImpl;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		UserService service = new UserServiceImpl();
		User user = service.getUser(username);
		
		RequestDispatcher rd;
		
		if(user != null) {
			if(password.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				session.setAttribute("role", user.getRole());
				rd = request.getRequestDispatcher("WelcomePage.jsp");
			}
			else {
				rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("username", username);
				request.setAttribute("errorMsg", "<p style='color: red; text-align: left; margin-top: 0;'>*Incorrect password</p>");
			}
		}
		else {
			rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("usernameError","<p style='color: red; text-align: left; margin-top: 0;'>*Incorrect Username</p>");
		}
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
