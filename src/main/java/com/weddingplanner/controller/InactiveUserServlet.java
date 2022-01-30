package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.weddingplanner.daoimpl.UserDaoimpl;



@WebServlet("/inactiveUser")
public class InactiveUserServlet extends HttpServlet {
	
       
   
	private static final long serialVersionUID = 1L;

	@Override
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserDaoimpl userdao=new UserDaoimpl();
        int userId=Integer.parseInt(request.getParameter("userId"));
        userdao.inactiveUser(userId);
        
		
		
		
	}catch(Exception e) {
		e.printStackTrace();

	}
	}

}
