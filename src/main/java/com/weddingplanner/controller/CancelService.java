package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.weddingplanner.daoimpl.BookingServicesDaoimpl;
import com.weddingplanner.daoimpl.UserDaoimpl;

@WebServlet("/cancelService")
public class CancelService extends HttpServlet

{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookingServicesDaoimpl book = new BookingServicesDaoimpl();
			HttpSession session = request.getSession();
			UserDaoimpl userdao = new UserDaoimpl();
			int userId = (int) session.getAttribute("id");
			Double servicePackage = (Double) session.getAttribute("servicePackageName");
			int bookingServiceid = Integer.parseInt(request.getParameter("serviceBookingId"));
			boolean flag = book.checkCancelServiceBooking(bookingServiceid);
			int days = book.validateCancelBooking(bookingServiceid);
			if (!flag) {
				if (days > 0) {
					int walletBalance = 0;
					float deductAmount=(float) 0.2;
					walletBalance = userdao.walletbal(userId);
					session.setAttribute("cancelWallet", walletBalance);
					int payWallet = (int) (walletBalance + (servicePackage - (servicePackage * deductAmount)));
					session.setAttribute("RefundBalance", payWallet);
					book.cancelServiceBooking(bookingServiceid);
					response.sendRedirect("serviceCancel.jsp");
					session.setAttribute("serviceCancelled", "Your services are successfully cancelled");
				} else {
					session.setAttribute("notCancelled", "Nope!You can't cancel the Booking");
					response.sendRedirect("cancelVenueDate.jsp");
				}
			} else {
				session.setAttribute("dateCancelled", "You can't cancel the booking ! You already cancel this Booking");
				response.sendRedirect("cancelDate.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
