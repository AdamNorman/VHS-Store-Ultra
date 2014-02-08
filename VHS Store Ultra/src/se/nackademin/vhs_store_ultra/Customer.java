package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Customer extends JFrame {
	
	//Auto-generated sUID
	private static final long serialVersionUID = 1L;
	private JPanel custPanel;
	private JButton testBtn;
	
	public static void main(String[] args) {
		new Customer();
	}
	
	public Customer() {
		super("Welcome to customers site");
		setSize(300, 200);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		custPanel = new JPanel();
		custPanel.setBounds(0, 0, 284, 161);
		custPanel.setLayout(null);
		getContentPane().add(custPanel);
		
		testBtn = new JButton("Test me!");
		testBtn.setBounds(88, 100, 89, 23);
		custPanel.add(testBtn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
