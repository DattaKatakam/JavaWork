package de.buw.se4de;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

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

public class NewStudentReg extends JFrame {

	private JPanel contentPane;
	private JTextField Snam;
	private JTextField FaNam;
	private JTextField Mnum;
	private JTextField StdPrg;
	private JTextField Pword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentReg frame = new NewStudentReg();
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
	public NewStudentReg() {
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
		lblStudentName.setBounds(57, 55, 86, 14);
		contentPane.add(lblStudentName);
		
		JLabel lblNewLabel = new JLabel("Father Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(57, 90, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Metriculation No.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(57, 125, 105, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Register Form");
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(165, 11, 181, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Study Program");
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
		Back.setBounds(10, 224, 89, 23);
		contentPane.add(Back);
		
		JButton Save = new JButton("Save");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String studentName = Snam.getText();
				String fatherName = FaNam.getText();
				String MarNum = Mnum.getText();
				String StudyProgram = StdPrg.getText();
				String password = Pword.getText();
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into registerstudent values ('"+studentName+"', '"+fatherName+"','"+MarNum+"', '"+StudyProgram+"','"+password+"')");
					JOptionPane.showMessageDialog(null,"Successfully updated");
					setVisible(false);
					new NewStudentReg().setVisible(true);
					
				}
				
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Student already exists");
					setVisible(false);
					new NewStudentReg().setVisible(true);
				}
			}
		});
		Save.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Save.setBounds(401, 224, 89, 23);
		contentPane.add(Save);
		
		Snam = new JTextField();
		Snam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Snam.setBounds(200, 52, 243, 20);
		contentPane.add(Snam);
		Snam.setColumns(10);
		
		FaNam = new JTextField();
		FaNam.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		FaNam.setBounds(200, 87, 243, 20);
		contentPane.add(FaNam);
		FaNam.setColumns(10);
		
		Mnum = new JTextField();
		Mnum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Mnum.setBounds(200, 122, 243, 20);
		contentPane.add(Mnum);
		Mnum.setColumns(10);
		
		StdPrg = new JTextField();
		StdPrg.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		StdPrg.setBounds(200, 157, 243, 20);
		contentPane.add(StdPrg);
		StdPrg.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(57, 192, 105, 14);
		contentPane.add(lblNewLabel_1_1);
		
		Pword = new JTextField();
		Pword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Pword.setColumns(10);
		Pword.setBounds(200, 192, 243, 20);
		contentPane.add(Pword);
	}
}
