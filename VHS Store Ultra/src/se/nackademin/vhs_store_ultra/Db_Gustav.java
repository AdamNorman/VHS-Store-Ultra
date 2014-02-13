

package se.nackademin.vhs_store_ultra;

import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.awt.event.*;
public class  Db_Gustav implements ActionListener{

        private Scanner input = null;
        private Connection con = null;
        JButton b=new JButton("Get Data");
        TextArea textArea = new TextArea();
        Customer custTest = new Customer();


        
        
        public void createUI()
        {
                JFrame f=new JFrame();
        f.getContentPane().setLayout(null);
        JLabel label=new JLabel("Database data : ");        
        b.addActionListener(this);
        
        label.setBounds(10,40,100,20);
        b.setBounds(10,71,100,20);
        
        f.getContentPane().add(label);
        f.getContentPane().add(b);
        textArea.setEditable(false);
        
        textArea.setBounds(116, 10, 391, 303);
        f.getContentPane().add(textArea);
        f.setVisible(true);
        f.setSize(537,362);
        init();
        }
        public void init(){
            
            
            //Create a scanner object to use for user input
            input = new Scanner(System.in);
            
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
            getOperation();
            //Create a statement object for sending queries
            
        
            
        }
        
    public static void main(String[] args){
        Db_Gustav dd = new Db_Gustav();
        dd.createUI();
        
    }

        @Override
        public void actionPerformed(ActionEvent e) {
                b = (JButton)e.getSource();  
                getOperation();
        }
        public void getOperation(){             
                
//            while(true){
                
                try
                {
                    
                    Statement queryCaller = null;
                    
                    try {
                        queryCaller = con.createStatement();
                    } catch (SQLException e) {
                        System.err.println("Create statement failed. " + e.getMessage());
                        System.exit(1);
                    }
                    
            ResultSet rs = queryCaller.executeQuery("Select * From sort_titles_genre");  
            rs.first();
//                        for(int i = 0; i < 30; i++)
//            {                      
////                            System.out.println(rs.getString("title") + " " + rs.getString("genre"));
//                        	custTest.movieTextArea.append(rs.getString("genre")+ "			" + (rs.getString("title")));
//                        	custTest.movieTextArea.append(System.lineSeparator());
//                                rs.next();
//                                
//            }
                        
//                        JOptionPane.showMessageDialog(null, "Retrieved data succesfully.","Record Retrieved",
//                                        JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception ex)
                {
                        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                                        JOptionPane.ERROR_MESSAGE);
                }     
                
//            }
                  
        }    
}


