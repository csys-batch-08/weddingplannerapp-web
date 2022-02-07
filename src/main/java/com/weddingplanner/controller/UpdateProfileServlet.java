package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.model.User;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			long phoneno = (Long.parseLong(request.getParameter("phonenumber")));
			String city = request.getParameter("city");
			String email = (String) session.getAttribute("email");
			User user = new User(username, phoneno, city, email, null, 0);
			UserDaoimpl userdao = new UserDaoimpl();
			userdao.updateUserProfile(user);
			response.sendRedirect("userProfile.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
