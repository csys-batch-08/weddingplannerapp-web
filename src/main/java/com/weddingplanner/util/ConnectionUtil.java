package com.weddingplanner.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getDbConnection()  {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url=("jdbc:oracle:thin:@localhost:1521:xe");
			con = DriverManager.getConnection(url, "system", "oracle");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} 
		return con;
		}
		public void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException
		{
		if(rs != null)
		{
		rs.close();
		}
		if(pstmt != null)
		{
		pstmt.close();
		}
		if(con != null)
		{
		con.close();
		}


		
		
		
	}
}
