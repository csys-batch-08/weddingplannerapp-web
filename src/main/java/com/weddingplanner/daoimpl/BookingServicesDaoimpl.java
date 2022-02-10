package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.BookingServiceDao;
import com.weddingplanner.model.BookingServices;
import com.weddingplanner.model.BookingVenues;
import com.weddingplanner.util.ConnectionUtil;

public class BookingServicesDaoimpl implements BookingServiceDao {
	public void bookService(BookingServices bookService) {
		String insert = "insert into booking_services (user_id,service_id,service_name,event_date,service_package)values(?,?,?,?,?) ";
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(insert);
			statement.setInt(1, bookService.getUserId());
			statement.setInt(2, bookService.getServiceId());
			statement.setString(3, bookService.getServiceName());
			statement.setDate(4, java.sql.Date.valueOf(bookService.getEventDate()));
			statement.setDouble(5, bookService.getServicePackage());
			statement.executeUpdate();
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

	public int totalPackage(int userId) {
		String query = "select sum(service_package) from booking_services where user_id=? group by user_id";
		Connection connection = null;
		PreparedStatement statement = null;
		int totalPackage = 0;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				totalPackage = resultSet.getInt(1);
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

		return totalPackage;

	}

	public List<BookingServices> myBooking(int userId) {
		List<BookingServices> serviceList = new ArrayList<>();
		String viewQuery = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from Booking_services where user_id=? order by booking_date desc";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			statement.setInt(1, userId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingServices service = new BookingServices(resultSet.getInt("USER_ID"),
						resultSet.getInt("SERVICE_ID"), resultSet.getString("SERVICE_NAME"),
						resultSet.getDate("BOOKING_DATE").toLocalDate(), resultSet.getDate("EVENT_DATE").toLocalDate(),
						resultSet.getDouble("SERVICE_PACKAGE"), resultSet.getString("STATUS"),
						resultSet.getInt("SERVICE_BOOKING_ID"));
				serviceList.add(service);
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

		return serviceList;
	}

	public boolean checkDate(String serviceName, LocalDate eventDate) {
		String findVenue = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where service_name=? and to_char(event_date,'dd-mm-yyyy')=?";
		Connection connection = null;
		boolean flag = true;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setString(1, serviceName);
			statement.setDate(2, java.sql.Date.valueOf(eventDate));
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				new BookingServices(resultSet.getInt("USER_ID"), resultSet.getInt("SERVICE_ID"),
						resultSet.getString("SERVICE_NAME"), resultSet.getDate("EVENT_DATE").toLocalDate(),
						resultSet.getDouble("SERVICE_PACKGE"));
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

	public boolean checkService(String serviceName, int userId) {
		String findVenue = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where service_name=? and user_id=?";
		Connection connection = null;
		boolean flag = true;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setString(1, serviceName);
			statement.setInt(2, userId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				new BookingServices(resultSet.getInt("User_id"), resultSet.getInt("Service_id"),
						resultSet.getString("Service_name"), resultSet.getDate("Event_date").toLocalDate(),
						resultSet.getDouble("Service_package"));
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

	public void cancelServiceBooking(int serviceId) {
		String updateQuery = "update booking_services set status='cancelled' where  service_booking_id=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(updateQuery);

			statement.setInt(1, serviceId);

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

	public LocalDate findBookingDate(int userId) {
		String findVenue = "select booking_Date from booking_services where user_id=?";
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

	public String findStatus(String serviceName, LocalDate eventDate) {
		String findVenue = "select status from booking_services where  service_name=? and to_char(event_date,'yyyy-mm-dd')=?";
		Connection connection = null;
		String status = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setString(1, serviceName);
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

	public int validateCancelBooking(int serviceBookingId) {
		String findVenue = "select floor((event_date)- to_date(sysdate)) as no_of_days from booking_services where service_booking_id=?";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setInt(1, serviceBookingId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				resultSet.getInt(1);
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
		return serviceBookingId;

	}

	public int findBookingServiceId(int userId, LocalDate eventDate, String serviceName) {
		String findVenue = "select service_booking_id from booking_services where user_id='" + userId
				+ "' and to_char(event_date,'yyyy-mm-dd')='" + eventDate + "' and service_name='" + serviceName + "'";
		Connection connection = null;
		int serviceBookingId = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(findVenue);
			if (resultSet.next()) {
				serviceBookingId = resultSet.getInt("service_booking_id");
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

		return serviceBookingId;

	}

	public Boolean checkCancelServiceBooking(int serviceId) {
		String findVenue = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where status='cancelled' and service_booking_id=?";
		Connection connection = null;
		boolean flag = true;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setInt(1, serviceId);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				new BookingVenues(resultSet.getInt("User_id"), resultSet.getInt("Service_id"),
						resultSet.getString("Service_name"), serviceId, resultSet.getDate("Event_date").toLocalDate(),
						resultSet.getDouble("Service_package"));

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

	public List<BookingServices> allServiceBooking() {
		List<BookingServices> serviceList = new ArrayList<>();
		String viewQuery = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from Booking_services";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingServices service = new BookingServices(resultSet.getInt("user_id"),
						resultSet.getInt("service_id"), resultSet.getString("service_name"),
						resultSet.getDate("booking_date").toLocalDate(), resultSet.getDate("event_date").toLocalDate(),
						resultSet.getDouble("service_package"), resultSet.getString("status"));
				serviceList.add(service);
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

		return serviceList;
	}

	public List<BookingServices> filterByDate(LocalDate eventDate) {
		List<BookingServices> serviceList = new ArrayList<>();
		String viewQuery = "select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from Booking_services where  to_char(event_date,'dd-mm-yyyy')=?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(viewQuery);
			statement.setDate(1, java.sql.Date.valueOf(eventDate));
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BookingServices service = new BookingServices(resultSet.getInt("user_id"),
						resultSet.getInt("service_id"), resultSet.getString("service_name"),
						resultSet.getDate("booking_date").toLocalDate(), resultSet.getDate("event_date").toLocalDate(),
						resultSet.getDouble("service_package"), resultSet.getString("status"));
				serviceList.add(service);
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

		return serviceList;
	}

}
