package se.nackademin.vhs_store_ultra;

import javax.naming.InitialContext;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;

import javax.swing.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame User_frame;
	Database Movies = new Database();
    private Connection conn = null;




	public static void main(String[] args) {
		new Customer();
	}

	JTextArea movieTextArea = new JTextArea();
	JButton moviesButton = new JButton("Show movies");
	Database db1 = new Database();
	JComboBox genreBox = new JComboBox();
	JButton goButton = new JButton("Go!");
	String infoOnComponent = "";
	String[] shows = {"Select genre", "Action", "Comedy", "Drama", "Sci-fi"};
	private JTextField txtSearchMovie;
	private Scanner input = null;
    //private Connection con = null;

	public Customer() {
		super("Customer");
		setResizable(false);
		setSize(482, 339);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				movieTextArea.append(Movies.getAllMovies());
				
				
				
//				
//				movieTextArea.append(rs.getString("genre")+ "			" + (rs.getString("title")));
//	                        	movieTextArea.append(System.lineSeparator());
//
//

				
			}});
		
		
		
		
		
		
		moviesButton.setBounds(10, 12, 134, 23);
		getContentPane().add(moviesButton);
		movieTextArea.setWrapStyleWord(true);
		movieTextArea.setLineWrap(true);

		movieTextArea.setBounds(202, 21, 264, 268);
		getContentPane().add(movieTextArea);

		JButton btnSearch = new JButton("Search?");
		btnSearch.setBounds(10, 134, 134, 23);
		getContentPane().add(btnSearch);

		JButton btnOrderHistory = new JButton("Order history");
		btnOrderHistory.setBounds(10, 202, 134, 23);
		getContentPane().add(btnOrderHistory);

		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(10, 168, 134, 23);
		getContentPane().add(btnRent);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UserGUI regFace = new UserGUI();

				dispose();

			}
		});
		btnLogOut.setBounds(10, 266, 134, 23);
		getContentPane().add(btnLogOut);
		


		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(e.getSource() == goButton){
				if((genreBox.getItemAt(1) == goButton)){

					
					//movieTextArea.append("Här står det skit");
					//System.out.println("här står dt");
					
						//movieTextArea.append((infoOnComponent = genreBox.getItemAt(1)
								movieTextArea.append(

								 ":\n"
								+ "Independece Day\n"
								+ "De 12 Apornas Armé\n"
								+ "Något annat\n");
						
					} else {
						movieTextArea.append(infoOnComponent = genreBox.getItemAt(2) 
								+ ":\n"
								+ "Comedy\n"
								+ "Comedy 2"
								+ "Något annat\n");
					}
			
			}});

		
		genreBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//65476765767
			}
			});
		
		
		genreBox.setModel(new DefaultComboBoxModel(shows));
		genreBox.setBounds(10, 53, 106, 20);
		getContentPane().add(genreBox);
		
		goButton.setBounds(126, 52, 66, 23);
		getContentPane().add(goButton);
		
		txtSearchMovie = new JTextField();
		txtSearchMovie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
               
//				
//
//				String user = input.nextLine();
//
//				
//				if (e.getKeyCode() == KeyEvent.VK_ENTER){
//		            	System.out.println(user);
//		            }      		    
//				
				///////////////////////////////////////////////////////////////////////////////////
				
			}
		});
		txtSearchMovie.setText("Search movie!");
		txtSearchMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSearchMovie.setText("");

			}
		});
		txtSearchMovie.setBounds(10, 103, 134, 20);
		getContentPane().add(txtSearchMovie);
		txtSearchMovie.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}