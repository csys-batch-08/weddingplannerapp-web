package com.weddingplanner.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BookingVenues {

	private int userId;
	private int venueId;
	private String venueName;
	private int noOfGuest;
	private LocalDate bookingDate;
	private LocalDate eventDate;
	private double venuePackage;
	private String status;
	private int advanceAmount;
	private int venueBookingId;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(int noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public double getVenuePackage() {
		return venuePackage;
	}

	public void setVenuePackage(double venuePackage) {
		this.venuePackage = venuePackage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(int advanceAmount) {
		this.advanceAmount = advanceAmount;
	}
	

	public int getVenueBookingId() {
		return venueBookingId;
	}

	public void setVenueBookingId(int venueBookingId) {
		this.venueBookingId = venueBookingId;
	}

	public BookingVenues(int userId, int venueId, String venueName, int noOfGuest, LocalDate eventDate,
			double venuePackage, int advanceAmount) {
		super();
		this.userId = userId;
		this.venueId = venueId;
		this.venueName = venueName;
		this.noOfGuest = noOfGuest;
		this.eventDate = eventDate;
		this.venuePackage = venuePackage;
		this.advanceAmount = advanceAmount;
	}

	public BookingVenues(int userId, int venueId, String venueName, int noOfGuest, LocalDate bookingDate,
			LocalDate eventDate, double venuePackage, String status) {
		super();
		this.userId = userId;
		this.venueId = venueId;
		this.venueName = venueName;
		this.noOfGuest = noOfGuest;
		this.bookingDate = bookingDate;
		this.eventDate = eventDate;
		this.venuePackage = venuePackage;
		this.status = status;
	}

	public BookingVenues(int userId, int venueId, String venueName, int noOfGuest, LocalDate eventDate,
			double venuePackage) {
		super();
		this.userId = userId;
		this.venueId = venueId;
		this.venueName = venueName;
		this.noOfGuest = noOfGuest;
		this.eventDate = eventDate;
		this.venuePackage = venuePackage;
	}

	
	
	

	public BookingVenues(int userId, int venueId, String venueName, int noOfGuest, LocalDate bookingDate,
			LocalDate eventDate, double venuePackage, String status, int advanceAmount, int venueBookingId) {
		super();
		this.userId = userId;
		this.venueId = venueId;
		this.venueName = venueName;
		this.noOfGuest = noOfGuest;
		this.bookingDate = bookingDate;
		this.eventDate = eventDate;
		this.venuePackage = venuePackage;
		this.status = status;
		this.advanceAmount = advanceAmount;
		this.venueBookingId = venueBookingId;
	}

	public BookingVenues() {
		super();

	}
	

	@Override
	public int hashCode() {
		return Objects.hash(advanceAmount, bookingDate, eventDate, noOfGuest, status, userId, venueId, venueName,
				venuePackage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingVenues other = (BookingVenues) obj;
		return advanceAmount == other.advanceAmount && Objects.equals(bookingDate, other.bookingDate)
				&& Objects.equals(eventDate, other.eventDate) && noOfGuest == other.noOfGuest
				&& Objects.equals(status, other.status) && userId == other.userId && venueId == other.venueId
				&& Objects.equals(venueName, other.venueName)
				&& Double.doubleToLongBits(venuePackage) == Double.doubleToLongBits(other.venuePackage);
	}

	@Override
	public String toString() {
		return "BookingVenues [userId=" + userId + ", venueId=" + venueId + ", venueName=" + venueName + ", noOfGuest="
				+ noOfGuest + ", bookingDate=" + bookingDate + ", eventDate=" + eventDate + ", venuePackage="
				+ venuePackage + ", status=" + status + ", advanceAmount=" + advanceAmount + "]";
	}

}
