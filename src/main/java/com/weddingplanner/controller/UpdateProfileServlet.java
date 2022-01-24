package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.module.User;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		String username = request.getParameter("username");
		System.out.println(username);
		long phoneno = (Long.parseLong(request.getParameter("phonenumber")));
		String city = request.getParameter("city");
		String email=(String) session.getAttribute("email");
		User user = new User(username, phoneno, city, email, null,0);
		UserDaoimpl userdao = new UserDaoimpl();
		userdao.updateUserProfile(user);
		response.sendRedirect("userProfile.jsp");
		
	}

}
