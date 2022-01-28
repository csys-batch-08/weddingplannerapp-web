package com.weddingplanner.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.daoimpl.UserDaoimpl;

/**
 * Servlet implementation class CancelService
 */
@WebServlet("/cancelService")
public class CancelService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelService() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BookingServicesDaoimpl book = new BookingServicesDaoimpl();
		HttpSession session = request.getSession();
        UserDaoimpl userdao=new UserDaoimpl();
		int userId=(int) session.getAttribute("id");
		
		String servicename = (String) session.getAttribute("serviceBookingName");
		System.out.println(servicename);
        LocalDate eventDate=(LocalDate)session.getAttribute("serviceEventDate");
        System.out.println(eventDate);
		Double servicePackage=(Double) session.getAttribute("servicePackageName");
	       int bookingServiceid=Integer.parseInt(request.getParameter("serviceBookingId"));
	       System.out.println(bookingServiceid);
	       boolean flag=book.checkCancelServiceBooking(bookingServiceid);
   
	    int days=book.validateCancelBooking(bookingServiceid);
        if(flag==false) {
		if(days>0) {
		int walletBalance=0;
		walletBalance=userdao.walletbal(userId);
		session.setAttribute("cancelWallet",walletBalance);
		int payWallet=(int) (walletBalance+(servicePackage-(servicePackage*0.2)));
		session.setAttribute("RefundBalance",payWallet);

			int balance=userdao.updatewalletBalance(payWallet, userId);
			
				book.cancelServiceBooking(bookingServiceid);
				 response.sendRedirect("ServiceCancel.jsp");
				 session.setAttribute("serviceCancelled", "Your services are successfully cancelled");
			}
			
			
			
		 else
	       {
	    	   session.setAttribute("notCancelled","Nope!You can't cancel the Booking" );
	    	   response.sendRedirect("CancelVenueDate.jsp");
	       }
        }else {
        	session.setAttribute("dateCancelled","You can't cancel the booking ! You already cancel this Booking" );
     	   response.sendRedirect("CancelDate.jsp");
     	   
        }
	}
	
		

		}
	
	