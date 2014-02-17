package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.awt.TextArea;

public class GUI_Customer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	Database db1 = new Database();
	String infoOnComponent = "";
	private JTextField txtSearchMovie;
	TextArea movieScrollArea = new TextArea();

	
	public GUI_Customer() {
		super("Customer");
		setResizable(false);
		setSize(600, 339);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		
		setLocationRelativeTo(null);

		
		db1.init();
		
		//Action when "Show movies" button is pressed
		JButton moviesButton = new JButton("Show movies");
		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db1.getAllMovies();
				movieScrollArea.setText(db1.movieData.toString());
			}
		});
		moviesButton.setBounds(10, 12, 134, 23);
		getContentPane().add(moviesButton);
		
		txtSearchMovie = new JTextField();
		txtSearchMovie.setText("Search titles...");
		txtSearchMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSearchMovie.setText("");
			}
		});
		txtSearchMovie.setBounds(10, 60, 108, 23);
		getContentPane().add(txtSearchMovie);
		txtSearchMovie.setColumns(10);
		JButton btnSearch = new JButton("Go!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db1.search(txtSearchMovie.getText());
				movieScrollArea.setText(db1.movieData.toString());
			}
		});
		btnSearch.setBounds(119, 59, 73, 23);
		getContentPane().add(btnSearch);
		
		
		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(10, 107, 134, 23);
		getContentPane().add(btnRent);
		
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GUI_User ug1 = new GUI_User();
				ug1.initialize();
			}
		});
		btnLogOut.setBounds(10, 266, 134, 23);
		getContentPane().add(btnLogOut);
		
		movieScrollArea.setBounds(202, 12, 380, 277);
		getContentPane().add(movieScrollArea);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
