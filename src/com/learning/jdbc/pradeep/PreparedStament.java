package com.learning.jdbc.pradeep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStament {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try{
				conn=DBUtil.getConnection(DBType.ORADB);
				String sql = "Select * from employees where salary < ? and department_id = ?";
				pstmt=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				pstmt.setDouble(1, 10000);
				pstmt.setInt(2, 50);
				
				rs=pstmt.executeQuery();
				while(rs.next()){
					System.out.println(rs.getString("Employee_id")+"------ "+rs.getString("First_name")+"-------- "+rs.getString("Last_name")+ "---- "+rs.getString("salary"));
				}
				rs.last();
				System.out.println("Total Employees :: "+rs.getRow() );
		}
		catch(SQLException e)	
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}	
		finally {
			rs.close();
			pstmt.close();
			conn.close();
		}

	}

}
