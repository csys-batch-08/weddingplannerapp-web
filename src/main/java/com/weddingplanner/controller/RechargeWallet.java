package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.UserDaoimpl;

@WebServlet("/rechargewallet")
public class RechargeWallet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			int userId = (int) session.getAttribute("id");

			int amount = Integer.parseInt(request.getParameter("amount"));
			session.setAttribute("amount", amount);

			UserDaoimpl userdao = new UserDaoimpl();
			userdao.updatewallet(amount, userId);
			session.setAttribute("recharged", "Your Wallet is sucessfully recharged");
			response.sendRedirect("UserProfileServlet");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
