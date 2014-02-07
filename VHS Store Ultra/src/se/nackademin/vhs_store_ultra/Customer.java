package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame {

	public static void main(String[] args) {
		new Customer();
	}

	JPanel panel = new JPanel();

	public Customer() {
		super("Welcome");
		setSize(300, 200);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 284, 161);
		panel.setLayout(null);

		getContentPane().add(panel);

		JButton btnNewButton = new JButton("Klick!");
		btnNewButton.setBounds(88, 100, 89, 23);
		panel.add(btnNewButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
