package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.VenuesDao;
import com.weddingplanner.model.Venues;
import com.weddingplanner.util.ConnectionUtil;

public class VenuesDaoimpl implements VenuesDao {

	public List<Venues> showVenue() {
		List<Venues> venuelist = new ArrayList<>();
		String showQuery = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images,venue_description from venue_details where check_availability='yes'";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Venues venue = new Venues(resultSet.getString("Venue_name"), resultSet.getString("Venue_area"), resultSet.getString("venue_city"),
						resultSet.getString("Venue_type"), resultSet.getString("Venue_vendor_name"), resultSet.getLong("Contact_number"), resultSet.getDouble("Venue_package"),
						resultSet.getString("Check_availability"), resultSet.getString("Venue_images"),resultSet.getInt("Venue_id"),resultSet.getString("Venue_description"));
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

	public boolean insertVenue(Venues venue) {
		String insertQuery = "insert into venue_details(venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability, venue_images,venue_description)values(?,?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		 int result=0;
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
			prepareStatement.setString(10, venue.getVenueDescription());

			result=prepareStatement.executeUpdate();

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
		return true;
	}

	public void updateVenue(Venues venue) {
		String updateQuery = "update venue_details set venue_vendor_name=?,contact_number=?,venue_package=?,venue_images=?,venue_type=?,venue_name=?,venue_description=? where venue_id=?";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, venue.getVenueVendorName());
			prepareStatement.setLong(2,venue.getContactNumber());
			prepareStatement.setDouble(3, venue.getVenuePackage());
			prepareStatement.setString(4, venue.getVenueImages());
			prepareStatement.setString(5, venue.getVenueType());
            prepareStatement.setString(6, venue.getVenueName());
            prepareStatement.setString(7, venue.getVenueDescription());
            prepareStatement.setInt(8, venue.getVenueId());
            
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
				venueId = resultSet.getInt("venue_id");
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

		String validateQuery = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images,venue_description from venue_details WHERE  venue_name='"
				+ venueName + "'";
		Connection connection = null;
		Venues venue = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(validateQuery);
			while (resultSet.next()) {
				venue = new Venues(resultSet.getString("venue_name"), resultSet.getString("venue_area"), resultSet.getString("venue_city"),
						resultSet.getString("venue_type"), resultSet.getString("venue_vendor_name"), resultSet.getLong("contact_number"), resultSet.getDouble("Venue_package"),
						resultSet.getString("check_availability"), resultSet.getString("venue_images"),resultSet.getString("venue_description"));

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
				venuePackage = resultSet.getInt("venue_package");
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
		String query = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images from venue_details where lower(venue_city) like '"
				+ venueCity + "%'";
		Connection connection = null;
		ResultSet resultSet = null;
		Venues venue = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				venue = new Venues(resultSet.getString("venue_name"), resultSet.getString("venue_area"), venueCity, resultSet.getString("venue_type"),
						resultSet.getString("venue_vendor_name"), resultSet.getLong("contact_number"), resultSet.getDouble("venue_package"), resultSet.getString("check_availability"),
						resultSet.getString("venue_images"));
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

	public boolean inactiveVenue(int venueId) {
		Connection connection = null;
		String query = "update venue_details set check_availability ='No'  where venue_id = ?";
		PreparedStatement prepareStatement = null;
		int result=0;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, venueId);
			result=prepareStatement.executeUpdate();

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
		return result>0;

	}
	public List<Venues> showVenueAdmin() {
		List<Venues> venuelist = new ArrayList<>();
		String showQuery = "select venue_id,venue_name,venue_area,venue_city,venue_type,venue_vendor_name,contact_number,venue_package,check_availability,venue_images,venue_description from venue_details";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Venues venue = new Venues(resultSet.getString("Venue_name"), resultSet.getString("Venue_area"), resultSet.getString("venue_city"),
						resultSet.getString("Venue_type"), resultSet.getString("Venue_vendor_name"), resultSet.getLong("Contact_number"), resultSet.getDouble("Venue_package"),
						resultSet.getString("Check_availability"), resultSet.getString("Venue_images"),resultSet.getInt("Venue_id"),resultSet.getString("Venue_description"));
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