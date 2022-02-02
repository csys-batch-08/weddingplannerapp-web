package com.weddingplanner.dao;

import java.util.List;

import com.weddingplanner.model.Ratings;

public interface RatingsDao {
	public void insertRating(Ratings rating);
	public double fetchRating(String serviceName);
	public List<Ratings> showReview(String serviceName);




}
