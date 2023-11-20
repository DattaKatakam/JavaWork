import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import java.net.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class dash implements ActionListener {

    String Userid;
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("welcome_home_page.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));
	String filePath = "src\\main\\java\\CSV\\DataHealthColect.csv";
	private JTable table;
    DefaultTableModel model;
    private JButton btnNewButton;
	Scanner sc;

    JButton test=new JButton("Take Test");
	JButton logout = new JButton("Logout");
	
    dash(String UserId) throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
		
        test.setBounds(450,700,240,40);
        test.setFocusable(false);
        test.setBackground(Color.gray);
        test.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        test.addActionListener(this);
		
		logout.setBounds(700,50,240,40);
        logout.setFocusable(false);
        logout.setBackground(Color.gray);
        logout.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logout.addActionListener(this);
		
        this.Userid = UserId;

        frame.setLayout(new BorderLayout());
        frame.add(background);
        background.add(test);
		background.add(logout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(120, 100, 800, 500);
		background.add(scrollPane);
		
		table = new JTable();
				
		try {
			
			scrollPane.setViewportView(table);
			model = new DefaultTableModel();
			table.setModel(model);
			model.addColumn("Test no");
			model.addColumn("Fever");
			model.addColumn("Cough");
			model.addColumn("Cold");
			model.addColumn("Headache");
			model.addColumn("BodyAches");
			model.addColumn("BreathingTrouble");
			model.addColumn("Vomiting");
			model.addColumn("Advice");
			
			
			
			try{
				
				sc = new Scanner(new File(filePath));
				sc.useDelimiter("[,\n]");
				String uId; boolean symp1;boolean symp2;boolean symp3;boolean symp4;boolean symp5;boolean symp6;boolean symp7;
				String risk;
				String s1; String s2;String s3;String s4;String s5;String s6;String s7;
				int i=0;
				while(sc.hasNext()){
					//i++;
					uId = sc.next();
					symp1= sc.nextBoolean(); if(symp1==true){s1="Yes";}else {s1="No";}
					symp2= sc.nextBoolean(); if(symp2){s2="Yes";}else {s2="No";}
					symp3= sc.nextBoolean(); if(symp3){s3="Yes";}else {s3="No";}
					symp4= sc.nextBoolean(); if(symp4){s4="Yes";}else {s4="No";}
					symp5= sc.nextBoolean(); if(symp5){s5="Yes";}else {s5="No";}
					symp6= sc.nextBoolean(); if(symp6){s6="Yes";}else {s6="No";}
					symp7= sc.nextBoolean(); if(symp7){s7="Yes";}else {s7="No";}
					risk = sc.next();
					//model.addRow(new Object[]{i,s1,s2,s3,s4,s5,s6,s7});
					
					if(Userid.equals(uId)){
						System.out.println(uId);
						i++;
						//Object[] r =;
						model.addRow(new Object[]{i,s1,s2,s3,s4,s5,s6,s7,risk});
						
					}
					
				}//table.setModel(model);
				
				
			}catch(Exception c){c.printStackTrace();}
			
			
			
		}
		catch(Exception b) {
			b.printStackTrace();
			
		}
		
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,Height);
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
		
		System.out.println("In DashBoard");

    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == test) {
            
			frame.setVisible(false);
            frame.dispose();
			
			System.out.println("IN test");
			try{
			User_Welcome_Page page = new User_Welcome_Page(Userid);
			} catch(Exception ex){ ex.printStackTrace();}


        }
		
		if(e.getSource() == logout){
			
			System.out.println("IN Logout");
			frame.setVisible(false);
			frame.dispose();
			try{
			Login log = new Login();
			}catch(Exception exp){exp.printStackTrace();}
		}        

    }



}