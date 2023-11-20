package de.buw.se4de;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;


//import de.buw.se4de.ConnectionProvider;

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

public class AddBook extends JFrame {

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
		
		JLabel lblStudentName = new JLabel("Book ID");
		lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStudentName.setBounds(57, 55, 86, 14);
		contentPane.add(lblStudentName);
		
		JLabel lblNewLabel = new JLabel("Book Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(57, 90, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Author");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(57, 125, 105, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Management");
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(165, 11, 181, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Available Units");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(57, 160, 86, 14);
		contentPane.add(lblNewLabel_3);
		
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
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String BookId = BId.getText();
				String BookName = name.getText();
				String Author = Athor.getText();
				String Units = Unit.getText();
			
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into  AddBook values ('"+BookId+"', '"+BookName+"','"+Author+"', '"+Units+"')");
					JOptionPane.showMessageDialog(null,"Successfully updated");
					
					new AddBook().setVisible(true);
					
				}
				
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter valid Book Id");
					
					new AddBook().setVisible(true);
				}
			}
		});
		Save.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Save.setBounds(379, 201, 89, 23);
		contentPane.add(Save);
		
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
		
		Unit = new JTextField();
		Unit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Unit.setBounds(200, 157, 243, 20);
		contentPane.add(Unit);
		Unit.setColumns(10);
		
		JButton delete = new JButton("Delete");
		delete.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String BookId = BId.getText();
			
			try {
				Connection con = ConnectionProvider.getCon();
				Statement st = con.createStatement();
				st.executeUpdate("Delete from  Addbook WHERE BookId = '"+BookId+"'");
			
				JOptionPane.showMessageDialog(null,"Successfully deleted");
				
				new AddBook().setVisible(true);}
				
			catch (Exception a) 
			{
				JOptionPane.showMessageDialog(null, "Please enter valid Book Id");
			
				new AddBook().setVisible(true);
			
			}
			}
			});
		delete.setBounds(216, 201, 89, 23);
		contentPane.add(delete);
	}
}
