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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 297);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStudentName.setBounds(57, 40, 86, 14);
		contentPane.add(lblStudentName);
		
		
		JLabel lblMatNum = new JLabel("Matriculation No.");
		lblMatNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMatNum.setBounds(57, 70, 86, 14);
		contentPane.add(lblMatNum);
		
		JLabel lblStudyProgram = new JLabel("Study Program");
		lblStudyProgram.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStudyProgram.setBounds(57, 95, 105, 14);
		contentPane.add(lblStudyProgram);
		
		JLabel lblNewPassword = new JLabel("NewPassword");
		lblNewPassword.setFont(new Font("Times New Roman", Font.PLAIN | Font.ITALIC, 14));
		lblNewPassword.setBounds(57, 120, 123, 29);
		contentPane.add(lblNewPassword);
		
		JLabel lblReEnterPassword = new JLabel("Re-enter Password");
		lblReEnterPassword.setFont(new Font("Times New Roman", Font.PLAIN | Font.ITALIC, 14));
		lblReEnterPassword.setBounds(57, 145, 123, 24);
		contentPane.add(lblReEnterPassword);
		
		
		
		Snam = new JTextField();
		Snam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Snam.setBounds(200, 40, 243, 20);
		contentPane.add(Snam);
		Snam.setColumns(10);
		
		MatNum = new JTextField();
		MatNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		MatNum.setBounds(200, 70, 243, 20);
		contentPane.add(MatNum);
		MatNum.setColumns(10);
		
		
		StdPrg = new JTextField();
		StdPrg.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		StdPrg.setBounds(200, 95, 243, 20);
		contentPane.add(StdPrg);
		StdPrg.setColumns(10);
		
		
		
		
		PasswordNew = new JTextField();
		PasswordNew.setBounds(200, 120, 243, 20);
		contentPane.add(PasswordNew);
		PasswordNew.setColumns(10);
		
		PasswordReEnter = new JTextField();
		PasswordReEnter.setBounds(200, 145, 243, 20);
		contentPane.add(PasswordReEnter);
		PasswordReEnter.setColumns(10);
		
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String StudentName=Snam.getText();
				String StudentProgram=StdPrg.getText();
				String MatriculationNum=MatNum.getText();
				String NewPass=PasswordNew.getText();
				String PassReEnter=PasswordReEnter.getText();
				
				if(NewPass==PassReEnter) {
					
					try {
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("update registerstudents set Password ='"+NewPass+"' where StudentName=='"+StudentName+"' and StudentProgram =='"+StudentProgram+"' and MatriculationNum=='"+MatriculationNum+"')");
						
						
						JOptionPane.showMessageDialog(null,"Password was Successfully updated");
						contentPane.setVisible(false);
						dispose();
					}catch(Exception exp) {
						
						JOptionPane.showMessageDialog(null,"Sorry something went wrong!! Please try again");
						contentPane.setVisible(false);
						dispose();
						
						ForgotPassword fp=new ForgotPassword();
						fp.setVisible(true);
						
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"Password is mismatched.. Please try again!!!!!!!!");
					contentPane.setVisible(false);
					dispose();
					StudentLogin sl=new StudentLogin();
					sl.setVisible(true);
				}
				
				
			}
		});
		btnNext.setBackground(new Color(204, 255, 204));
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNext.setBounds(350, 194, 85, 21);
		contentPane.add(btnNext);
		
	}
}
