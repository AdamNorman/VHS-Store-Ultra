package se.nackademin.vhs_store_ultra;

import java.sql.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	MysqlDataSource ds = new MysqlDataSource();
	private Connection con = null;
	Statement queryCaller = null;
	String movieData;
	PropHandling ph = new PropHandling();

	// Setup the connection properties for Customer
	public void custInit(String custPass) {
		ph.readProperties("config_properties.txt");
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("vhs_store_ultra");
		String user = "customer_user";
		ds.setUser(user);
		String pw = ph.getProperty("custPass");
		ds.setPassword(pw);
		// Connect to the database
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			System.err.println("Connection failed! " + e.getMessage());
			System.exit(1);
		}
		System.out.println("Customer is connected.");
	}

	// Setup the connection properties for Store Staff
	public void staffInit(String staffPass) {
		ph.readProperties("config_properties.txt");
		MysqlDataSource ds = new MysqlDataSource();
		ds.setServerName("localhost");
		ds.setPort(3306);
		ds.setDatabaseName("vhs_store_ultra");
		String user = "staff_user";
		ds.setUser(user);
		String pw = ph.getProperty("staffPass");
		ds.setPassword(pw);
		// Connect to the database
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			System.err.println("Connection failed! " + e.getMessage());
			System.exit(1);
		}
		System.out.println("Staff is connected.");
	}
	
	
	// Ett Statement objekt skapas för att skicka queries
	public void setupDatabase() {
		try {
			queryCaller = con.createStatement();
		} catch (SQLException e) {
			System.err.println("Create statement failed! " + e.getMessage());
			System.exit(1);
		}
	}
	
	
	// Metod som returnerar alla filmer i db:n genom en skapad sql-vy
	public String getAllMovies() {
		ResultSet rs = null;
		movieData = "";
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Sort_titles_genre");
			rs.first();
			while (rs.next()) {
				movieData += rs.getString("genre") + "\t\t"
						+ (rs.getString("title") + System.lineSeparator());
			}
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	
	// Metod som listar alla filmer (in_stock och title)
	public String inStock() {
		ResultSet rs = null;
		movieData = "";
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM titles_in_stock");
			rs.first();
			while (rs.next()) {
				movieData += "In stock: " + rs.getString("in_stock") + "\t"
						+ (rs.getString("title") + System.lineSeparator());
			}
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	
	// Metod som returnerar alla inneliggande ordrar genom en skapad sql-vy
	public String getOrders() {
		movieData = "";
		ResultSet rs = null;
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Pending_orders");
			rs.first();
			do {
				movieData += rs.getString("Order")
						+ ", "
						+ (rs.getString("Rented by") + ", " + (rs
								.getString("Customer contact") + System
								.lineSeparator()));
			} while (rs.next());
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	
	// Metod som returnerar de 10 högst betygsatta filmerna genom en skapad sql-vy
	public String getTopTen() {
		movieData = "";
		ResultSet rs = null;
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Top_ten_movies");
			rs.first();
			do {
				movieData += rs.getString("Score") + "\t\t"
						+ (rs.getString("Title") + System.lineSeparator());
			} while (rs.next());
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	
	// Metod som returnerar alla befintliga kunder i db:n
	public String listAllCust() {
		movieData = "";
		ResultSet rs = null;
		try {
			setupDatabase();
			rs = queryCaller.executeQuery("SELECT * FROM Customer");
			rs.first();
			do {
				movieData += rs.getString("personid")
						+ "\t"
						+ (rs.getString("name") + "\t"
								+ rs.getString("phonenumber") + System
									.lineSeparator());
			} while (rs.next());
		} catch (SQLException ex) {
			System.err.println("SQL Query failed" + ex.getMessage());
		}
		return movieData;
	}
	
	
	//TODO: Här påbörjade vi en metod som var tänkt att radera en vald kund ur databasen
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
	
	
	// Metod som tar en sträng som inparameter och gör en matchning mot filmtitlarna i db:n
	public String search(String str) {
		ResultSet rs = null;
		PreparedStatement search = null;
		try {
			search = con.prepareStatement("SELECT Movie.title, Quality_control.review "
							+ "FROM Movie, Quality_control WHERE Movie.movie_id=Quality_control.movie_id AND Movie.title LIKE ?");
			search.setString(1, "%" + str + "%");
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
				movieData += "Title:" + System.lineSeparator()
						+ rs.getString("title") + System.lineSeparator()
						+ System.lineSeparator() + "Review:"
						+ System.lineSeparator() + rs.getString("review")
						+ System.lineSeparator() + System.lineSeparator();
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
				System.err
						.println("Close connection failed! " + e.getMessage());
			}
		}
		System.out.println("Connection to Database is successfully closed.");
	}

}
