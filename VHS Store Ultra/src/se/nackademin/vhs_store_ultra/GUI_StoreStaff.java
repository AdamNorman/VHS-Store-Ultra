package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_StoreStaff extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Database db1 = new Database();
	TextArea movieScrollArea = new TextArea();
	
	// Konstruktorn skapar det nya GUI:t för en StoreStaff
	public GUI_StoreStaff() {
		super("Store Staff");
		setResizable(false);
		setSize(600, 339);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		db1.staffInit(null);
		
		
        // Action when "deleteButton" button is pressed (delete Users)
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DeleteUser();
			}
		});
		deleteButton.setBounds(105, 33, 93, 23);
		getContentPane().add(deleteButton);
		
		JButton createCustButton = new JButton("Create");
		createCustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_CreateUser();				
			}
		});
		createCustButton.setBounds(105, 11, 93, 23);
		getContentPane().add(createCustButton);
		
		
        // Action when "Top 10 Movies" button is pressed (view Top 10 movies)
		JButton btnTopMovies = new JButton("Top 10 Movies");
		btnTopMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db1.getTopTen();
				movieScrollArea.setText(db1.movieData.toString());
			}
		});
		btnTopMovies.setBounds(10, 154, 134, 23);
		getContentPane().add(btnTopMovies);
		
		JButton btnInStore = new JButton("In store");
		btnInStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db1.inStock();
				movieScrollArea.setText(db1.movieData.toString());
			}
		});
		btnInStore.setBounds(10, 195, 134, 23);
		getContentPane().add(btnInStore);
		
		
        // Action when "Orders" button is pressed (view current orders)
		JButton btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                db1.getOrders();
                movieScrollArea.setText(db1.movieData.toString());
			}
		});
		btnOrders.setBounds(10, 229, 134, 23);
		getContentPane().add(btnOrders);
		
		
        // Action when "Logout" button is pressed (log out to UserGui)
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				db1.cleanUp();
				GUI_User ug1 = new GUI_User();
				dispose();
				ug1.initialize();
			}
		});
		btnLogOut.setBounds(10, 266, 134, 23);
		getContentPane().add(btnLogOut);
		movieScrollArea.setBackground(Color.WHITE);
		movieScrollArea.setEditable(false);
		
		movieScrollArea.setBounds(204, 12, 380, 277);
		getContentPane().add(movieScrollArea);
		
		JButton viewCustButton = new JButton("View");
		viewCustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db1.listAllCust();
				movieScrollArea.setText(db1.movieData.toString());
			}
		});
		viewCustButton.setBounds(105, 55, 93, 23);
		getContentPane().add(viewCustButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JTextArea txtrMedlem = new JTextArea();
		txtrMedlem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrMedlem.setText("Customer:");
		txtrMedlem.setEditable(false);
		txtrMedlem.setBackground(SystemColor.menu);
		txtrMedlem.setBounds(40, 14, 85, 22);
		getContentPane().add(txtrMedlem);
	}
	
}
