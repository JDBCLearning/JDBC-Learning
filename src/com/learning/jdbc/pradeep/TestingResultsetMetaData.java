package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestingResultsetMetaData {
	public static void main(String[] args) throws SQLException {
		try(
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select *from Employees");
				){
			ResultSetMetaData rsmd= rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
			
			String format = "%-50s%-25s%-20s%-20s\n";
			System.out.format(format,"Column Name","Column Type","Is NUllable","Is AutoIncreament");
			System.out.format(format,"-----------","-------------------","---------------------","--------------------------");
			for(int i=1;i<=columnCount;i++){
				System.out.format(format,rsmd.getColumnName(i),rsmd.getColumnType(i),rsmd.isNullable(i),rsmd.isAutoIncrement(i));
			}
			System.out.println("Total Columns : "+ columnCount);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}
