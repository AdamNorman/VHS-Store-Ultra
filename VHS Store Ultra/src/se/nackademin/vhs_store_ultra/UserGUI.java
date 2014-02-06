package se.nackademin.vhs_store_ultra;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserGUI {

	private JFrame frame;
	private JTextField textF_userN;
	private JPasswordField passwordField;
	private JTextField textF_Name;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI window = new UserGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textF_userN = new JTextField();
		textF_userN.setColumns(10);
		textF_userN.setBounds(335, 177, 89, 20);
		frame.getContentPane().add(textF_userN);
		
		JTextArea txtrAnvndarnam = new JTextArea();
		txtrAnvndarnam.setText("Anv\u00E4ndarnamn:");
		txtrAnvndarnam.setEditable(false);
		txtrAnvndarnam.setBackground(SystemColor.menu);
		txtrAnvndarnam.setBounds(221, 179, 108, 22);
		frame.getContentPane().add(txtrAnvndarnam);
		
		JTextArea txtrLsenord = new JTextArea();
		txtrLsenord.setText("L\u00F6senord:");
		txtrLsenord.setEditable(false);
		txtrLsenord.setBackground(SystemColor.menu);
		txtrLsenord.setBounds(253, 200, 76, 22);
		frame.getContentPane().add(txtrLsenord);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("VHS Store Ultra");
		textArea_2.setFont(new Font("GulimChe", Font.PLAIN, 35));
		textArea_2.setEditable(false);
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(10, 11, 279, 38);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("- retroer than Retro");
		textArea_3.setFont(new Font("GulimChe", Font.ITALIC, 20));
		textArea_3.setEditable(false);
		textArea_3.setBackground(SystemColor.menu);
		textArea_3.setBounds(75, 51, 214, 28);
		frame.getContentPane().add(textArea_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(335, 201, 89, 20);
		frame.getContentPane().add(passwordField);
		
		JTextArea txtrMedlem = new JTextArea();
		txtrMedlem.setText("Inte medlem?");
		txtrMedlem.setEditable(false);
		txtrMedlem.setBackground(SystemColor.menu);
		txtrMedlem.setBounds(10, 201, 106, 22);
		frame.getContentPane().add(txtrMedlem);
		
		textF_Name = new JTextField();
		textF_Name.setText("skriv in din mail");
		textF_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textF_Name.setColumns(10);
		textF_Name.setBounds(10, 227, 112, 23);
		frame.getContentPane().add(textF_Name);
		
		JButton ansökButton = new JButton("Ans\u00F6k");
		ansökButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				
				//Ansök BUTTTONONONONONONONONNOONN!!!!!!!!!!!!!!!!!!!
				FileWriter pw;
				try {
					documentFile = new File("default.txt");
					pw = new FileWriter ("default.txt", false);
					textArea.write(pw);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				*/
			}
		});
		ansökButton.setBounds(125, 227, 89, 23);
		frame.getContentPane().add(ansökButton);
		
		JButton button_1 = new JButton("Logga in");
		button_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(button_1);
	}

}
