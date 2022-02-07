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

import com.weddingplanner.daoimpl.RatingsDaoimpl;
import com.weddingplanner.daoimpl.ServicesDaoimpl;
import com.weddingplanner.model.Ratings;
import com.weddingplanner.model.Services;

@WebServlet("/ChooseServiceServlet")
public class ChooseServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
		HttpSession session = request.getSession();
		String serviceName = request.getParameter("serviceName");
		session.setAttribute("serviceName", serviceName);
		try {
			Services service = serviceDaoImpl.allService(serviceName);
			int serviceId = serviceDaoImpl.findServiceId(service.getServiceName());
			double servicePackage = serviceDaoImpl.findPackage(serviceId);
			int advanceServiceAmount = (int) (servicePackage * 1 / 2);
			session.setAttribute("serviceId", serviceId);
			session.setAttribute("servicePackage", servicePackage);
			session.setAttribute("advanceServiceAmount", advanceServiceAmount);
			request.setAttribute("chooseService", service);
			RatingsDaoimpl ratings = new RatingsDaoimpl();
			List<Ratings> review = ratings.showReview(serviceName);
			double rate = ratings.fetchRating(serviceName);
			request.setAttribute("review", review);
			request.setAttribute("rate", rate);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pickService.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
