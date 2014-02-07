package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreStaff extends JFrame {
	
	//Auto-generated sUID
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		new StoreStaff();
	}

	JPanel panel = new JPanel();

	public StoreStaff() {
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
