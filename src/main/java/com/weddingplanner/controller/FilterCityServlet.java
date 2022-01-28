package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.module.Venues;


@WebServlet("/filterCity")
public class FilterCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city=request.getParameter("search");
		
		VenuesDaoimpl venue=new VenuesDaoimpl();
		List<Venues> showVenue=venue.findCity(city);
		
		System.out.println(showVenue);
		
		request.setAttribute("searchCity",showVenue);
		RequestDispatcher requestdispatcher= request.getRequestDispatcher("FilterCity.jsp");
		requestdispatcher.forward(request, response);
	}

}
