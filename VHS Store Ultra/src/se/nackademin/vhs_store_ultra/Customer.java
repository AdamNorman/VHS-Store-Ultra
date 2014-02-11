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

	public Customer() {
		super("Customer");
		setResizable(false);
		setSize(444, 339);
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

		movieTextArea.setBounds(154, 11, 264, 278);
		getContentPane().add(movieTextArea);

		JButton btnSortByGenre = new JButton("Sort by genre");
		btnSortByGenre.setBounds(10, 61, 134, 23);
		getContentPane().add(btnSortByGenre);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 106, 134, 23);
		getContentPane().add(btnSearch);

		JButton btnOrderHistory = new JButton("Order history");
		btnOrderHistory.setBounds(10, 189, 134, 23);
		getContentPane().add(btnOrderHistory);

		JButton btnRent = new JButton("Rent");
		btnRent.setBounds(10, 140, 134, 23);
		getContentPane().add(btnRent);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UserGUI regFace = new UserGUI();
				//regFace.setVisible(true);
				// regFace.initialize();
				// User_frame.dispose();
				dispose();

			}
		});
		btnLogOut.setBounds(10, 266, 134, 23);
		getContentPane().add(btnLogOut);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}