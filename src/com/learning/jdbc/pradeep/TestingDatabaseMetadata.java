package com.learning.jdbc.pradeep;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestingDatabaseMetadata {

	public static void main(String[] args) throws SQLException {
		try(
				Connection conn=  DBUtil.getConnection(DBType.ORADB);
				)
		{
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver name : " +dbmd.getDriverName());
			System.out.println("Driver version : " +dbmd.getDriverVersion());
			System.out.println("Logged in user : " +dbmd.getUserName());
			System.out.println("database product name : " +dbmd.getDatabaseProductName());
			System.out.println("database product version : " +dbmd.getDatabaseProductVersion());
			
			///get tables
			String catalog =  null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String scehmaTypes[] = null;
			ResultSet rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, scehmaTypes);
			
			while (rs.next()){
				System.out.println("+++++++++++===========================");
				System.out.println(rs.getString("TABLE_NAME"));
				//System.out.println("+++++++++++===========================");
			
			//get columns
			String columnNamePattern=null;
			rs=dbmd.getColumns(catalog, schemaPattern, "COUNTRIES", columnNamePattern);
			
			while(rs.next()){
				System.out.println("+++++++++++===========================");
				System.out.println(rs.getString("COLUMN_NAME"));
			}
			}
			rs.close();
			conn.close();
		}
		
	}

}
