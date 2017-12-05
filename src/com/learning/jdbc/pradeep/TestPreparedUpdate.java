package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedUpdate {

	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "update locations set postal_code=? where location_id=?";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter location id :");
		int locid=scanner.nextInt();
		System.out.println("Enter postal code");
		String postCode= scanner.nextLine();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, postCode);
		pstmt.setInt(2, locid);
		
		int result= pstmt.executeUpdate();
		
		if(result==1){
			System.out.println("Recored updated successfully");
		}else{
			System.err.println("Error occured");
		}
		scanner.close();
		pstmt.close();
		conn.close();
	}

}
