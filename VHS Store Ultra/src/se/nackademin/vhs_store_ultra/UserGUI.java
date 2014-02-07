package se.nackademin.vhs_store_ultra;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.security.PublicKey;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserGUI {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField passWField;
	private JTextField txtMailField;
	JButton logButton = new JButton("Logga in");

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
		// actionLogin();

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

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(380, 212, 89, 20);
		frame.getContentPane().add(txtUserName);

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

		passWField = new JPasswordField();
		passWField.setBounds(380, 236, 89, 20);
		frame.getContentPane().add(passWField);

		JTextArea txtrMedlem = new JTextArea();
		txtrMedlem.setText("Inte medlem?");
		txtrMedlem.setEditable(false);
		txtrMedlem.setBackground(SystemColor.menu);
		txtrMedlem.setBounds(10, 236, 106, 22);
		frame.getContentPane().add(txtrMedlem);

		txtMailField = new JTextField();
		txtMailField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtMailField.setText("");

			}
		});
		txtMailField.setText("skriv in din mail");
		txtMailField.setHorizontalAlignment(SwingConstants.CENTER);
		txtMailField.setColumns(10);
		txtMailField.setBounds(10, 262, 112, 23);
		frame.getContentPane().add(txtMailField);

		// /////////////////////////////////////////////////////////////////
		logButton.setBounds(380, 262, 89, 23);
		frame.getContentPane().add(logButton);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setLocation(69, 11);

		// JLabel lblNewLabel = new JLabel();
		// /////////////////////////////////////////////////////////////////

		ImageIcon icon = new ImageIcon("img/vhs_logo.png");
		lblNewLabel.setIcon(icon);

		// lblNewLabel.setBounds(10, 11, 252, 135);
		lblNewLabel.setSize(326, 179);
		frame.getContentPane().add(lblNewLabel);

		JButton ansökButton = new JButton("Ans\u00F6k");
		ansökButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * 
				 * //Ansök BUTTTONONONONONONONONNOONN!!!!!!!!!!!!!!!!!!!
				 * FileWriter pw; try { documentFile = new File("default.txt");
				 * pw = new FileWriter ("default.txt", false);
				 * textArea.write(pw);
				 * 
				 * } catch (IOException e1) { e1.printStackTrace(); }
				 */
			}
		});
		ansökButton.setBounds(125, 262, 89, 23);
		frame.getContentPane().add(ansökButton);

		// public void actionLogin(){
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String puname = txtUserName.getText();
				String ppaswd = passWField.getText();
				if (puname.equals("123") && ppaswd.equals("123")) {
					Customer regFace = new Customer();
					regFace.setVisible(true);
					frame.dispose();
				} else {

					JOptionPane.showMessageDialog(null,
							"Wrong Password / Username");
					txtMailField.setText("");
					passWField.setText("");
					txtMailField.requestFocus();
				}

			}
		});

	}

}

// }

//
