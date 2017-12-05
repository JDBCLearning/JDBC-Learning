package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecordPreparedStmt {

	public static void main(String[] args) throws SQLException {
		
		Connection conn =  DBUtil.getConnection(DBType.ORADB);
		
		int locid;
		String StAdd;
		String postCode;
		String city;
		String state;
		String country;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter location id :");
		locid=Integer.parseInt(scan.nextLine());
		System.out.println("Enter Street address :");
		StAdd=scan.nextLine();
		System.out.println("Enter post code: " );
		postCode = scan.nextLine();
		System.out.println("Entre city :");
		city=scan.nextLine();
		System.out.println("Enter state :");
		state=scan.nextLine();
		System.out.println("Enter country");
		country=scan.nextLine();
		
		String sql = "insert into locations values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, locid);
		pstmt.setString(2, StAdd);
		pstmt.setString(3, postCode);
		pstmt.setString(4, city);
		pstmt.setString(5, state);
		pstmt.setString(6, country);
		
		int updateResult = pstmt.executeUpdate();
		
		if(updateResult==1){
			System.out.println("Recored inserted successfully.");
		}else{
			System.err.println("Error occured while inserting record");
		}
	}

}
