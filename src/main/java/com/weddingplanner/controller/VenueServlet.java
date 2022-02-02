package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.model.Venues;


@WebServlet("/insert")
public class VenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	VenuesDaoimpl venueDao=new VenuesDaoimpl();
	   try {
		String venueName=request.getParameter("venueName");
		String venueArea=request.getParameter("venueArea");
		String venueCity=request.getParameter("city");
		String venueType=request.getParameter("venueType");
		String venueVendorName=request.getParameter("vendorName");
		Long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
		Double venuePackage=Double.parseDouble(request.getParameter("venuePackage"));
		String availability=request.getParameter("availability");
		String venueImages=request.getParameter("image");
		Venues venue=new Venues(venueName,venueArea,venueCity,venueType,venueVendorName,contactNumber,venuePackage,availability,venueImages);
	    venueDao.insertVenue(venue);
	    
	   
	    response.sendRedirect("viewVenueAdmin");
	    
	    
	   } catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
}
