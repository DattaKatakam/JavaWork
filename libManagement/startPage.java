package de.buw.se4de;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

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
import javax.swing.ImageIcon;

public class startPage extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField password;

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
	public startPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bauhaus Universitat Library Login");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(245, 222, 179));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 586, 31);
		contentPane.add(lblNewLabel);
		
		/*JRadioButton studentButton = new JRadioButton("Student");
		
		studentButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (studentButton.isSelected()==true) 
				{ 
					dispose();
					
					StudentLogin a = new StudentLogin();
					a.setVisible(true);
				}

			}
});

		
		
		studentButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentButton.setBackground(new Color(255, 255, 255));
		studentButton.setBounds(322, 130, 80, 23);
		contentPane.add(studentButton);*/
		
		JRadioButton AdminButton = new JRadioButton("Admin");
		AdminButton.addActionListener(new ActionListener() {
			
					public void actionPerformed(ActionEvent e) {
						if (AdminButton.isSelected()==true) 
						{ 
							dispose();
							
							AdminLogin a = new AdminLogin();
							a.setVisible(true);
						}
					}			
		});
		
		
		AdminButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		AdminButton.setBackground(new Color(255, 255, 255));
		AdminButton.setBounds(459, 130, 70, 23);
		contentPane.add(AdminButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Chaithra\\Downloads\\istockphoto-1129548247-612x612.jpg"));
		lblNewLabel_1.setBounds(0, 0, 600, 350);
		contentPane.add(lblNewLabel_1);
	}
}
		
		
	
	
