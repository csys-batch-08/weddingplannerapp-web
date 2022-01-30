package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.module.Venues;


@WebServlet("/update")
public class UpdateVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String venueName=request.getParameter("venueName");
		String venueVendorName=request.getParameter("venueVendorName");
		Long contactNumber=Long.parseLong(request.getParameter("contactNumber"));
		Double venuePackage=Double.parseDouble(request.getParameter("venuePackage"));
		String venueImage=request.getParameter("venueImage");
        Venues venue=new Venues(venueName,null,null,null,venueVendorName,contactNumber,venuePackage,null,venueImage);
		VenuesDaoimpl venueDao=new VenuesDaoimpl();
		venueDao.updateVenue(venue);
	    response.sendRedirect("viewVenueAdmin");
		}catch(Exception e) {
			e.printStackTrace();

		}

         
	}

}
