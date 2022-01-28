package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.module.BookingServices;

/**
 * Servlet implementation class ViewServiceBookingServlet
 */
@WebServlet("/ViewServiceBookingServlet")
public class ViewServiceBookingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 BookingServicesDaoimpl bookingdao = new BookingServicesDaoimpl();
		   List<BookingServices> serviceList = bookingdao.allServiceBooking();
		   request.setAttribute("serviceBookingAdmin", serviceList);
		     RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewServiceBooking.jsp");
				requestDispatcher.forward(request, response);
		
	}

	

}
