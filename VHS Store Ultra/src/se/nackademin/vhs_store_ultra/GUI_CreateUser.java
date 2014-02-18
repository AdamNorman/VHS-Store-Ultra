package se.nackademin.vhs_store_ultra;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class GUI_CreateUser extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JLabel l1, lPerson_id, lName, lPostal, lCity, lPhone;
    JTextField tfName, tfPerson_id, tfPostal, tfCity, tfPhone;
    JButton btn1, btn2;
    private Connection con = null;
    private JButton btnExit;
    
    public GUI_CreateUser() {
        setResizable(false);
        setSize(575, 375);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Registration Form | VHS Store Ultra");
		setLocationRelativeTo(null);
		
        l1 = new JLabel("Registration Form for VHS Store Ultra:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        
        lName = new JLabel("Name:");
        lPerson_id = new JLabel("Person ID (10 digits):");
        lPostal = new JLabel("Postal Code:");
        lCity = new JLabel("City:");
        lPhone = new JLabel("Phone No:");
        tfName = new JTextField();
        tfPerson_id = new JTextField();
        tfPerson_id.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (rootPaneCheckingEnabled) {
					//yadda yadda
				}
        		
        		JOptionPane.showMessageDialog(null, "Person ID cannot exceed 10 digits!");
        	}
        });
        tfPostal = new JTextField();
        tfCity = new JTextField();
        tfPhone = new JTextField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");

        btn1.addActionListener(this);
        btn2.addActionListener(this);

        l1.setBounds(100, 30, 400, 30);
        lName.setBounds(80, 70, 200, 30);
        lPerson_id.setBounds(80, 110, 200, 30);
        lPostal.setBounds(80, 151, 200, 30);
        lCity.setBounds(80, 191, 200, 30);
        lPhone.setBounds(80, 231, 200, 30);
        tfName.setBounds(300, 70, 200, 30);
        tfPerson_id.setBounds(300, 110, 200, 30);
        tfPostal.setBounds(300, 151, 200, 30);
        tfCity.setBounds(300, 191, 200, 30);
        tfPhone.setBounds(300, 231, 200, 30);
        btn1.setBounds(60, 272, 100, 30);
        btn2.setBounds(180, 272, 100, 30);

        getContentPane().add(l1);
        getContentPane().add(lName);
        getContentPane().add(tfName);
        getContentPane().add(lPerson_id);
        getContentPane().add(tfPerson_id);
        getContentPane().add(lPostal);
        getContentPane().add(tfPostal);
        getContentPane().add(lCity);
        getContentPane().add(tfCity);
        getContentPane().add(lPhone);
        getContentPane().add(tfPhone);
        getContentPane().add(btn1);
        getContentPane().add(btn2);
        
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        	}
        });
        btnExit.setBounds(400, 272, 100, 30);
        getContentPane().add(btnExit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            int x = 0;
            String s1 = tfName.getText();
            String s2 = tfPerson_id.getText();
            String s3 = tfPostal.getText();
            String s4 = tfCity.getText();
            String s5 = tfPhone.getText();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/vhs_store_ultra","root","");
                PreparedStatement ps = con.prepareStatement("Insert into customer(`name`,`personid`, `postal_code`, `city`, `phonenumber`) values(?,?,?,?,?)");
                ps.setString(1, s1);
                ps.setString(2, s2);
                ps.setString(3, s3);
                ps.setString(4, s4);
                ps.setString(5, s5);
                ps.executeUpdate();
                x++;
            } catch (Exception ex) {
                System.err.println("SQL Query failed " + ex.getMessage());
            }
            if (x > 0) {
                JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
            }
        } else {
            tfName.setText("");
            tfPerson_id.setText("");
            tfPostal.setText("");
            tfCity.setText("");
            tfPhone.setText("");
        }
    }

}
