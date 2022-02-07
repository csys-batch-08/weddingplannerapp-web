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
import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.daoimpl.BookingVenuesDaoimpl;
import com.weddingplanner.model.BookingServices;
import com.weddingplanner.model.BookingVenues;

@WebServlet("/MyBookingServlet")
public class MyBookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookingServicesDaoimpl service = new BookingServicesDaoimpl();
		try {
			int userId = (int) session.getAttribute("id");
			List<BookingServices> myService = service.myBooking(userId);
			request.setAttribute("booking", myService);
			for (BookingServices bookService : myService) {
				Double servicePackageName = bookService.getServicePackage();
				session.setAttribute("servicePackageName", servicePackageName);
			}
			BookingVenuesDaoimpl venues = new BookingVenuesDaoimpl();
			List<BookingVenues> myVenue = venues.myBooking(userId);
			request.setAttribute("bookingVenue", myVenue);
			for (BookingVenues bookVenue : myVenue) {
				double venueBookingPackage = bookVenue.getVenuePackage();
				session.setAttribute("venueBookingPackage", venueBookingPackage);
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("myBooking.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
