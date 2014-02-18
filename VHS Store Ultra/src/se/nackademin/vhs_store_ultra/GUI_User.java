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

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI_User {
	
	private JFrame frame;
	private JTextField userTxtField;
	private JPasswordField passField;
	private JTextField mailTxtField;
	private JButton logButton;
	
	File documentFile;
	
	PropHandling ph = new PropHandling();
	
	// Initialize the contents of the frame
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 335);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("VHS Store Ultra");
		frame.setResizable(false);

		userTxtField = new JTextField();
		userTxtField.setColumns(10);
		userTxtField.setBounds(380, 212, 89, 20);
		frame.getContentPane().add(userTxtField);

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

		passField = new JPasswordField();
		passField.setBounds(380, 236, 89, 20);
		frame.getContentPane().add(passField);

		JTextArea txtrMedlem = new JTextArea();
		txtrMedlem.setText("Inte medlem?");
		txtrMedlem.setEditable(false);
		txtrMedlem.setBackground(SystemColor.menu);
		txtrMedlem.setBounds(10, 236, 106, 22);
		frame.getContentPane().add(txtrMedlem);

		mailTxtField = new JTextField();
		mailTxtField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mailTxtField.setText("");
			}
		});
		mailTxtField.setText("skriv in din mail");
		mailTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		mailTxtField.setColumns(10);
		mailTxtField.setBounds(10, 262, 112, 23);
		frame.getContentPane().add(mailTxtField);

		logButton = new JButton("Log in");
		logButton.setBounds(380, 262, 89, 23);
		frame.getContentPane().add(logButton);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setLocation(69, 11);

		ImageIcon icon = new ImageIcon("img/vhs_logo.png");
		lblNewLabel.setIcon(icon);

		lblNewLabel.setSize(326, 179);
		frame.getContentPane().add(lblNewLabel);
		
		   JButton ansökButton = new JButton("Ansök");
			ansökButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					BufferedWriter bufferedWriter = null;
					   
					  try {
					 
					   
					   //to append more data to the existing file change the line to
					   //FileWriter pw = new FileWriter("mail_list.txt",true);
					   FileWriter pw = new FileWriter("mail_list.txt", true);
					  
					         documentFile = new File("mail_list.txt");
					         bufferedWriter = new BufferedWriter(pw);
					         mailTxtField.write(pw);
					         bufferedWriter.newLine();
					     
					  } catch (IOException e3) {
					   e3.printStackTrace();
					  } finally {
					   try {
					    if (bufferedWriter != null){
					     bufferedWriter.close();
					    }
					   } catch (IOException ex) {
					    ex.printStackTrace();
					   }
					  }
			}
		});
		ansökButton.setBounds(125, 262, 89, 23);
		frame.getContentPane().add(ansökButton);

		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String puname = userTxtField.getText();
				String ppaswd = passField.getText();
				ph.readProperties("config_properties.txt");

				if (puname.equals("123") && ppaswd.equals(ph.getProperty("custPass"))) {
					new GUI_Customer();
					frame.dispose();
					
				} else if (puname.equals("456") && ppaswd.equals(ph.getProperty("staffPass"))) {
					new GUI_StoreStaff();
					frame.dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					mailTxtField.setText("");
					passField.setText("");
					mailTxtField.requestFocus();
				}
			}
		});
		frame.setVisible(true);
	}
	
}
