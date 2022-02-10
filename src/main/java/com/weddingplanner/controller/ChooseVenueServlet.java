package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.VenuesDaoimpl;
import com.weddingplanner.model.Venues;

@WebServlet("/ChooseVenueServlet")
public class ChooseVenueServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String venuename = request.getParameter("venueName");
			VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
			HttpSession session = request.getSession();
			Venues venue = venueDaoImpl.allVenue(venuename);
			int venueId = venueDaoImpl.findVenueId(venue.getVenueName());
			double venuepackage = venueDaoImpl.findPackage(venueId);
			int advanceAmount = (int) (venuepackage * 1/2);
			session.setAttribute("venuename", venuename);
			session.setAttribute("venueId", venueId);
			session.setAttribute("venuepackage", venuepackage);
			session.setAttribute("advanceAmount", advanceAmount);
			request.setAttribute("venueShow", venue);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pickVenue.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
