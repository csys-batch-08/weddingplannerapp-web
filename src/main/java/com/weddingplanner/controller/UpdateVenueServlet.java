package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.model.Venues;

@WebServlet("/update")
public class UpdateVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int venueId = (int) session.getAttribute("venueIdView");
			String venueName = request.getParameter("venueNameShow");
			String venueVendorName = request.getParameter("venueVendorNameShow");
			Long contactNumber = Long.parseLong(request.getParameter("contactNumberShow"));
			Double venuePackage = Double.parseDouble(request.getParameter("venuePackage"));
			String venueImage = request.getParameter("venueImage");
			String venueType = request.getParameter("venueType");
			String venueDescription = request.getParameter("venueDescription");
			Venues venue = new Venues(venueName, venueType, venueVendorName, contactNumber, venuePackage, venueImage,
					venueId, venueDescription);
			VenuesDaoimpl venueDao = new VenuesDaoimpl();
			venueDao.updateVenue(venue);
			response.sendRedirect("ViewVenueAdminServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}