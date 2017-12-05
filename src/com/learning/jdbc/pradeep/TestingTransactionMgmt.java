package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestingTransactionMgmt {

	public static void main(String[] args) {
		try{
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				conn.setAutoCommit(false);
				
				PreparedStatement pstmt = null;
				Scanner scan=new Scanner(System.in);
				System.out.println("Enter From Account # :");
				int frmAcn=Integer.parseInt(scan.nextLine());
				System.out.println("Enter To Account #:");
				int ToAcn= Integer.parseInt(scan.nextLine());
				System.out.println("enter amount to transfer :");
				double amt=Double.parseDouble(scan.nextLine());
				
				String withdraw="Update PSBANK set amount = amount - ? where accno = ?";
				pstmt=conn.prepareStatement(withdraw);
				pstmt.setDouble(1, amt);
				pstmt.setInt(2, frmAcn);
				pstmt.executeUpdate();
				
				String deposit = "Update PSBANK set amount = amount + ? where accno = ?";
				pstmt=conn.prepareStatement(deposit);
				pstmt.setDouble(1, amt);
				pstmt.setInt(2, ToAcn);
				pstmt.executeUpdate();
				
				String sql ="Select amount from PSBANK where accno = ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, frmAcn);
				ResultSet rs= pstmt.executeQuery();
				double balanceamount=0;
				if(rs.next()){
					balanceamount=rs.getDouble("amount");
				}
				if(balanceamount>=500){
					conn.commit();
					System.out.println("Amount transferred successgully...");
				}else{
					conn.rollback();
					System.out.println("Insufficent funds :"+balanceamount+" transaction rollbacked");
				}
				
				scan.close();
				pstmt.close();
				conn.close();
				
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}

}
