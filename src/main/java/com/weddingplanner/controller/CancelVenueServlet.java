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



@WebServlet("/cancelVenue")
public class CancelVenueServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session=request.getSession();
       int userId=(int) session.getAttribute("id");
       String venueName=(String)session.getAttribute("venueBookingName");
	   Double venuePackage=(Double) session.getAttribute("venueBookingPackage");
       BookingVenuesDaoimpl bookVenue=new BookingVenuesDaoimpl();
       LocalDate eventDate=(LocalDate)session.getAttribute("venueBookingEventDate");
      
       int bookingVenueid=Integer.parseInt(request.getParameter("venueBookingId"));

       int days=bookVenue.validateCancelBooking(bookingVenueid);
       UserDaoimpl userdao=new UserDaoimpl();
       boolean flag=bookVenue.checkCancelBooking( venueName, eventDate);
       if(!flag) {
       if(days>0) {
    	   
       int walletBalance=0;
		walletBalance=userdao.walletbal(userId);
		session.setAttribute("cancelVenue",walletBalance);

		int payWallet=(int) (walletBalance+(venuePackage-(venuePackage*0.2)));
		session.setAttribute("cancelRefundVenue",payWallet);

		
		
			
			
				bookVenue.cancelBooking(userId,venueName,eventDate);
		         session.setAttribute("cancelled", "venue sucessfully cancelled");
		         response.sendRedirect("cancelBookingMsg.jsp");
		         
			}
		
       else
       {
    	   session.setAttribute("notCancelled","Nope!You can't cancel the Booking" );
    	   response.sendRedirect("cancelVenueDate.jsp");
       }

	
       }else {
    	   session.setAttribute("dateCancelled","You can't cancel the Booking ! You already cancel this Booking" );
    	   response.sendRedirect("cancelDate.jsp");
    	   
       }

	}catch(Exception e) {
		e.printStackTrace();

	}
	}
		         
		
	}


