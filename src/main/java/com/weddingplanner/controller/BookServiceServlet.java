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
import com.weddingplanner.model.BookingServices;

@WebServlet("/addToService")

public class BookServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("id");
			int serviceId = (int) session.getAttribute("serviceId");
			String servicename = request.getParameter("servicename");
			LocalDate eventDate = LocalDate.parse(request.getParameter("date"));
			Double servicePackage = Double.parseDouble(request.getParameter("servicepackage"));
			int advanceAmount = Integer.parseInt(request.getParameter("advancepackageService"));
			BookingServicesDaoimpl book = new BookingServicesDaoimpl();
			boolean flag = book.checkDate(servicename, eventDate);
			if (!flag) {
				UserDaoimpl userdao = new UserDaoimpl();
				int walletBalance = 0;
				walletBalance = userdao.walletbal(userId);
				session.setAttribute("userWalletBalance", walletBalance);
				int payWallet = (walletBalance - advanceAmount);
				session.setAttribute("servicePayBalance", payWallet);
				if (advanceAmount <= walletBalance) {

					BookingServices bookservice = new BookingServices(userId, serviceId, servicename, eventDate,
							servicePackage);
					book.bookService(bookservice);
					userdao.updatewalletBalance(payWallet, userId);
					response.sendRedirect("serviceBook.jsp");
					session.setAttribute("servicebooked", "Your services are successfully booked");

				} else {
					response.sendRedirect("balance.jsp");
					session.setAttribute("lowBalance", "Low balance!please recharge your wallet");

				}

			} else {
				response.sendRedirect("serviceUnavailable.jsp");
				session.setAttribute("unavailable", "This service already booked on this date");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
