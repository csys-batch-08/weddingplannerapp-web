package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetVenueUpdate")
public class GetVenueUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int venueId = Integer.parseInt(request.getParameter("venueIdShow"));
			session.setAttribute("venueIdView", venueId);
			String venueName = request.getParameter("venueNameShow");
			session.setAttribute("venueNameView", venueName);
			String venueVendorName = request.getParameter("venueVendorNameShow");
			session.setAttribute("venueVendorNameView", venueVendorName);

			Long contactNumber = Long.parseLong(request.getParameter("contactNumberShow"));
			session.setAttribute("contactNumberView", contactNumber);

			Double venuePackage = Double.parseDouble(request.getParameter("venuePackageShow"));
			session.setAttribute("venuePackageView", venuePackage);
			String venueType = request.getParameter("venueTypeShow");
			session.setAttribute("venueTypeView", venueType);
			String venueDescription = request.getParameter("venueDescriptionShow");
			session.setAttribute("venueDescriptionShow", venueDescription);
			String venueImage = request.getParameter("venueImageShow");
			session.setAttribute("venueImageView", venueImage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateVenue.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
