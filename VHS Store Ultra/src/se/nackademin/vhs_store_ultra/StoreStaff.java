package se.nackademin.vhs_store_ultra;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class StoreStaff extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
	JTextArea movieTextArea = new JTextArea();
	JButton moviesButton = new JButton("Delete customer");
	Database db1 = new Database();



	public StoreStaff() {
		super("Store Staff");
		setResizable(false);
		setSize(444, 339);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		

		moviesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//db1.getAllMovies();
				
				//movieTextArea.append(db1.getAllMovies());
			}
		});
		moviesButton.setBounds(10, 61, 134, 23);
		getContentPane().add(moviesButton);
		movieTextArea.setWrapStyleWord(true);
		movieTextArea.setLineWrap(true);
		
		movieTextArea.setBounds(154, 11, 264, 278);
		getContentPane().add(movieTextArea);
		
		JButton btnCreateCustomer = new JButton("Create customer");
		btnCreateCustomer.setBounds(10, 12, 134, 23);
		getContentPane().add(btnCreateCustomer);
		
		JButton btnUpdateCustomer = new JButton("Update customer");
		btnUpdateCustomer.setBounds(10, 111, 134, 23);
		getContentPane().add(btnUpdateCustomer);
		
		JButton btnTopMovies = new JButton("Top 10 Movies");
		btnTopMovies.setBounds(10, 154, 134, 23);
		getContentPane().add(btnTopMovies);
		
		JButton btnInStore = new JButton("In store");
		btnInStore.setBounds(10, 195, 134, 23);
		getContentPane().add(btnInStore);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setBounds(10, 229, 134, 23);
		getContentPane().add(btnOrders);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UserGUI uGui = new UserGUI();
				dispose();
				uGui.initialize();
			}
		});
		btnLogOut.setBounds(10, 266, 134, 23);
		getContentPane().add(btnLogOut);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

//