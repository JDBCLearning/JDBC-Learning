package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class TestManageDBResource {
	

	public static void main(String[] args) throws SQLException {
		
		//Connection conn=DriverManager.getConnection(dbUrl, username, password);
		Connection conn=null;
		java.sql.Statement stmt=null;
		ResultSet rs = null;
				
		conn=DBUtil.getConnection(DBType.ORADB);
		stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=stmt.executeQuery("select * from Employees");
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		System.out.println("connection is established to oracle database successfully");
	}

}
