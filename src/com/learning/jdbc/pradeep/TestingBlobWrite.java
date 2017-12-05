package com.learning.jdbc.pradeep;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestingBlobWrite {

	public static void main(String[] args) throws SQLException, IOException {
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "update NewEmployee set photo =? where empid=111";
		PreparedStatement pstmt =  conn.prepareStatement(sql);
		
		File file = new File("C:\\Users\\pradeep.ae.kumar\\Desktop\\kavita's docs\\01.jpg");
		FileInputStream fous = new FileInputStream(file);
		
		pstmt.setBinaryStream(1, fous,fous.available());
		int count=pstmt.executeUpdate();
		
		System.out.println("Records updated : "+count);
		pstmt.close();
		conn.close();
		

	}

}
