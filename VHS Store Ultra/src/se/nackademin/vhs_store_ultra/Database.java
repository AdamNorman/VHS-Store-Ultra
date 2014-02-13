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