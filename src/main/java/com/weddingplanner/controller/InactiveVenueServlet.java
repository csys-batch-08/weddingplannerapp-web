package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.VenuesDaoimpl;

@WebServlet("/inactiveVenue")
public class InactiveVenueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VenuesDaoimpl venueDaoimpl = new VenuesDaoimpl();
		int venueId = Integer.parseInt(request.getParameter("venueIdAdmin"));
		boolean flag = venueDaoimpl.inactiveVenue(venueId);
		if (flag) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("viewVenueAdmin.jsp?inactiveVenue=Inactive Successfully");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("viewVenueAdmin.jsp?inactiveError=not inactive successfully");
		}
	}

}
