package se.nackademin.vhs_store_ultra;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
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
	private JButton logButton;

	File documentFile;




	/** Create the application. */
	public UserGUI() {
		Music audio4life = new Music ();
		Thread musicThread = new Thread(audio4life);
		musicThread.start();
	}
	
	

	/** Initialize the contents of the frame. */
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

		// /////////////////////////////////////////////////////////////////
		logButton = new JButton("Log in");
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

		JButton ansökButton = new JButton("Ansök");
		ansökButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.lineSeparator();
				
				FileWriter pw;
				try {
					documentFile = new File("mail_list.txt");
					pw = new FileWriter("mail_list.txt", false);
					mailTxtField.write(pw);
					// txtMailField.append(System.lineSeparator());

					// txtMailField.write("\n");

					System.out.println("\n" + mailTxtField);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		ansökButton.setBounds(125, 262, 89, 23);
		frame.getContentPane().add(ansökButton);

		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String puname = userTxtField.getText();
				String ppaswd = passField.getText();
				if (puname.equals("123") && ppaswd.equals("123")) {
					Customer cust = new Customer();
					frame.dispose();
					
				} else if (puname.equals("456") && ppaswd.equals("456")) {
					StoreStaff sStaff = new StoreStaff();
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
//	
//	private void playMusic() {
//		try {
//			File f = new File("Audio/EscapeFromNewYork.wav");
//			AudioInputStream audio = AudioSystem.getAudioInputStream(f);
//			AudioFormat format;
//			format = audio.getFormat();
//			SourceDataLine auline;
//			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
//			auline = (SourceDataLine) AudioSystem.getLine(info);
//			auline.open(format);
//			auline.start();
//			int nBytesRead = 0;
//			byte[] abData = new byte[524288];
//			while (nBytesRead != -1) {
//				nBytesRead = audio.read(abData, 0, abData.length);
//				if (nBytesRead >= 0) {
//					auline.write(abData, 0, nBytesRead);
//				}
//			}
//		} catch (Exception E) {
//			System.out.println(E.getMessage());
//		}
//	}

}
