package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.model.User;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String username = request.getParameter("username");
		long phoneno = (Long.parseLong(request.getParameter("phonenumber")));
		String city = request.getParameter("city");
		String emailid = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(username, phoneno, city, emailid, password,0);
		UserDaoimpl userdao = new UserDaoimpl();
		userdao.insertUser(user);
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();

	}
	}

}
