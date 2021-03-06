package com.weddingplanner.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.BookingVenuesDaoimpl;
import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.model.BookingVenues;

@WebServlet("/book")

public class BookVenueServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   try {
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("id");
			int venueId = (int) session.getAttribute("venueId");
			String venuename = request.getParameter("venuename");
			request.setAttribute("venuename", venuename);
			int noOfGuest = Integer.parseInt(request.getParameter("noOfGuest"));
			Double venuePackage = Double.parseDouble(request.getParameter("venuepackage"));
			request.setAttribute("venueBookPackage", venuePackage);
			int advanceAmount = Integer.parseInt(request.getParameter("advancepackage"));
			session.setAttribute("advanceAmount", advanceAmount);
			LocalDate eventDate = LocalDate.parse(request.getParameter("eventDate"));
			session.setAttribute("eventdate", eventDate);
			BookingVenuesDaoimpl bookVenue = new BookingVenuesDaoimpl();
			int bookingVenueId = bookVenue.findBookingVenueId(userId, eventDate, venuename);
			session.setAttribute("bookingVenueId", bookingVenueId);
			boolean flag = bookVenue.checkDate(venuename, eventDate);
			if (!flag) {
				UserDaoimpl userdao = new UserDaoimpl();
				int walletBalance = 0;
				walletBalance = userdao.walletbal(userId);
				session.setAttribute("venueBalance", walletBalance);
				int payWallet = (walletBalance - advanceAmount);
				session.setAttribute("venuePayBalance", payWallet);
				if (advanceAmount <= walletBalance) {
					userdao.updateWalletBalance(payWallet, userId);
					BookingVenues book = new BookingVenues(userId, venueId, venuename, noOfGuest, eventDate,
							venuePackage, advanceAmount);
					bookVenue.bookVenue(book);
					session.setAttribute("booked", "venue sucessfully booked");
					response.sendRedirect("venueBooked.jsp");

				} else {
					response.sendRedirect("balance.jsp");
					session.setAttribute("lowBalance", "Low balance!please recharge your wallet");
				}
			} else {
				response.sendRedirect("venueUnavailable.jsp");
				session.setAttribute("unavailable", "This venue already booked on this date");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}	
	


