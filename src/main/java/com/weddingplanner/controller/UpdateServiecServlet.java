package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.model.Services;

@WebServlet("/updateService")
public class UpdateServiecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String serviceName = request.getParameter("serviceNameShow");
			Double servicePackage = Double.parseDouble(request.getParameter("servicePackageShow"));
			String serviceImage = request.getParameter("serviceImageShow");
			String serviceType = request.getParameter("typeShow");
			String serviceDescription = request.getParameter("descriptionShow");
			String serviceTypeImage = request.getParameter("serviceTypeImageShow");
			Services service = new Services(serviceName, servicePackage, serviceImage, null, serviceType,
					serviceDescription, serviceTypeImage);
			ServicesDaoimpl serviceDao = new ServicesDaoimpl();
			serviceDao.updateService(service);
			response.sendRedirect("viewServicesAdmin.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
