package com.weddingplanner.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.weddingplanner.daoimpl.RatingsDaoimpl;
import com.weddingplanner.model.Ratings;


@WebServlet("/ratings")
public class RatingServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session=request.getSession();

		int userId=(int) session.getAttribute("id");

		String servicename = request.getParameter("venuename");
		int  rating=Integer.parseInt(request.getParameter("rating"));
		session.setAttribute("rating", rating);
		String review=request.getParameter("review");
		RatingsDaoimpl ratings =new RatingsDaoimpl();
		Ratings giveRating=new Ratings(userId,servicename,rating,review);
		ratings.insertRating(giveRating);
		 session.setAttribute("ratingMessage", "Thank You For Your Ratings!!");
         response.sendRedirect("ratingMessage.jsp");
		
	}catch(Exception e) {
		e.printStackTrace();

	}
	}

}
