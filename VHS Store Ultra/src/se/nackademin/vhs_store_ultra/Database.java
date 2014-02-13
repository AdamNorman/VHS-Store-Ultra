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

	public String getAllMovies(String s) {

		try {

			try {
				queryCaller = con.createStatement();
			} catch (SQLException e) {
				System.err
						.println("Create statement failed. " + e.getMessage());
				System.exit(1);
			}

			ResultSet rs = queryCaller
					.executeQuery("Select * From sort_titles_genre");
			rs.first();

			String movieData = null;

			
			while (rs.next()) {
				
				movieData += rs.getString("genre");

				System.out.println(rs.getString("genre") + "\t\t\t"
						+ (rs.getString("title")));
				rs.next();

			}
			
			return movieData;
			
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}

	}

}