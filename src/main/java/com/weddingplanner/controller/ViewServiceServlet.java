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
import com.weddingplanner.module.Services;

/**
 * Servlet implementation class ViewServiceServlet
 */
@WebServlet("/ViewServiceServlet")
public class ViewServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServiceServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicesDaoimpl serviceDaoImpl = new ServicesDaoimpl();
		List<Services> showservices=serviceDaoImpl.showServiceType();
		request.setAttribute("viewServices", showservices);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewService.jsp");
		requestDispatcher.forward(request, response);

}
}