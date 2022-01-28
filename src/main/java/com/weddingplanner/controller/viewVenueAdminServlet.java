package com.weddingplanner.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.module.Venues;

/**
 * Servlet implementation class viewVenueAdminServlet
 */
@WebServlet("/viewVenueAdminServlet")
public class viewVenueAdminServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VenuesDaoimpl venueDao = new VenuesDaoimpl();
		   List<Venues> venueList = venueDao.showVenue();
		   System.out.println(venueList);
		  request.setAttribute("venueListAdmin", venueList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewVenueAdmin.jsp");
				requestDispatcher.forward(request, response);
		
	}

	

}
