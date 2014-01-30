package se.nackademin.vhs_store_ultra;

//NiclasBerner IS COMMITING!
//HEJ!

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	public static void main(String[] args) {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("vhs_store_ultra");
		
		Connection con = null;
		try {
			// DO NOT SHOW YOUR PASSWORD IN YOUR CODE ON A REAL PROJECT!
			con = ds.getConnection("root", "");
		} catch (SQLException e) {
			System.err.println("Error: Couldn't connect " + e.getMessage());
			return;
		}

		System.out.println("Connection successfull");
		
		Statement queryCaller = null;
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Error: Could not create statement" + e.getMessage());
			try {
				con.close();
			} catch (SQLException e1) {
				System.err.println("Error: Could not close connection " + e1.getMessage());
			
			}
			return;
		}
		
		System.out.println("Create statement successfull");
		
		ResultSet results = null;
		
		try {
			results = queryCaller.executeQuery("SELECT * FROM customer");
			System.out.println("Print first row: ");
			results.first();
			System.out.println(results.getString("name"));
			System.out.println(results.getString("city"));
			
			System.out.println("Print all rows: ");
			results.beforeFirst();
			while(results.next()) {
				
				System.out.println(results.getString("name"));
				System.out.println(results.getString("city"));
				
			}
			
		}
		catch (SQLException e){
			System.err.println("SQL query failed! " + e.getMessage());
		}
		
		// CLOSE EVERYTHING
		if(results != null){
			try {
				results.close();
			}
			catch(Exception e) {
				System.out.println("Warning: Couldn't close the statement...");
			}
			
		}
	}

}
