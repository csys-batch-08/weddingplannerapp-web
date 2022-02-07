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

import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.model.Services;

@WebServlet("/ShowServiceServlet")
public class ShowServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
			HttpSession session = request.getSession();
			String serviceType = request.getParameter("serviceType");
			List<Services> serviceList = serviceDaoImpl.showServiceList(serviceType);
			session.setAttribute("serviceType", serviceType);
			request.setAttribute("serviceShow", serviceList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("showService.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
