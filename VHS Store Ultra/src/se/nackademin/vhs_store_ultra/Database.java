package se.nackademin.vhs_store_ultra;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {
	
	MysqlDataSource ds = new MysqlDataSource();
	private Connection con = null;
	Statement queryCaller = null;
	String movieData;
	
	
	// Setup the connection properties
	public void init() {
		MysqlDataSource ds = new MysqlDataSource();
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
	
	
	public void setupDatabase() {
		// Create a statement object for sending queries
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Create statement failed! " + e.getMessage());
			System.exit(1);
		}
	}
	
	
	//Method to list ALL movies orded by genre...
	public String getAllMovies() {
		ResultSet rs = null;
		movieData = "";
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Sort_titles_genre");
			rs.first();
			while (rs.next()) {
				movieData += rs.getString("genre") + "\t\t" + (rs.getString("title") + System.lineSeparator());
			}
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	//Method to list pending orders from Rental...
    public String getOrders() {
        movieData = "";
        ResultSet rs = null;
        try {
            setupDatabase();
            rs = queryCaller.executeQuery("SELECT * FROM Pending_orders");
            rs.first();
            do {
                movieData += rs.getString("Order") + ", " + (rs.getString("Rented by") + ", " + (rs.getString("Customer contact") + System.lineSeparator()));
            } while (rs.next());
        } catch (SQLException ex) {
            System.err.println("SQL Query failed" + ex.getMessage());
        }
        return movieData;
    }


	
	
	//Method to list ten movies with highest ratings...
	public String getTopTen() {
		movieData = "";
		ResultSet rs = null;
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Top_ten_movies");
			rs.first();
			//TODO: null SKA INTE SKRIVAS UT! utrett
			do {
				movieData += rs.getString("Score") + "\t\t" + (rs.getString("Title") + System.lineSeparator());
			} while (rs.next());
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	

    public String deleteCust(String str) {
        ResultSet rs = null;
        PreparedStatement delete = null;
        setupDatabase();

        
        try {
           
            delete = con.prepareStatement("DELETE FROM Customer WHERE personid LIKE ?");
            delete.setString(1, str + "%");
            delete.executeQuery();
            rs = delete.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieData;
    }


    public String search(String str) {
        ResultSet rs = null;
        PreparedStatement search = null;
        try {
            search = con.prepareStatement("SELECT Movie.title, Quality_control.review "
                    + "FROM Movie, Quality_control WHERE Movie.movie_id=Quality_control.movie_id AND Movie.title LIKE ?");
            search.setString(1, str+"%");
            search.executeQuery();
            rs = search.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        movieData = "";
        try {
            setupDatabase();
            rs.first();
            do {
                movieData += "TITLE:" + System.lineSeparator() + rs.getString("title") + System.lineSeparator() + System.lineSeparator() 
                        + "REVIEW:" + System.lineSeparator() + rs.getString("review") + System.lineSeparator() + System.lineSeparator();
            } while (rs.next());
        } catch (SQLException ex) {
            System.err.println("SQL Query failed! " + ex.getMessage());
        }
        return movieData;
    }

	
	
	// Close the connection
	public void cleanUp() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Close connection failed! " + e.getMessage());
			}
		}
	}

}
