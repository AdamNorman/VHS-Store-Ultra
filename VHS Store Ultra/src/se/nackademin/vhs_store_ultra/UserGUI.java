package se.nackademin.vhs_store_ultra;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		frame.setBounds(100, 100, 495, 335);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("VHS Store Ultra");
		frame.setResizable(false);
		
		textF_userN = new JTextField();
		textF_userN.setColumns(10);
		textF_userN.setBounds(380, 212, 89, 20);
		frame.getContentPane().add(textF_userN);
		
		JTextArea txtrAnvndarnam = new JTextArea();
		txtrAnvndarnam.setText("Anv\u00E4ndarnamn:");
		txtrAnvndarnam.setEditable(false);
		txtrAnvndarnam.setBackground(SystemColor.menu);
		txtrAnvndarnam.setBounds(266, 210, 108, 22);
		frame.getContentPane().add(txtrAnvndarnam);
		
		JTextArea txtrLsenord = new JTextArea();
		txtrLsenord.setText("L\u00F6senord:");
		txtrLsenord.setEditable(false);
		txtrLsenord.setBackground(SystemColor.menu);
		txtrLsenord.setBounds(298, 234, 76, 22);
		frame.getContentPane().add(txtrLsenord);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(380, 236, 89, 20);
		frame.getContentPane().add(passwordField);
		
		JTextArea txtrMedlem = new JTextArea();
		txtrMedlem.setText("Inte medlem?");
		txtrMedlem.setEditable(false);
		txtrMedlem.setBackground(SystemColor.menu);
		txtrMedlem.setBounds(10, 236, 106, 22);
		frame.getContentPane().add(txtrMedlem);
		
		textF_Name = new JTextField();
		textF_Name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textF_Name.setText("");

				
			}
		});
		textF_Name.setText("skriv in din mail");
		textF_Name.setHorizontalAlignment(SwingConstants.CENTER);
		textF_Name.setColumns(10);
		textF_Name.setBounds(10, 262, 112, 23);
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
		ansökButton.setBounds(125, 262, 89, 23);
		frame.getContentPane().add(ansökButton);
		
		JButton button_1 = new JButton("Logga in");
		button_1.setBounds(380, 262, 89, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setLocation(69, 11);
		
		//JLabel lblNewLabel = new JLabel();

		
		ImageIcon icon = new ImageIcon("img/vhs_logo.png"); 
		lblNewLabel.setIcon(icon);
		
		//lblNewLabel.setBounds(10, 11, 252, 135);
		lblNewLabel.setSize(326, 179);
		frame.getContentPane().add(lblNewLabel);
	}
}

//
