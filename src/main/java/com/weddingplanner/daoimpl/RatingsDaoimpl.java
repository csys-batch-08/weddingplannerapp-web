package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.RatingsDao;
import com.weddingplanner.model.Ratings;
import com.weddingplanner.util.ConnectionUtil;

public class RatingsDaoimpl implements RatingsDao {
	public void insertRating(Ratings rating) {
		String insertQuery = "insert into rating_details(user_id,service_name,rating,review)values(?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, rating.getUserId());
			statement.setString(2, rating.getServiceName());
			statement.setInt(3, rating.getRating());
			statement.setString(4, rating.getReview());

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

	public double fetchRating(String serviceName) {
		Connection connection = null;
		String query = "select trunc(avg(rating),2) from rating_details where service_name =?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, serviceName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {

				return resultSet.getDouble(1);

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

		return -1;
	}

	public List<Ratings> showReview(String serviceName) {
		List<Ratings> venueList = new ArrayList<>();
		String viewQuery = "select rating_id,user_id,service_name,rating,review from rating_details where service_name='" + serviceName + "'";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(viewQuery);
			while (resultSet.next()) {

				Ratings rating = new Ratings(resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4),
						resultSet.getString(5));
				venueList.add(rating);
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
