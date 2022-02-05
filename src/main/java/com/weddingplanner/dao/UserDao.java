package com.weddingplanner.dao;

import java.sql.SQLException;
import java.util.List;

import com.weddingplanner.model.User;

public interface UserDao {
	public boolean insertUser(User user);

	public User validateUser(String emailId, String password);

	public User validateAdmin(String emailId, String password) throws SQLException;

	public void updateUserProfile(User user);

	public User validateUserUpdate(String emailId);

	public List<User> viewUser();

	public int findUserId(String emailId);

	public int walletbal(int id);

	public int updatewallet(int amount, int userId);

	public List<User> currentuserprofile(int userid);

	public void inactiveUser(int userId);

	public String findUserName(int userId);
}
