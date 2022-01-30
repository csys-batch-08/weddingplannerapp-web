package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.VenuesDao;
import com.weddingplanner.module.Venues;
import com.weddingplanner.util.ConnectionUtil;

public class VenuesDaoimpl implements VenuesDao {

	public List<Venues> showVenue() {
		List<Venues> venuelist = new ArrayList<>();
		String showQuery = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images from venue_details";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Venues venue = new Venues(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getDouble(8),
						resultSet.getString(9), resultSet.getString(10));
				venuelist.add(venue);

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
		return venuelist;

	}

	public void insertVenue(Venues venue) {
		String insertQuery = "insert into venue_details(venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability, venue_images)values(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(insertQuery);
			prepareStatement.setString(1, venue.getVenueName());
			prepareStatement.setString(2, venue.getVenueArea());
			prepareStatement.setString(3, venue.getVenueCity());
			prepareStatement.setString(4, venue.getVenueType());
			prepareStatement.setString(5, venue.getVenueVendorName());
			prepareStatement.setLong(6, venue.getContactNumber());
			prepareStatement.setDouble(7, venue.getVenuePackage());
			prepareStatement.setString(8, venue.getAvailability());
			prepareStatement.setString(9, venue.getVenueImages());
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
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

	public void updateVenue(Venues venue) {
		String updateQuery = "update venue_details set venue_vendor_name=?,contact_number=?,venue_package=?,venue_images=? where venue_name=?";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, venue.getVenueVendorName());
			prepareStatement.setLong(2, venue.getContactNumber());
			prepareStatement.setDouble(3, venue.getVenuePackage());
			prepareStatement.setString(4, venue.getVenueImages());
			prepareStatement.setString(5, venue.getVenueName());
			prepareStatement.executeUpdate();
			prepareStatement.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (prepareStatement != null) {
				try {
					prepareStatement.close();
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

	public void updatevenueAvalability(String availability) {
		String updateQuery = "update venue_details set check_availability='No' where venue_name=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(updateQuery);
			statement.setString(1, availability);
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

	public int findVenueId(String venueName) {
		String findVenue = "select venue_id from venue_details where venue_name='" + venueName + "'";
		Connection connection = null;
		int venueId = 0;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(findVenue);
			if (resultSet.next()) {
				venueId = resultSet.getInt(1);
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

		return venueId;

	}

	public Venues allVenue(String venueName) {

		String validateQuery = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images from venue_details WHERE  venue_name='" + venueName + "'";
		Connection connection = null;
		Venues venue = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(validateQuery);
			while (resultSet.next()) {
				venue = new Venues(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getDouble(8),
						resultSet.getString(9), resultSet.getString(10));

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

		return venue;

	}

	public int findPackage(int venueId) {
		String query = "select venue_package from venue_details where venue_id='" + venueId + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int venuePackage = 0;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();

			resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				venuePackage = resultSet.getInt(1);
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

		return venuePackage;

	}

	public List<Venues> findCity(String venueCity) {
		List<Venues> venuelist = new ArrayList<>();
		String query = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images from venue_details where lower(venue_city) like '" + venueCity + "%'";
		Connection connection = null;
		ResultSet resultSet = null;
		Venues venue = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				venue = new Venues(resultSet.getString(2), resultSet.getString(3), venueCity, resultSet.getString(5),
						resultSet.getString(6), resultSet.getLong(7), resultSet.getDouble(8), resultSet.getString(9),
						resultSet.getString(10));
				venuelist.add(venue);
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

		return venuelist;
	}

}