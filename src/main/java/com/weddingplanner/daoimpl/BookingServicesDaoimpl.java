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
import com.weddingplanner.module.BookingServices;
import com.weddingplanner.module.BookingVenues;
import com.weddingplanner.util.ConnectionUtil;

public class BookingServicesDaoimpl implements BookingServiceDao{
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
	public int totalPackage(int userId){
		String query="select sum(service_package) from booking_services where user_id='"+userId+"'group by user_id";
		Connection connection=null;
		Statement statement = null;
		int totalPackage=0;
		ResultSet resultSet=null;
		try {
			connection=ConnectionUtil.getDbConnection();
			statement=connection.createStatement();
			
			resultSet=statement.executeQuery(query);
			
			if(resultSet.next())
			{
				totalPackage=resultSet.getInt(1);
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
		
		return totalPackage;
		
	}
	public List<BookingServices> myBooking(int userId){
		List<BookingServices> serviceList =new ArrayList<>();
		String viewQuery="select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from Booking_services where user_id='"+userId+"'order by booking_date desc";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			 connection=ConnectionUtil.getDbConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(viewQuery);
			while(resultSet.next()) {
			BookingServices service=new BookingServices(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(6).toLocalDate(),resultSet.getDouble(7));
			serviceList.add(service);
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
		
		
     return serviceList;
	}
	
	public boolean checkDate(String servicename,LocalDate eventdate) {
		 String findVenue="select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where service_name='"+servicename+ "'and to_char(event_date,'yyyy-mm-dd')='"+eventdate+"'";
		 Connection connection=null;
			boolean flag=true;
			ResultSet resultSet=null;
			Statement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					new BookingServices(resultSet.getInt(2),resultSet.getInt(3),servicename,eventdate,resultSet.getDouble(7));
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
	
	public boolean checkService(String servicename,int userId) {
		 String findVenue="select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where service_name='"+servicename+ "'and user_id='"+userId+"'";
		 Connection connection=null;
			boolean flag=true;
			ResultSet resultSet=null;
			Statement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					new BookingServices(resultSet.getInt(2),resultSet.getInt(3),servicename,resultSet.getDate(6).toLocalDate(),resultSet.getDouble(7));
                
				}
				else {
				     flag=false;
								}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
			String updateQuery="update booking_services set status='cancelled' where  service_booking_id=?";
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.prepareStatement(updateQuery);
				
				statement.setInt(1, serviceId);
				
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
	 public LocalDate findBookingDate(int userId) {
		 String findVenue="select booking_Date from booking_services where user_id='"+userId+"'";
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
	 
	
	 public String findStatus(String serviceName,LocalDate eventDate) {
		 String findVenue="select status from booking_services where  service_name='"+serviceName+"' and to_char(event_date,'yyyy-mm-dd')='"+eventDate+"'";
		 Connection connection=null;
			String status=null;
			Statement statement=null;
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
	 
	 public int validateCancelBooking(int serviceBookingId) {
		 String findVenue="select floor((event_date)- to_date(sysdate)) as no_of_days from booking_services where service_booking_id='"+serviceBookingId+"'";
		 		
		 Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
			    resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					resultSet.getInt(1);
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
			
		 return serviceBookingId;
		 
	}
	 public int findBookingServiceId(int userId,LocalDate eventDate,String serviceName) {
		 String findVenue="select service_booking_id from booking_services where user_id='"+userId+"' and to_char(event_date,'yyyy-mm-dd')='"+eventDate+"' and service_name='"+serviceName+"'";
		 Connection connection=null;
			int serviceBookingId=0;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					serviceBookingId=resultSet.getInt(1);
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
			
			
		 return serviceBookingId;
		 
	}
	 public Boolean checkCancelServiceBooking(int serviceId) {
		 String findVenue="select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from booking_services where status='cancelled' and service_booking_id='"+serviceId+"'";
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
	 public List<BookingServices> allServiceBooking(){
			List<BookingServices> serviceList =new ArrayList<>();
			String viewQuery="select service_booking_id,user_id,service_id,service_name,booking_date,event_date,service_package,status from Booking_services";
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				resultSet=statement.executeQuery(viewQuery);
				while(resultSet.next()) {
				BookingServices service=new BookingServices(resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getDate(5).toLocalDate(),resultSet.getDate(6).toLocalDate(),resultSet.getDouble(7),resultSet.getString(8));
				serviceList.add(service);
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
			
			
	     return serviceList;
		}
	 
	 
	 }


  