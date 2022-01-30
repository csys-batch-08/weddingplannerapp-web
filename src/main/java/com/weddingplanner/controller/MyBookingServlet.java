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
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.daoimpl.BookingVenuesDaoimpl;
import com.weddingplanner.module.BookingServices;
import com.weddingplanner.module.BookingVenues;


@WebServlet("/MyBookingServlet")
public class MyBookingServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        BookingServicesDaoimpl service = new BookingServicesDaoimpl();
		try {
		 int userId=(int)session.getAttribute("id");
		 List<BookingServices> myService=service.myBooking(userId);
		request.setAttribute("booking", myService);
		for (BookingServices bookService: myService ) {
		String serviceBookingName=bookService.getServiceName();
		session.setAttribute("serviceBookingName", serviceBookingName);
		Double servicePackageName=bookService.getServicePackage();
		session.setAttribute("servicePackageName", servicePackageName); 
		LocalDate serviceEventDate=bookService.getEventDate();
		session.setAttribute("serviceEventDate", serviceEventDate);
        LocalDate bookingDate=service.findBookingDate(userId);
		session.setAttribute("bookingDate", bookingDate);
		int serviceBookingId=service.findBookingServiceId(userId, bookService.getEventDate(),bookService.getServiceName());
		request.setAttribute("serviceBookingId", serviceBookingId);
		String status=service.findStatus(bookService.getServiceName(),bookService.getEventDate());
		request.setAttribute("status", status);
		}
		BookingVenuesDaoimpl venues = new BookingVenuesDaoimpl();
		List<BookingVenues> myVenue=venues.myBooking(userId);
		request.setAttribute("bookingVenue", myVenue);
		for (BookingVenues bookVenue: myVenue ) {
		 String venueBookingName=bookVenue.getVenueName();
		 session.setAttribute("venueBookingName", venueBookingName);
		 double venueBookingPackage=bookVenue.getVenuePackage();
		 session.setAttribute("venueBookingPackage", venueBookingPackage);
		 LocalDate venueEventDate=bookVenue.getEventDate();
		 session.setAttribute("venueBookingEventDate", venueEventDate);
		 LocalDate venueBookingDate=venues.findVenueBookingDate(userId);
		 session.setAttribute("venueBookingDate", venueBookingDate);
		 int venueBooking=venues.findBookingVenueId(userId,bookVenue.getEventDate(),bookVenue.getVenueName());
		 request.setAttribute("venueBookingId", venueBooking);
		 String venueStatus=venues.findStatus(bookVenue.getVenueName(),bookVenue.getEventDate());
		 request.setAttribute("venueStatus", venueStatus);
		 
		}
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("myBooking.jsp");
		requestDispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();

		}
	}
		
		
		

	

	

}
