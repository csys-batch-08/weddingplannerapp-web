package com.weddingplanner.dao;

import java.time.LocalDate;
import java.util.List;

import com.weddingplanner.model.BookingServices;

public interface BookingServiceDao {
	public void bookService(BookingServices bookService);

	public int totalPackage(int userId);

	public List<BookingServices> myBooking(int userId);

	public boolean checkDate(String serviceName, LocalDate eventDate);

	public boolean checkService(String serviceName, int userId);

	public void cancelServiceBooking(int serviceId);

	public LocalDate findBookingDate(int userId);

	public String findStatus(String serviceName, LocalDate eventDate);

	public int validateCancelBooking(int serviceBookingId);

	public int findBookingServiceId(int userId, LocalDate eventDate, String serviceName);

	public Boolean checkCancelServiceBooking(int serviceId);

	public List<BookingServices> allServiceBooking();

}
