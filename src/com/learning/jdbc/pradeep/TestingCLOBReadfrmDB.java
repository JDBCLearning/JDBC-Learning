package com.learning.jdbc.pradeep;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestingCLOBReadfrmDB {

	public static void main(String[] args) throws SQLException, IOException {
		
		Connection conn = DBUtil.getConnection(DBType.ORADB);
		
		String sql = "select resume from NewEmployee where empid=111";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next())
		{
			Clob resume = rs.getClob("resume");
			Reader reader = resume.getCharacterStream();
			
			int i;
			String resumedet="";
			while ((i=reader.read())!=-1){
				resumedet+=((char)i);
			}
			System.out.println(resumedet);
		}else{
			System.out.println("No employee found!!!");
		}

	}

}
