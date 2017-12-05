package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScrollingDemo {
	public static void main(String[] args) {
		try(
				Connection conn=DBUtil.getConnection(DBType.ORADB);
				Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("Select * From employees Where Rownum <= 10");
			)
		{
			rs.beforeFirst();
			System.out.println("first 10 rows:-----");
			while(rs.next()){
				System.out.println(rs.getString("EMPLOYEE_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			}
			
			rs.afterLast();
			System.out.println("Last 10 rows : ====");
			while(rs.previous()){
				System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			}
			
			rs.first();
			System.out.println("first record: ==");
			System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			
			rs.last();
			System.out.println("last record: ==");
			System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			
			rs.absolute(4);
			System.out.println("fourth record: ==");
			System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			
			rs.relative(2);
			System.out.println("sixsth record: ==");
			System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			
			rs.relative(-4);
			System.out.println("second record: ==");
			System.out.println(rs.getString("EMployee_ID")+" "+rs.getString("First_name")+" "+rs.getString("Last_name")+" "+rs.getString("salary"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
