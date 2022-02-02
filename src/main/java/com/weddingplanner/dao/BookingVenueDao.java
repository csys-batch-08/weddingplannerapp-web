package com.weddingplanner.dao;

import java.time.LocalDate;
import java.util.List;

import com.weddingplanner.model.BookingVenues;

public interface BookingVenueDao {
	public boolean bookVenue(BookingVenues bookVenues);
	public boolean checkDate(String venuename,LocalDate eventDate);
	public void cancelBooking(int userId,String venueName,LocalDate eventDate);
	public List<BookingVenues> myBooking(int userId);
	public LocalDate findVenueBookingDate(int userId); 
	public int findBookingVenueId(int userId,LocalDate eventDateBooking,String venueName);
	public int validateCancelBooking(int venueBookingId);
	public String findStatus(String venueName,LocalDate eventDate);
	 public Boolean checkCancelBooking(String venueName,LocalDate eventdate);
	 public List<BookingVenues> userVenueBooking();
	 public List<BookingVenues> allBookings();
}
