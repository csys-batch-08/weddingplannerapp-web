package com.weddingplanner.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.model.BookingServices;

@WebServlet("/FilterDateServiceServlet")
public class FilterDateServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LocalDate eventDate = LocalDate.parse(request.getParameter("search"));
			BookingServicesDaoimpl service = new BookingServicesDaoimpl();
			List<BookingServices> showVenue = service.filterByDate(eventDate);
			request.setAttribute("searchDateService", showVenue);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("filterDateService.jsp");
			requestdispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
