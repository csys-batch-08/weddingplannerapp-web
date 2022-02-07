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
import com.weddingplanner.model.Venues;

@WebServlet("/ViewVenueAdminServlet")
public class ViewVenueAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VenuesDaoimpl venueDao = new VenuesDaoimpl();
			List<Venues> venueList = venueDao.showVenueAdmin();
			request.setAttribute("venueListAdmin", venueList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewVenueAdmin.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
