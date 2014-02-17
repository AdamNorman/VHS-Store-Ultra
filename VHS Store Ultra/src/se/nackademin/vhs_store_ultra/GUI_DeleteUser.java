package se.nackademin.vhs_store_ultra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class GUI_DeleteUser extends JFrame implements ActionListener {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1, lName;
    JTextField idField;
    private Connection con = null;
    private JButton submitButton;
    private JButton exitButton;
    Database db = new Database();

    GUI_DeleteUser() {

        setResizable(false);
        setSize(444, 247);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Delete Customer | VHS Store Ultra");
        
		setLocationRelativeTo(null);
		
//		this.dispose();


        l1 = new JLabel("Delete Customer with your Might!");
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        lName = new JLabel("Insert Person ID:");
        lName.setHorizontalAlignment(SwingConstants.RIGHT);
        idField = new JTextField();

        l1.setBounds(28, 44, 400, 30);
        lName.setBounds(-86, 100, 200, 30);
        idField.setBounds(124, 100, 210, 30);


        getContentPane().add(l1);
        getContentPane().add(lName);
        getContentPane().add(idField);
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	db.deleteCust(idField.getText());
        		JOptionPane.showMessageDialog(null, "Customer burns in Hell!");
        		
        		
        	}
        });
        submitButton.setBounds(124, 164, 100, 30);
        getContentPane().add(submitButton);
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		
        		
        	}
        });
        exitButton.setBounds(234, 164, 100, 30);
        getContentPane().add(exitButton);

        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}

