package de.buw.se4de;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdminHomePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
    DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage();
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
	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Return Book");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		/*btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminReturnBook a = new AdminReturnBook();
				a.setVisible(true);
			}
		});*/
		btnNewButton_1.setBounds(10, 173, 149, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Admin Library Management Page");
		lblNewLabel.setBackground(new Color(124, 252, 0));
		lblNewLabel.setBounds(0, 11, 370, 26);
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton Addst = new JButton("Register Student ");
		Addst.setBounds(10, 68, 149, 23);
		Addst.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Addst.setForeground(new Color(0, 0, 0));
		Addst.setBackground(Color.LIGHT_GRAY);
		Addst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NewStudentReg().setVisible(true);
				
			}
		});
		contentPane.add(Addst);
		
		JButton AddBook = new JButton("Add Book");
		AddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			new AddBook().setVisible(true);
				
				
				
			}
		});
		AddBook.setBounds(195, 68, 149, 23);
		AddBook.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		AddBook.setForeground(new Color(0, 0, 0));
		AddBook.setBackground(Color.LIGHT_GRAY);
		contentPane.add(AddBook);
		
		// improved by Group 25
		JButton DeleteBook = new JButton("Delete Book");
		DeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				new DeleteBook().setVisible(true);
				
				
				
			}
		});
		DeleteBook.setBounds(195, 173, 149, 23);
		DeleteBook.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		DeleteBook.setForeground(new Color(0, 0, 0));
		DeleteBook.setBackground(Color.LIGHT_GRAY);
		contentPane.add(DeleteBook);
		
		JButton IssBook = new JButton("Issue Book");
		/*IssBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminIssueBook a = new AdminIssueBook();
				a.setVisible(true);
			}
		});*/
		IssBook.setBounds(195, 123, 149, 23);
		IssBook.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		IssBook.setForeground(new Color(0, 0, 0));
		IssBook.setBackground(Color.LIGHT_GRAY);
		contentPane.add(IssBook);
		
		JButton RenewBook = new JButton("Book Catalogue");
		RenewBook.setBounds(10, 123, 149, 23);
		RenewBook.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		RenewBook.setForeground(new Color(0, 0, 0));
		/*RenewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Overview1 a = new Overview1 ();
				a.setVisible(true);
				}
		});*/
		RenewBook.setBackground(Color.LIGHT_GRAY);
		contentPane.add(RenewBook);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.setBounds(128, 213, 89, 23);
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin().setVisible(true);
			}
		});
		LogOut.setForeground(new Color(0, 0, 0));
		LogOut.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		LogOut.setBackground(Color.LIGHT_GRAY);
		contentPane.add(LogOut);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\pexels-photo-1290141.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 370, 236);
		contentPane.add(lblNewLabel_1);
	}
}
