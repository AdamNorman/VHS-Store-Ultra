package se.nackademin.vhs_store_ultra;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	MysqlDataSource ds = new MysqlDataSource();
	private Scanner input = null;
	private Connection con = null;
	Statement queryCaller = null;
	String movieData;

	public void init() {

		MysqlDataSource ds = new MysqlDataSource();

		// Setup the connection properties
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("vhs_store_ultra");
		String user = "root";
		ds.setUser(user);
		String pw = "";
		ds.setPassword(pw);

		// Connect to the database
		try {
			con = ds.getConnection();

		} catch (SQLException e) {
			System.err.println("Connection failed! " + e.getMessage());
			System.exit(1);
		}

		System.out.println("Connection successful.");

	}

	public String getAllMovies() {

		try {

			setupDatabase();

			ResultSet rs = queryCaller.executeQuery("Select * From sort_titles_genre");
			rs.first();

			while (rs.next()) {

				movieData += rs.getString("genre") + "\t"
						+ (rs.getString("title") + System.lineSeparator());

			}

		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;

	}

	public void cleanUp() {
		// Close the connection
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Close connection failed! " + e.getMessage());
			}
		}

		input.close();
	}

	public void setupDatabase() {
		// Create a statement object for sending queries
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Create statement failed. " + e.getMessage());
			System.exit(1);
		}

	}

}