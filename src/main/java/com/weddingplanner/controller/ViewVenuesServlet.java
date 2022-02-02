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
import com.weddingplanner.model.Venues;

@WebServlet("/ViewVenuesServlet")
public class ViewVenuesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VenuesDaoimpl venueDaoImpl = new VenuesDaoimpl();
		List<Venues> showVenue = venueDaoImpl.showVenue();
		try {
			request.setAttribute("showVenue", showVenue);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewVenues.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
