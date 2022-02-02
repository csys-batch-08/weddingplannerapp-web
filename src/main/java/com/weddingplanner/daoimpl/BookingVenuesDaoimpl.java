package com.weddingplanner.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.BookingVenueDao;
import com.weddingplanner.model.BookingVenues;
import com.weddingplanner.util.ConnectionUtil;

public class BookingVenuesDaoimpl implements BookingVenueDao{
	
	public boolean bookVenue(BookingVenues bookVenues) {

	String insert = "INSERT INTO Booking_venues (user_id,venue_id,venue_name,no_of_guest,event_date,venue_package,advance_amount) VALUES(?,?,?,?,?,?,?) ";
	Connection connection = null;
	PreparedStatement statement = null;
	boolean flag=false;
	try {
		connection = ConnectionUtil.getDbConnection();
		statement = connection.prepareStatement(insert);
		statement.setInt(1, bookVenues.getUserId());
		statement.setInt(2, bookVenues.getVenueId());
		statement.setString(3, bookVenues.getVenueName());
		statement.setInt(4, bookVenues.getNoOfGuest());
		
		statement.setDate(5,  java.sql.Date.valueOf(bookVenues.getEventDate()));
		statement.setDouble(6,bookVenues.getVenuePackage());
		statement.setDouble(7,bookVenues.getAdvanceAmount());
		if(statement.executeUpdate()>0)
		{
		    flag=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		
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
	public boolean checkDate(String venuename,LocalDate eventDate) {
		 String findVenue="select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from booking_venues where  to_char(event_date,'yyyy-mm-dd')='"+eventDate+"' and venue_name='"+venuename+"'";
		 Connection connection=null;
			boolean flag=true;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					new BookingVenues(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDate(7).toLocalDate(),resultSet.getDouble(8));
					
				}
				else {
					flag=false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
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
	
	 public void cancelBooking(int userId,String venueName,LocalDate eventDate) {
			String updateQuery="update booking_venues set status='cancelled' where user_id=? and venue_name=? and event_date=?";
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.prepareStatement(updateQuery);
				statement.setInt(1, userId);
				statement.setString(2, venueName);
				statement.setDate(3,  java.sql.Date.valueOf(eventDate));
                statement.executeUpdate();
				statement.executeUpdate("commit");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				
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
	 public List<BookingVenues> myBooking(int userId){
			List<BookingVenues> venueList =new ArrayList<>();
			String viewQuery="select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues where user_id='"+userId+"'";
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				resultSet=statement.executeQuery(viewQuery);
				while(resultSet.next()) {
					BookingVenues venue=new BookingVenues(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDate(7).toLocalDate(),resultSet.getDouble(8));
				venueList.add(venue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
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
		 String findVenue="select booking_Date from booking_venues where user_id='"+userId+"'";
		 Connection connection=null;
			LocalDate bookDate=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					bookDate=resultSet.getDate(1).toLocalDate();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			finally {
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
	 public int findBookingVenueId(int userId,LocalDate eventDateBooking,String venueName) {
		 String findVenue="select venue_booking_id from booking_venues where  to_char(event_date,'yyyy-mm-dd')='"+eventDateBooking+"' and  user_id='"+userId+"' and venue_name='"+venueName+"'";
		 Connection connection=null;
			int venueBookingId=0;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
		         resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					venueBookingId=resultSet.getInt(1);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			finally {
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
		 String findVenue="select floor((event_date)- to_date(sysdate)) as no_of_days from booking_venues where venue_booking_id='"+venueBookingId+"'";
		 		
		 Connection connection=null;
			int noOfDays=0;
			Statement statement = null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
			    resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					noOfDays=resultSet.getInt(1);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			finally {
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
	 public String findStatus(String venueName,LocalDate eventDate) {
		 String findVenue="select status from booking_venues where venue_name='"+venueName+"' and to_char(event_date,'yyyy-mm-dd')='"+eventDate+"'";
		 Connection connection=null;
			String status=null;
			Statement statement = null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					status=resultSet.getString(1);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
			finally {
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
	 
	 public Boolean checkCancelBooking(String venueName,LocalDate eventdate) {
		 String findVenue="select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from booking_venues where status='cancelled' and venue_name='"+venueName+"' and to_char(event_date,'yyyy-mm-dd')='"+eventdate+"'";
		 Connection connection=null;
			boolean flag=true;
			Statement statement = null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					new BookingVenues(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDate(7).toLocalDate(),resultSet.getDouble(8));
					
				}
				else {
					flag=false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
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
	 
	 public List<BookingVenues> userVenueBooking(){
			List<BookingVenues> venueList =new ArrayList<>();
			String viewQuery="select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues";
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				resultSet=statement.executeQuery(viewQuery);
				while(resultSet.next()) {
					BookingVenues venue=new BookingVenues(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDate(7).toLocalDate(),resultSet.getDouble(8));
				venueList.add(venue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
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
	 
	 
	 public List<BookingVenues> allBookings(){
			List<BookingVenues> venueList =new ArrayList<>();
			String viewQuery="select venue_booking_id,user_id,venue_id,venue_name,no_of_guest,booking_date,event_date,venue_package,status,advance_amount from Booking_venues";
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				resultSet=statement.executeQuery(viewQuery);
				while(resultSet.next()) {
					BookingVenues venue=new BookingVenues(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDate(6).toLocalDate(),resultSet.getDate(7).toLocalDate(),resultSet.getDouble(8),resultSet.getString(9));
				venueList.add(venue);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
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
	   	
	   	


			
	   	
	
	
	
	
	
	
	


