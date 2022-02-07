package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.BookingVenueDao;
import com.weddingplanner.model.BookingVenues;
import com.weddingplanner.util.ConnectionUtil;

public class BookingVenuesDaoimpl implements BookingVenueDao {

	public boolean bookVenue(BookingVenues bookVenues) {

		String insert = "INSERT INTO Booking_venues (user_id,venue_id,venue_name,no_of_guest,event_date,venue_package,advance_amount) VALUES(?,?,?,?,?,?,?) ";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(insert);
			statement.setInt(1, bookVenues.getUserId());
			statement.setInt(2, bookVenues.getVenueId());
			statement.setString(3, bookVenues.getVenueName());
			statement.setInt(4, bookVenues.getNoOfGuest());
			statement.setDate(5, java.sql.Date.valueOf(bookVenues.getEventDate()));
			statement.setDouble(6, bookVenues.getVenuePackage());
			statement.setDouble(7, bookVenues.getAdvanceAmount());
			if (statement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;

	}

	public boolean checkDate(String venuename, LocalDate eventDate) {
		String findVenue = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from booking_venues where  to_char(event_date,'dd-mm-yyyy')=? and venue_name=?";
		Connection connection = null;
		boolean flag = true;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setDate(1, java.sql.Date.valueOf(eventDate));
			statement.setString(2, venuename);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				new BookingVenues(resultSet.getInt("User_Id"), resultSet.getInt("Venue_Id"),
						resultSet.getString("Venue_Name"), resultSet.getInt("No_Of_Guest"),
						resultSet.getDate("Event_Date").toLocalDate(), resultSet.getDouble("Venue_Package"));
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;

	}

	public void cancelBooking(int userId, int bookingId) {
		String updateQuery = "update booking_venues set status='cancelled' where user_id=? and venue_booking_id=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, userId);
			statement.setInt(2, bookingId);

			statement.executeUpdate();
			statement.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public List<BookingVenues> myBooking(int userId) {
		List<BookingVenues> venueList = new ArrayList<>();
		String viewQuery = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues  where user_id=? order by booking_date desc";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingVenues venue = new BookingVenues(resultSet.getInt("USER_ID"), resultSet.getInt("VENUE_ID"),
						resultSet.getString("VENUE_NAME"), resultSet.getInt("NO_OF_GUEST"),
						resultSet.getDate("Booking_Date").toLocalDate(), resultSet.getDate("Event_date").toLocalDate(),
						resultSet.getDouble("VENUE_PACKAGE"), resultSet.getString("Status"),
						resultSet.getInt("advance_amount"), resultSet.getInt("venue_booking_id"));
				venueList.add(venue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return venueList;
	}

	public LocalDate findVenueBookingDate(int userId) {
		String findVenue = "select booking_Date from booking_venues where user_id=?";
		Connection connection = null;
		LocalDate bookDate = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				bookDate = resultSet.getDate("booking_Date").toLocalDate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return bookDate;

	}

	public int findBookingVenueId(int userId, LocalDate eventDateBooking, String venueName) {
		String findVenue = "select venue_booking_id from booking_venues where  to_char(event_date,'yyyy-mm-dd')=? and  user_id=? and venue_name=?";
		Connection connection = null;
		int venueBookingId = 0;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setDate(1, java.sql.Date.valueOf(eventDateBooking));
			statement.setInt(2, userId);
			statement.setString(3, venueName);
			resultSet = statement.executeQuery(findVenue);
			if (resultSet.next()) {
				venueBookingId = resultSet.getInt("venue_booking_id");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return venueBookingId;

	}

	public int validateCancelBooking(int venueBookingId) {
		String findVenue = "select floor((event_date)- to_date(sysdate)) as no_of_days from booking_venues where venue_booking_id=?";

		Connection connection = null;
		int noOfDays = 0;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setInt(1, venueBookingId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				noOfDays = resultSet.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return noOfDays;

	}

	public String findStatus(String venueName, LocalDate eventDate) {
		String findVenue = "select status from booking_venues where venue_name=? and to_char(event_date,'yyyy-mm-dd')=?";
		Connection connection = null;
		String status = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setString(1, venueName);
			statement.setDate(2, java.sql.Date.valueOf(eventDate));
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getString("Status");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return status;

	}

	public Boolean checkCancelBooking(String venueName, LocalDate eventdate) {
		String findVenue = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from booking_venues where status='cancelled' and venue_name=? and to_char(event_date,'yyyy-mm-dd')=?";
		Connection connection = null;
		boolean flag = true;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setString(1, venueName);
			statement.setDate(2, java.sql.Date.valueOf(eventdate));
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				new BookingVenues(resultSet.getInt("User_id"), resultSet.getInt("Venue_id"),
						resultSet.getString("Venue_name"), resultSet.getInt("No_Of_Guest"),
						resultSet.getDate("Event_Date").toLocalDate(), resultSet.getDouble("Venue_Package"));

			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;

	}

	public List<BookingVenues> userVenueBooking() {
		List<BookingVenues> venueList = new ArrayList<>();
		String viewQuery = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingVenues venue = new BookingVenues(resultSet.getInt("User_id"), resultSet.getInt("Venue_id"),
						resultSet.getString("Venue_name"), resultSet.getInt("No_of_guest"),
						resultSet.getDate("Event_date").toLocalDate(), resultSet.getDouble("Venue_package"));
				venueList.add(venue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return venueList;
	}

	public List<BookingVenues> allBookings() {
		List<BookingVenues> venueList = new ArrayList<>();
		String viewQuery = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingVenues venue = new BookingVenues(resultSet.getInt("user_id"), resultSet.getInt("venue_id"),
						resultSet.getString("venue_name"), resultSet.getInt("no_of_guest"),
						resultSet.getDate("booking_date").toLocalDate(), resultSet.getDate("event_date").toLocalDate(),
						resultSet.getDouble("venue_package"), resultSet.getString("status"));
				venueList.add(venue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return venueList;
	}

	public List<BookingVenues> filterByDate(LocalDate eventDate) {
		List<BookingVenues> venueList = new ArrayList<>();
		String viewQuery = "select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues where to_char(event_date,'dd-mm-yyyy')=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			statement.setDate(1, java.sql.Date.valueOf(eventDate));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingVenues venue = new BookingVenues(resultSet.getInt("user_id"), resultSet.getInt("venue_id"),
						resultSet.getString("venue_name"), resultSet.getInt("no_of_guest"),
						resultSet.getDate("booking_date").toLocalDate(), resultSet.getDate("event_date").toLocalDate(),
						resultSet.getDouble("venue_package"), resultSet.getString("status"));
				venueList.add(venue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return venueList;
	}
}
