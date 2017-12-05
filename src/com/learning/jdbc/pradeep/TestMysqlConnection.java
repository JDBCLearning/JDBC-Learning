package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMysqlConnection {
	static final String username="root";
	static final String password="root";
	static final String dbUrl="jdbc:mysql://localhost:3306/world";

	public static void main(String[] args) throws SQLException {
	
		Connection conn=null;
		try {
			
			conn=DriverManager.getConnection(dbUrl, username, password);
			
			System.out.println("Connection established successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		finally{
			conn.close();
		}
		
				
	}

}
