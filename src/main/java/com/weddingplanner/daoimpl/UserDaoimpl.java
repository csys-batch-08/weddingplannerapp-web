package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.UserDao;
import com.weddingplanner.model.User;
import com.weddingplanner.util.ConnectionUtil;

public class UserDaoimpl implements UserDao {
	public boolean insertUser(User user) {
		String insertQuery = "insert into user_details(user_name, mobile_number, city, email_id, password) values(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		boolean flag = false;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getUserName());
			statement.setLong(2, user.getMobileNumber());
			statement.setString(3, user.getCity());
			statement.setString(4, user.getEmailId());
			statement.setString(5, user.getPassword());
			if (statement.executeUpdate() > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public User validateUser(String emailId, String password) {
		String validateQuery = "select user_id, user_role, user_name, mobile_number,city,email_id,password,user_wallet from user_details where email_id=? and password=? and user_role='customer' ";
		Connection connection = null;
		User user = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(validateQuery);
			statement.setString(1, emailId);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("USER_NAME"), rs.getLong("Mobile_Number"), rs.getString("city"), emailId, password, rs.getInt("User_Wallet"));
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
		return user;
	}

	public User validateAdmin(String emailId, String password) throws SQLException {

		String validateAdminQuery = "select user_id, user_role, user_name, mobile_number,city,email_id,password,user_wallet from user_details where user_role='admin'and email_id=? and password=?";
		Connection connection = null;
		User user = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(validateAdminQuery);
			statement.setString(1, emailId);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("User_name"), rs.getLong("Mobile_number"), rs.getString("city"), rs.getString("Email_id"), rs.getString("Password"),
						rs.getInt(8));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();

			}

		}

		return user;

	}

	public void updateUserProfile(User user) {
		String updateQuery = "update user_details set user_name=?,mobile_number=?,city=? where email_id=?";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(updateQuery);
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setLong(2, user.getMobileNumber());
			prepareStatement.setString(3, user.getCity());
			prepareStatement.setString(4, user.getEmailId());
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

	
	public List<User> viewUser() {
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_id, user_role, user_name, mobile_number,city,email_id,password,user_wallet from user_details where user_role='customer'";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			prepareStatement = connection.prepareStatement(showQuery);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("User_Name"), rs.getLong("mobile_number"), rs.getString("city"), rs.getString("email_id"), rs.getString("password"),
						rs.getInt("User_wallet"));
				userList.add(user);

			}
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
		return userList;

	}

	public int findUserId(String emailId) {
		String findUser = "select User_id from user_details where email_id=?";
		Connection connection = null;
		int userId = 0;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findUser);
			statement.setString(1, emailId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("User_id");
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

		return userId;

	}

	// get wallet balance:
	public int walletbal(int id) {
		Connection connection = null;
		String query = "select user_wallet from user_details where user_id = ?";
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				return rs.getInt("user_wallet");
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
		return -1;
	}

	// update wallet balance:
	public int updatewallet(int amount, int userId) {
		Connection connection = null;
		String query = "update user_details set user_wallet =user_wallet+ ? where user_id = ?";
		PreparedStatement statement = null;
		int res = 0;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, amount);
			statement.setInt(2, userId);
			res = statement.executeUpdate();

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

		return res;
	}

	public int updateWalletBalance(int amount, int userId) {
		Connection connection = null;
		String query = "update user_details set user_wallet = ? where user_id = ?";
		PreparedStatement statement = null;
		int res = 0;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, amount);
			statement.setInt(2, userId);
			res = statement.executeUpdate();
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

		return res;
	}

	public List<User> currentUserProfile(int userid) {
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_name, mobile_number, city, email_id, password, user_wallet from user_details where user_id=?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(showQuery);
			statement.setInt(1, userid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("user_name"), rs.getLong("mobile_number"), rs.getString("city"), rs.getString("email_id"), rs.getString("password"),
						rs.getInt("user_wallet"));
				userList.add(user);
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

		return userList;
	}

	
	public void inactiveUser(int userId) {
		Connection connection = null;
		String query = "update user_details set user_role ='inactive'  where user_id = ?";
		PreparedStatement statement = null;

		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
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

	public String findUserName(int userId) {
		String findVenue = "select user_name from  user_details where user_id=?";
		Connection connection = null;
		String name = null;
		PreparedStatement statement = null;
		try {
			connection = ConnectionUtil.getDbConnection();
			statement = connection.prepareStatement(findVenue);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				name = rs.getString("user_name");
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

		return name;

	}

}