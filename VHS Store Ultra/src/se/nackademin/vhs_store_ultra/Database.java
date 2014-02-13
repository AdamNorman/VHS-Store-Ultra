package se.nackademin.vhs_store_ultra;

import java.sql.*;
<<<<<<< HEAD
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
=======
>>>>>>> 68fcca40bf91b38d1c65be887926590559bd3d7a
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

<<<<<<< HEAD

		MysqlDataSource ds = new MysqlDataSource();
        private Scanner input = null;
        private Connection con = null;
        Statement queryCaller = null;
		
        public void init(){
                     
            MysqlDataSource ds = new MysqlDataSource();

            //Setup the connection properties
            ds.setServerName("localhost");
            ds.setPort(3306);
            ds.setDatabaseName("vhs_store_ultra");
            String user = "root";
            ds.setUser(user);
            String pw = "";
            ds.setPassword(pw);
=======
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
		
        //Statement sqlState = con.createStatement();

		
		ResultSet results = null;
				
		try {
			//INSERT
			//int affectedRows = queryCaller.executeUpdate("INSERT INTO person VALUES('800312', 'Lionel', '08112233')");
			//System.out.println("Affected rows: " + affectedRows);
			
			//SELECT
			results = queryCaller.executeQuery("SELECT * FROM Sort_genre_action");
			//System.out.println("Print first row:");
			results.first();
			
			while(results.next()) {
				System.out.println(results.getString("title") + ", " + results.getString("genre"));
			}
		} catch (SQLException e) {
			System.err.println("SQL query failed! " + e.getMessage());
		}
		
		//Close the result set and statement
			if(results != null) {
				try {
					results.close();
				} catch (SQLException e) {
					System.err.println("Close result set failed! " + e.getMessage());
				}
			}
			if(queryCaller != null) {
				try {
					queryCaller.close();
				} catch (SQLException e) {
					System.err.println("Close statement failed! " + e.getMessage());
				}
			}
			
			/*
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
			*/
			
>>>>>>> 68fcca40bf91b38d1c65be887926590559bd3d7a

            //Connect to the database
            try {
                con = ds.getConnection();
                
            } catch (SQLException e) {
                System.err.println("Connection failed! " + e.getMessage());
                System.exit(1);
            }
            
            System.out.println("Connection successful.");
            
        }
        
        public void getAllMovies(){             
                          
              try
              {
                                    
                  try {
                      queryCaller = con.createStatement();
                  } catch (SQLException e) {
                      System.err.println("Create statement failed. " + e.getMessage());
                      System.exit(1);
                  }
                  
          ResultSet rs = queryCaller.executeQuery("Select * From sort_titles_genre");  
          rs.first();

                      for(int i = 0; i < 30; i++)
          {                      
                              movieTextArea.append(rs.getString("genre")+ "			" + (rs.getString("title")));
                              movieTextArea.append(System.lineSeparator());
                              rs.next();                         
                              
          }
                      
//                      JOptionPane.showMessageDialog(null, "Retrieved data succesfully.","Record Retrieved",
//                                      JOptionPane.INFORMATION_MESSAGE);
              }
              catch(Exception ex)
              {
                      JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                                      JOptionPane.ERROR_MESSAGE);
              }     
              
//          }
                
      }    

        
        
}
