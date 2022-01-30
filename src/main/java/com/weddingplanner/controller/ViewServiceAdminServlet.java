package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.module.Services;


@WebServlet("/ViewServiceAdminServlet")
public class ViewServiceAdminServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
		ServicesDaoimpl serviceDao = new ServicesDaoimpl();
		   List<Services> serviceList=serviceDao.showServices();
		   request.setAttribute("serviceListAdmin", serviceList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewServicesAdmin.jsp");
				requestDispatcher.forward(request, response);
		  
		    
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	}

	

}
