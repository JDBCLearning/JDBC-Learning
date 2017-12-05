package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatbableResultSet {

	public static void main(String[] args) throws SQLException {
		try(
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery("select Department_id, Department_name, Manager_id,Location_id from Departments");
				){
			rs.absolute(6);
			rs.updateString("Department_name","Information Technology");
			rs.updateRow();
			
			System.out.println("Recors updated successfully");
			
			rs.moveToInsertRow();
			rs.updateInt("Department_id",1000);
			rs.updateString("Department_Name", " PTO Training");
			rs.updateInt("Manager_id", 200);
			rs.updateInt("Location_id", 1800);
			rs.insertRow();
			
			System.out.println("Record inserted succeessfully");
		}

	}

}
