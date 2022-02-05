package com.weddingplanner.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetServiceUpdate")
public class GetServiceUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int serviceId = Integer.parseInt(request.getParameter("serviceIdShow"));
			session.setAttribute("serviceIdView", serviceId);
			String serviceName = request.getParameter("serviceNameShow");
			session.setAttribute("serviceNameView", serviceName);
            Double servicePackage = Double.parseDouble(request.getParameter("servicePackageShow"));
			session.setAttribute("servicePackageView", servicePackage);
			String serviceType = request.getParameter("serviceTypeShow");
			session.setAttribute("serviceTypeView", serviceType);
			String serviceDescription = request.getParameter("serviceDescriptionShow");
			session.setAttribute("serviceDescriptionView", serviceDescription);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateService.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
