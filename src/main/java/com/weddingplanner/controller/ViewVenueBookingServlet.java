package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.BookingVenuesDaoimpl;
import com.weddingplanner.model.BookingVenues;


@WebServlet("/ViewVenueBookingServlet")
public class ViewVenueBookingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		BookingVenuesDaoimpl bookingdao = new BookingVenuesDaoimpl();
		   List<BookingVenues> venueList = bookingdao.allBookings();
		   request.setAttribute("venueBookingAdmin", venueList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewAllBookings.jsp");
				requestDispatcher.forward(request, response);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	

}
