package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.module.User;

/**
 * Servlet implementation class ViewUserAdminServlet
 */
@WebServlet("/ViewUserAdminServlet")
public class ViewUserAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UserDaoimpl userdao = new UserDaoimpl();
		   List<User> userList = userdao.viewUser();
		   request.setAttribute("userListAdmin", userList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewUser.jsp");
				requestDispatcher.forward(request, response);
	
	}

	

}
