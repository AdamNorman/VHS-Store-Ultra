package se.nackademin.vhs_store_ultra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StoreStaff extends JFrame {
	
	//Auto-generated sUID
	private static final long serialVersionUID = 1L;
	private JPanel staffPanel;
	private JButton clickBtn;
	
	public static void main(String[] args) {
		new StoreStaff();
	}
	
	public StoreStaff() {
		super("Welcome to staffs site");
		setSize(300, 200);
		setLocation(500, 280);
		getContentPane().setLayout(null);
		staffPanel = new JPanel();
		staffPanel.setBounds(0, 0, 284, 161);
		staffPanel.setLayout(null);
		getContentPane().add(staffPanel);
		
		clickBtn = new JButton("Click me!");
		clickBtn.setBounds(88, 100, 89, 23);
		staffPanel.add(clickBtn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
