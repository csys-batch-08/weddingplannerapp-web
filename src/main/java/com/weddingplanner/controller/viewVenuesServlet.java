package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.module.Venues;


@WebServlet("/viewVenuesServlet")
public class viewVenuesServlet extends HttpServlet {
	
	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
		List<Venues> showVenue=venueDaoImpl.showVenue();
		  
		request.setAttribute("showVenue", showVenue);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewVenues.jsp");
		requestDispatcher.forward(request,response);

		
	}

}
