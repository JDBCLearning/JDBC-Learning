package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class TestConnectionPooling {
	public static void main(String[] args) throws SQLException {
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		ds.setDriverType("thin");
		ds.setServerName("localhost");
		ds.setServiceName("xe");
		ds.setPortNumber(1521);
		ds.setUser("hr");
		ds.setPassword("hr");
		
		javax.sql.PooledConnection pconn =  ds.getPooledConnection();
		
		Connection conn = pconn.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Departments");
		
		String format="%-30s%-50s%-25s\n";
		System.out.format(format,"Department #", "Department Name","Location");
		
		while(rs.next()){
			System.out.format(format,rs.getString("Department_ID"),rs.getString("Department_name"),rs.getString("Location_ID"));
		}
	}

}
