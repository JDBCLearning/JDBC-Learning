package com.learning.jdbc.pradeep;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestingCLOB {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		PreparedStatement pstmt = null;
		
		String sql  ="update NewEmployee set resume = ? where empid =111";
		pstmt=conn.prepareStatement(sql);
		
		String resumeFile="C:\\Users\\pradeep.ae.kumar\\Documents\\client_log.txt";
		File file = new File(resumeFile);
		FileReader reader = new FileReader(file);
		
		pstmt.setCharacterStream(1, reader,(int)file.length());
		pstmt.executeUpdate();
		
		System.out.println("Resume uploaded successfully....");
		pstmt.close();
		conn.close();
		
		
	}

}
