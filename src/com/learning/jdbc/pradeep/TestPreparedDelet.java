package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedDelet {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql="Delete from locations where location_id=?";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter location id: ");
		int loc = scanner.nextInt();
		
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		
		pstmt.setInt(1, loc);
		
		int result = pstmt.executeUpdate();
		
		if(result==1){
			System.out.println("Recored Deleted successfully");
		}else{
			System.err.println("Error occured");
		}
		scanner.close();
		pstmt.close();
		conn.close();
	}

}
