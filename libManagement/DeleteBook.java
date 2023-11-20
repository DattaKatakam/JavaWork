package de.buw.se4de;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;


import de.buw.se4de.ConnectionProvider;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//implemented by Group 25
public class DeleteBook extends JFrame {

	private JPanel contentPane;
	private JTextField BId;
	private JTextField name;
	private JTextField Athor;
	private JTextField Unit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBookID.setBounds(57, 55, 86, 14);
		contentPane.add(lblBookID);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBookName.setBounds(57, 90, 86, 14);
		contentPane.add(lblBookName);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAuthor.setBounds(57, 125, 105, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblDeleteBook = new JLabel("Book Management");
		lblDeleteBook.setForeground(new Color(0, 0, 139));
		lblDeleteBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteBook.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDeleteBook.setBounds(165, 11, 181, 14);
		contentPane.add(lblDeleteBook);
		
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminHomePage().setVisible(true);
			}
			
		});
		Back.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		Back.setBounds(21, 201, 89, 23);
		contentPane.add(Back);
		
		BId = new JTextField();
		BId.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		BId.setBounds(200, 52, 243, 20);
		contentPane.add(BId);
		BId.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		name.setBounds(200, 87, 243, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		Athor = new JTextField();
		Athor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Athor.setBounds(200, 122, 243, 20);
		contentPane.add(Athor);
		Athor.setColumns(10);
		
		
		JButton delete = new JButton("Delete");
		delete.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BookId = BId.getText();
				String Author=Athor.getText();
				String BookName = name.getText();
			
			try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				st.executeUpdate("Delete from  Addbook WHERE BookId = '"+BookId+"' and Author='"+Author+"' and BookName = '"+BookName+"' ");
			
				JOptionPane.showMessageDialog(null,"Successfully deleted");
				
				new DeleteBook().setVisible(true);}
				
			catch (Exception a) 
			{
				JOptionPane.showMessageDialog(null, "Something went wrong please check details correctly....");
			
				new DeleteBook().setVisible(true);
			
			}
			}
			});
		delete.setBounds(216, 201, 89, 23);
		contentPane.add(delete);
	}
}
