package com.weddingplanner.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	try 
	{
			HttpSession session=request.getSession();
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			UserDaoimpl userDetailDao=new  UserDaoimpl();
			
			User validAdmin;
			validAdmin = userDetailDao.validateAdmin(email,password);
			User validUser=userDetailDao.validateUser(email, password);
			int userId=userDetailDao.findUserId(email);
	
			
			session.setAttribute("id", userId);
			session.setAttribute("email", email);

			if (validAdmin !=null)
			   {

				RequestDispatcher rq=request.getRequestDispatcher("admin.jsp");

				 rq.forward(request, response);


				 
			   }
			 else if(validUser != null) 
			 {
				
				 RequestDispatcher rq=request.getRequestDispatcher("home.jsp");
				 rq.forward(request, response);
	         }
			 else {
				 session.setAttribute("login", "invalid user!!");
				 response.sendRedirect("index.jsp");
			
			 }
		} 
	     catch (Exception e) 
	      {
			e.printStackTrace();
		   }
		
		} 
  }


