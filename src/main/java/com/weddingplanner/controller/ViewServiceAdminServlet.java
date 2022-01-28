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

/**
 * Servlet implementation class ViewServiceAdminServlet
 */
@WebServlet("/ViewServiceAdminServlet")
public class ViewServiceAdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServicesDaoimpl serviceDao = new ServicesDaoimpl();
		   List<Services> serviceList=serviceDao.showServices();
		   request.setAttribute("serviceListAdmin", serviceList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewServicesAdmin.jsp");
				requestDispatcher.forward(request, response);
		  
		    
	}

	

}
