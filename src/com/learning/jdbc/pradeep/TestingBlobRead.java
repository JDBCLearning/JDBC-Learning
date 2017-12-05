package com.learning.jdbc.pradeep;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestingBlobRead {

	public static void main(String[] args) throws SQLException, IOException {
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		String sql = "Select photo from NewEmployee where empid=111";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			Blob img = rs.getBlob("photo");
			
			FileOutputStream fous = new FileOutputStream("C:\\Users\\pradeep.ae.kumar\\Desktop\\kavita's docs\\0100.jpg");
			fous.write(img.getBytes(1, (int)img.length()));
			
			fous.flush();
			fous.close();
			System.out.println(" Photo is downloaded...");
		}else{
			rs.close();
			pstmt.close();
			conn.close();
		}
		
	}

}
