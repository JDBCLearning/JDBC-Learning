package com.learning.jdbc.pradeep;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCallableIN {

	public static void main(String[] args) throws SQLException {
		try(
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				CallableStatement ctmt = conn.prepareCall("{call addlocation (?,?,?,?,?,?)}");
				)
		{
			int loc;
			String St_add;
			String pcode;
			String city;
			String state;
			String country;
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter location id :");
			loc=Integer.parseInt(scan.nextLine());
			System.out.println("Enter Street address :");
			St_add=scan.nextLine();
			System.out.println("Enter post code: " );
			pcode = scan.nextLine();
			System.out.println("Entre city :");
			city=scan.nextLine();
			System.out.println("Enter state :");
			state=scan.nextLine();
			System.out.println("Enter country");
			country=scan.nextLine();
			
			ctmt.setInt(1, loc);
			ctmt.setString(2, St_add);
			ctmt.setString(3, pcode);
			ctmt.setString(4, city);
			ctmt.setString(5, state);
			ctmt.setString(6, country);
			
			ctmt.execute();
			System.out.println("Record added successfully");
		}catch(SQLException e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
