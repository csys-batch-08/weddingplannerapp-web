package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.model.Services;

@WebServlet("/insertServices")
public class ServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ServicesDaoimpl serviceDao = new ServicesDaoimpl();
			String serviceName = request.getParameter("serviceName");
			Double servicePackage = Double.parseDouble(request.getParameter("servicePackage"));
			String serviceImage = request.getParameter("image");
			String serviceAvailability = request.getParameter("availability");
			String serviceType = request.getParameter("type");
			String serviceDescription = request.getParameter("description");
			String serviceTypeImage = request.getParameter("serviceTypeImage");
			Services service = new Services(serviceName, servicePackage, serviceImage, serviceAvailability, serviceType,
					serviceDescription, serviceTypeImage);
			serviceDao.insertService(service);
			response.sendRedirect("viewServicesAdmin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
