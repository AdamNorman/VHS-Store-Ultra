package se.nackademin.vhs_store_ultra;

import java.sql.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	public static void main(String[] args) {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("vhs_store_ultra");
		
		Connection con = null;
		try {
			//DO NOT SHOW PASSWORD IN YOUR CODE IN YOUR REAL APPLICATION
			con = ds.getConnection("root", "");
		} catch (SQLException e) {
			System.err.println("Error: Couldn't connect. " + e.getMessage());
			return;
		}
		
		System.out.println("Connection successful!");
		
		Statement queryCaller = null;
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Error! Could not create statement. " + e.getMessage());
			try {
				con.close();
			} catch (SQLException e1) {
				System.err.println("Warning: Could not close connection. " + e.getMessage());
			}
			return;
		}
		
		System.out.println("Create statement successful!");
		
		ResultSet results = null;
				
		try {
			//INSERT
//			int affectedRows = queryCaller.executeUpdate("INSERT INTO person VALUES('800312', 'Lionel', '08112233')");
//			System.out.println("Affected rows: " + affectedRows);
			
			//SELECT
			results = queryCaller.executeQuery("SELECT * FROM customer");
			System.out.println("Print first row:");
			results.first();
			System.out.println(results.getString("name"));
			
			System.out.println("Print all rows:");
			results.beforeFirst();
			while(results.next()){
				System.out.println(results.getString("name"));
			}
			
			//MetaData
			ResultSetMetaData resultInfo = results.getMetaData();
			int nCols = resultInfo.getColumnCount();
			for(int i = 1; i < nCols+1; i++){
				System.out.print(resultInfo.getColumnLabel(i) + " ");
			}
			System.out.println();
			results.beforeFirst();
			while(results.next()){
				for(int i = 1; i < nCols+1; i++){
					System.out.print(results.getString(i) + " ");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			System.err.println("SQL query failed! " + e.getMessage());
		}
		
		//BATCH
		try {
			queryCaller.addBatch("INSERT INTO customer VALUES('800313', 'Jennie', '08112233')");
			queryCaller.addBatch("INSERT INTO customer VALUES('800314', 'Raynold', '08112233')");
			queryCaller.addBatch("INSERT INTO customer VALUES('800315', 'Patric', '08112233')");
			queryCaller.addBatch("DELETE FROM customer WHERE personid='800315'");
			queryCaller.executeBatch();
			System.out.println("Batching success!");
		} catch (SQLException e1) {
			System.err.println("SQL query failed! " + e1.getMessage());
		}
		
		//PREPARED
		PreparedStatement preparedStm = null;
		try {
			String nameInput = "Anna";
			preparedStm = con.prepareStatement("INSERT INTO customer VALUES(?, ?, '08112233')");
			preparedStm.setInt(1, 871111);
			preparedStm.setString(2, nameInput);
			preparedStm.executeUpdate();

			preparedStm.setInt(1, 871114);
			preparedStm.setString(2, "Charles");
			preparedStm.addBatch();
			preparedStm.setInt(1, 871112);
			preparedStm.addBatch();
			preparedStm.executeBatch();
			System.out.println("Prepared statement usage success!");
			
		} catch (SQLException e1) {
			System.err.println("Error! Prepared statement failed. " + e1.getMessage());
		} finally{
			//We're only using the preparedStatement object here, so we can close it in the finally-block
			if(preparedStm != null){
				try {
					preparedStm.close();
				} catch (SQLException e) {
					System.out.println("Warning: Couldn't close the statement.");
				}
			}

		}
		
		//TRANSACTION
		try {
			con.setAutoCommit(false);
			//Our new transaction starts----
			int maxChanges = 5;
			int nChanges = 0;
			nChanges += queryCaller.executeUpdate("INSERT INTO customer VALUES('901012', 'Yvonne', '08292929')");
			nChanges += queryCaller.executeUpdate("UPDATE customer SET phonenumber='08080808' WHERE name='Yvonne'");
			nChanges += queryCaller.executeUpdate("INSERT INTO customer VALUES('901013', 'Martin', '08292929')");
			
			if(nChanges > maxChanges){
				//Transaction ends. New transaction starts.
				con.rollback();
				System.out.println("Too many changes! Rollback. Number of changes: " + nChanges);
			}
			else{
				//Transaction ends. New transaction starts.
				con.commit();
				System.out.println("Commiting changes.");
			}
		} catch (SQLException e1) {
			try {
				//Transaction ends. New transaction starts.
				con.rollback();
			} catch (SQLException e) {
				System.err.println("Rollback failed! " + e1.getMessage());
			}
			System.err.println("Transaction failed! " + e1.getMessage());
		}

		try {
			//Turning autocommit back on
			con.setAutoCommit(true);
		} catch (SQLException e1) {
			System.err.println("Error! Could not set autocommit to true.");
		}
		
		//CLOSE EVERYTHING
		if(results != null){
			try {
				results.close();
			} catch (SQLException e) {
				System.out.println("Warning: Couldn't close results.");
			}
		}
		if(queryCaller != null){
			try {
				queryCaller.close();
			} catch (SQLException e) {
				System.out.println("Warning: Couldn't close the statement.");
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Warning: Couldn't close the connection.");
			}
		}
	}
	
}
