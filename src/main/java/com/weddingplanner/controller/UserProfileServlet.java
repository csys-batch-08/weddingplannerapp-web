package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.UserDaoimpl;
import com.weddingplanner.model.User;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int userId = (int) session.getAttribute("id");
			UserDaoimpl userdao = new UserDaoimpl();
			List<User> userList = userdao.currentuserprofile(userId);
			request.setAttribute("userProfile", userList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userProfile.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
