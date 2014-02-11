package se.nackademin.vhs_store_ultra;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame User_frame;


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







	public Customer() {
		super("Customer");
		setResizable(false);
		setSize(482, 339);
		setLocation(500, 280);
		getContentPane().setLayout(null);

		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//db1.getAllMovies();

				// movieTextArea.append(db1.getAllMovies());
			}
		});
		moviesButton.setBounds(10, 12, 134, 23);
		getContentPane().add(moviesButton);
		movieTextArea.setWrapStyleWord(true);
		movieTextArea.setLineWrap(true);

		movieTextArea.setBounds(202, 21, 264, 167);
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
				if(e.getSource() == goButton){
				//if((genreBox.getItemAt(1) == goButton)){

					
					//movieTextArea.append("Här står det skit");
					//System.out.println("här står dt");
					
						movieTextArea.append(genreBox.getItemAt(1) 
								+ ":\n"
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
					/*
					movieTextArea.append(infoOnComponent = genreBox.getItemAt(1) 
							+ ":\n"
							+ "Independece Day\n"
							+ "De 12 Apornas Armé\n"
							+ "Något annat\n");
					movieTextArea.append(infoOnComponent = genreBox.getItemAt(2) 
							+ ":\n"
							+ "Comedy\n"
							+ "Comedy 2"
							+ "Något annat\n");
					//Koppling till databas-query
					 * 
					 * 
					 */
			//}
			
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
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(202, 212, 264, 77);
		getContentPane().add(textArea);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}