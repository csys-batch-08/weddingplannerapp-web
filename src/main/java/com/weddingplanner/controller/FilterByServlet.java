package com.weddingplanner.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.model.Services;

@WebServlet("/filterPrice")
public class FilterByServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Double servicePackage = Double.parseDouble(request.getParameter("byPrice"));
			ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
			List<Services> serviceList = serviceDaoImpl.filterByPrice(servicePackage);
			request.setAttribute("servicePrice", serviceList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("filterPrice.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
