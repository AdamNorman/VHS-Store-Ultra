package se.nackademin.vhs_store_ultra;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserGUI {

	private JFrame frame;
	private JLabel vhsLabel;
	private ImageIcon vhsIcon;
	private JTextField userTxtField;
	private JTextField mailTxtField;
	private JPasswordField passField;
	private JTextArea userTxtArea;
	private JTextArea passTxtArea;
	private JTextArea regTxtArea;
	private JButton signUpBtn;
	private JButton loginBtn;
	
	/** Launch the application. */
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
	
	/** Create the application. */
	public UserGUI() {
		initialize();
	}
	
	/** Initialize the contents of the frame. */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 335);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("VHS Store Ultra");
		frame.setResizable(false);
		
		// VHS image inserted to label and onto frame.
		vhsLabel = new JLabel();
		vhsLabel.setLocation(69, 11);
		vhsIcon = new ImageIcon("img/vhs_logo.png");
		vhsLabel.setIcon(vhsIcon);
		vhsLabel.setSize(326, 179);
		frame.getContentPane().add(vhsLabel);
		
		// Adding text-field and text-area for Username input.
		userTxtField = new JTextField();
		userTxtField.setColumns(10);
		userTxtField.setBounds(380, 212, 89, 20);
		frame.getContentPane().add(userTxtField);
		userTxtArea = new JTextArea();
		userTxtArea.setText("Username:");
		userTxtArea.setEditable(false);
		userTxtArea.setBackground(SystemColor.menu);
		userTxtArea.setBounds(266, 210, 108, 22);
		frame.getContentPane().add(userTxtArea);
		
		// Adding password-field and text-area for Password input.
		passField = new JPasswordField();
		passField.setBounds(380, 236, 89, 20);
		frame.getContentPane().add(passField);
		passTxtArea = new JTextArea();
		passTxtArea.setText("Password:");
		passTxtArea.setEditable(false);
		passTxtArea.setBackground(SystemColor.menu);
		passTxtArea.setBounds(298, 234, 76, 22);
		frame.getContentPane().add(passTxtArea);
		
		// Adding text-area and text-field for e-mail registration.
		regTxtArea = new JTextArea();
		regTxtArea.setText("Not registered?");
		regTxtArea.setEditable(false);
		regTxtArea.setBackground(SystemColor.menu);
		regTxtArea.setBounds(10, 236, 106, 22);
		frame.getContentPane().add(regTxtArea);
		mailTxtField = new JTextField();
		mailTxtField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				mailTxtField.setText("");
			}
		});
		mailTxtField.setText("Enter your e-mail");
		mailTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		mailTxtField.setColumns(10);
		mailTxtField.setBounds(10, 262, 112, 23);
		frame.getContentPane().add(mailTxtField);
		
		// Adding a button for log in and validate user/pass input.
		loginBtn = new JButton("Log In");
		loginBtn.setBounds(380, 262, 89, 23);
		frame.getContentPane().add(loginBtn);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String uName = userTxtField.getText();
				String pWord = passField.getText();
				if (uName.equals("Sebbe") && pWord.equals("123")) {
					new Customer();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
					mailTxtField.setText("");
					passField.setText("");
					mailTxtField.requestFocus();
				}
			}
		});
		
		// Adding a button for unregistered users.
		signUpBtn = new JButton("Sign up");
		signUpBtn.setBounds(125, 262, 89, 23);
		frame.getContentPane().add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Shit happens when button is pressed...
				 * //Ansök BUTTTONONONONONONONONNOONN!!!!!!!!!!!!!!!!!!!
				 * FileWriter pw; try { documentFile = new File("default.txt");
				 * pw = new FileWriter ("default.txt", false);
				 * textArea.write(pw);
				 * 
				 * } catch (IOException e1) { e1.printStackTrace(); }
				 */
			}
		});
		
	}
	
}
