package com.weddingplanner.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.daoimpl.BookingVenuesDaoimpl;
import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.module.BookingServices;
import com.weddingplanner.module.BookingVenues;


@WebServlet("/addToService")

public class addToService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addToService() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		int userId=(int)session.getAttribute("id");
		System.out.println(userId);
		int serviceId=(int) session.getAttribute("serviceId");
	    System.out.println(serviceId);
		String servicename = request.getParameter("servicename");
	
        LocalDate eventDate=LocalDate.parse(request.getParameter("date"));

       
		Double servicePackage=Double.parseDouble(request.getParameter("servicepackage"));
		int advanceAmount = Integer.parseInt(request.getParameter("advancepackageService"));
		

		//LocalDate eventDat=LocalDate.parse(eventDate);
        BookingServicesDaoimpl book=new BookingServicesDaoimpl();
        boolean flag = book.checkDate(servicename, eventDate);
         if(!flag) {
        	 
        	 UserDaoimpl userdao=new UserDaoimpl();

		 		int walletBalance=0;
		 		walletBalance=userdao.walletbal(userId);
		 		session.setAttribute("userWalletBalance",walletBalance );
		 		int payWallet=(int) (walletBalance-servicePackage);
		 		session.setAttribute("servicePayBalance",payWallet );

		 		if(servicePackage<=walletBalance) {
		 			int balance=0;
		 			balance=userdao.updatewalletBalance(payWallet, userId);
		 			if(balance>0) {
        	 BookingServices bookservice=new BookingServices(userId,serviceId,servicename,eventDate,servicePackage);

             book.bookService(bookservice);
             response.sendRedirect("servicebook.jsp");
			 session.setAttribute("servicebooked", "Your services are successfully booked");
		     }
		 			 
		
		 		}else {
		 			response.sendRedirect("balance.jsp");
		 			session.setAttribute("lowBalance","Low balance!please recharge your wallet");
		 			
		 		}
       
		}else {
			response.sendRedirect("serviceUnavailable.jsp");
			session.setAttribute("unavailable", "This service already booked on this date");
		}
	}
}
         


		