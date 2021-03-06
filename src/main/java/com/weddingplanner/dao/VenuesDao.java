package com.weddingplanner.dao;

import java.util.List;

import com.weddingplanner.model.Venues;

public interface VenuesDao {
	public List<Venues> showVenue();

	public boolean insertVenue(Venues venue);

	public void updateVenue(Venues venue);

	public Venues allVenue(String venueName);

	public int findVenueId(String venueName);

	public int findPackage(int venueId);

	public List<Venues> findCity(String venueCity);

}
