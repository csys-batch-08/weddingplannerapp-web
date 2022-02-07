package com.weddingplanner.model;

import java.io.Serializable;

public class Ratings implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userId;
	private String serviceName;
	private int rating;
	private String review;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Ratings(int userId, String serviceName, int rating, String review) {
		super();
		this.userId = userId;
		this.serviceName = serviceName;
		this.rating = rating;
		this.review = review;
	}

	public Ratings() {
		super();
		
	}

}
