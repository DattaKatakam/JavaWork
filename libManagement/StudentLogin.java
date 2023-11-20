package de.buw.se4de;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane; 


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;

public class StudentLogin extends JFrame{
	
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startPage frame = new startPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	 
	 public StudentLogin{
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Login Page");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(245, 222, 179));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 281, 31);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 93, 53, 23);
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		user.setBounds(6, 113, 246, 31);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(12, 155, 63, 23);
		contentPane.add(lblNewLabel_2);
		 
		password = new JPasswordField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		password.setBounds(6, 178, 246, 31);
		contentPane.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uN = user.getText();
				String pass = password.getText(); 
				
			
				if (uN.contains("student")&&pass.contains("student@123"))
				{
					dispose();
					
					StudentHomePage shp = new StudentHomePage();
				
					shp.setVisible(true);
				
				}
				else
				{
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect User name or Password");
					new StudentLogin().setVisible(true);
				}
			}
		});
		
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Times New Roman", Font.BOLD, 14));
		login.setBackground(new Color(25, 25, 112));
		login.setBounds(6, 231, 246, 31);
		contentPane.add(login);

		//group 25 improvement forgot password class
		JButton forgotPassword = new JButton("Forgot Password?");
		forgotPassword.addActionListener(new ActionListener()){
			
			public void actionPerformed(ActionEvent e){
				
				contentPane.setVisible(false);
				ForgotPassword fp = new ForgotPassword();
				fp.setVisible(true);
				
			}
			
		});
		
		forgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		forgotPassword.setBounds(106, 281, 136, 21);
		contentPane.add(forgotPassword);
		
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new startPage().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(6, 279, 59, 23);
		contentPane.add(btnNewButton);
		 
		 
		 
	 }
	
	
	
	
	
}	