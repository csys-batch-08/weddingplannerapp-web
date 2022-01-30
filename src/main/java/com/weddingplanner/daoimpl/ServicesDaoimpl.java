package com.weddingplanner.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.weddingplanner.dao.ServicesDao;
import com.weddingplanner.module.Services;
import com.weddingplanner.util.ConnectionUtil;

public class ServicesDaoimpl implements ServicesDao {
	public List<Services> showServices(){
		List<Services> serviceList =new ArrayList<>();
		String viewQuery="select service_id,service_name,service_package,service_images,availability,service_type,service_description,service_type_images from service_details";
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=ConnectionUtil.getDbConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(viewQuery);
			while(resultSet.next()) {
			Services service=new Services(resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5));
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
	public void insertService(Services service) {
		String insertQuery="insert into service_details(service_name,service_package,service_images,service_type,service_description,service_type_images)values(?,?,?,?,?,?)";
	     Connection connection=null;
	     PreparedStatement statement=null;
	     try {
	    	 connection=ConnectionUtil.getDbConnection();
			statement=connection.prepareStatement(insertQuery);
			statement.setString(1, service.getServiceName());
			statement.setDouble(2, service.getServicePackage());
			statement.setString(3, service.getServiceImages());
			statement.setString(4, service.getServiceType());
			statement.setString(5,service.getServiceDescription() );
			statement.setString(6,service.getServiceTypeImage() );

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
	
	
	 
	 
	 
	 
	 public  double findPackage(int serviceId)
		{
			String query="select service_package from service_details where service_id='"+serviceId+"'";
			
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			double servicePackage=0;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				
				resultSet=statement.executeQuery(query);
				
				if(resultSet.next())
				{
					servicePackage=resultSet.getDouble(1);
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
			
			return servicePackage;
			
		}
	 
	
	 
	 public int updateRatingProfile(int ratings) {
			String updateQuery="update service_details set ratings=?";
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.prepareStatement(updateQuery);
				statement.setInt(1, ratings);
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
			
		 return ratings;
		} 
	 public int findServiceId(String serviceName) {
		 String findVenue="select service_id from service_details where service_name='"+serviceName+"'";
		 Connection connection=null;
			int serviceId=0;
			Statement statement=null;
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement = connection.createStatement();
				resultSet=statement.executeQuery(findVenue);
				if(resultSet.next()) {
					serviceId=resultSet.getInt(1);
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
			
		 return serviceId;
	 }
	 public Services allService(String serviceName) {
		
		 String validateQuery="select service_id,service_name,service_package,service_images,availability,service_type,service_description,service_type_images from service_details WHERE  service_name='"+serviceName+"'";
		 
		 Connection connection=null;
		 Services service=null;
		 Statement statement=null;
			
			ResultSet resultSet=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.createStatement();
				resultSet = statement.executeQuery(validateQuery);
				while(resultSet.next()) {
					
					 service=new Services(resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));			
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
			
			
		
		
		 return service;
	 
	 }
	 
	 public void updateServiceAvailability(String availability) {
			String updateQuery="update service_details set availability='No' where service_name=?";
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.prepareStatement(updateQuery);
				statement.setString(1, availability);
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
	 public void updateService(Services service) {
			String updateQuery="update service_details set service_type=?,service_package=?,service_images=?,service_description=?,service_type_images=? where service_name=?";
			Connection connection=null;
			PreparedStatement statement=null;
			try {
				connection=ConnectionUtil.getDbConnection();
				statement=connection.prepareStatement(updateQuery);
				statement.setString(1, service.getServiceType());
				statement.setDouble(2, service.getServicePackage());
				statement.setString(3, service.getServiceImages());
				statement.setString(4, service.getServiceDescription());
				statement.setString(5, service.getServiceTypeImage());
				statement.setString(6, service.getServiceName());
				
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
			public List<Services> showServiceType(){
				List<Services> serviceList =new ArrayList<>();
				String viewQuery="select distinct service_type,service_type_images from service_details ";
				Connection connection=null;
				Statement statement=null;
				ResultSet resultSet=null;
				try {
					connection=ConnectionUtil.getDbConnection();
					statement=connection.createStatement();
					resultSet=statement.executeQuery(viewQuery);
					while(resultSet.next()) {
					Services	service=new Services(resultSet.getString(1),resultSet.getString(2));	
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
			public List<Services> showServiceList(String serviceType){
				List<Services> serviceList =new ArrayList<>();
				String viewQuery="select service_id,service_name,service_package,service_images,availability,service_type,service_description,service_type_images from service_details where service_type=?";
				Connection connection=null;
				PreparedStatement statement=null;
				ResultSet resultSet=null;

				try {
					 connection=ConnectionUtil.getDbConnection();
					statement=connection.prepareStatement(viewQuery);
					statement.setString(1, serviceType);
					resultSet=statement.executeQuery();
					while(resultSet.next()) {
						Services service=new Services(resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
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
			public List<Services> filterByPrice(Double servicePackage) {
				 List<Services> serviceList=new ArrayList<>();
				 String query="select service_id,service_name,service_package,service_images,availability,service_type,service_description,service_type_images from service_details where service_package=?";
				 Connection connection=null;
				 PreparedStatement statement=null;
				 ResultSet resultSet=null;

					try {
						connection=ConnectionUtil.getDbConnection();
						statement=connection.prepareStatement(query);
						statement.setDouble(1, servicePackage);
						resultSet=statement.executeQuery();
						while(resultSet.next()) {
							Services service=new Services(resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8));
	
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
