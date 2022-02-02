package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.ServicesDaoimpl;



@WebServlet("/InactiveServiceServlet")
public class InactiveServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  ServicesDaoimpl serviceDaoimpl=new ServicesDaoimpl();
		  String serviceName=request.getParameter("inactiveVenueName");
		  serviceDaoimpl.inactiveService(serviceName);
	      RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewServiceAdminServlet");
		  requestDispatcher.forward(request, response);
	}

}
