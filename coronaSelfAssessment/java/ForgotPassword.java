import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.net.*;
import java.util.Scanner;
public class ForgotPassword implements ActionListener {
    HashMap<String,String> logininfo=new HashMap<>();
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("Login_page_Image.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));
    JLabel Company_Name=new JLabel("Corona -- Info Thuringia");
    JButton logbutton1=new JButton("Exit");
    JButton logbutton=new JButton("See Password");
    JButton SignUp=new JButton("Login Page");
	//JButton forgotPass=new JButton("Forgot Password?");
    JTextField Id=new JTextField();
	JTextField emailAddress=new JTextField();
	
    //JPasswordField password=new JPasswordField();
    JLabel userIdLabel=new JLabel("User Name :");
    JLabel emailID=new JLabel("Email Id :");
    JLabel Message=new JLabel("Enter userName and email id to reset password to your lastName");
	Scanner sc;

    ForgotPassword() throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
        Company_Name.setBounds(300,90,500,60);
        Company_Name.setFont(new Font(null,Font.CENTER_BASELINE,35));
        userIdLabel.setBounds(325,250,150,40);
        userIdLabel.setFont(new Font(null,Font.BOLD,25));
        emailID.setBounds(325,350,150,40);
        emailID.setFont(new Font(null,Font.BOLD,25));
        Message.setBounds(310,220,500,35);
        Message.setFont(new Font(null,Font.TYPE1_FONT,15));
        Id.setBounds(325,300,400,45);
        emailAddress.setBounds(325,400,400,45);
        logbutton1.setBounds(900,40,140,40);
        logbutton1.setFocusable(false);
        logbutton1.setBackground(Color.gray);
        logbutton1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logbutton1.addActionListener(this);
        logbutton.setBounds(450,480,150,28);
        logbutton.setFocusable(false);
        logbutton.setBackground(Color.gray);
        logbutton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logbutton.addActionListener(this);
				
        SignUp.setBounds(120,40,140,40);
        SignUp.setFocusable(false);
        SignUp.setBackground(Color.gray);
        SignUp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        SignUp.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(background);
        background.setLayout(null);
        background.setVisible(true);
        background.add(logbutton1);
		//background.add(forgotPass);
        background.add(logbutton);
        background.add(SignUp);
        background.add(Company_Name);
        background.add(Id);
        background.add(emailAddress);
        background.add(Message);
        background.add(userIdLabel);
        background.add(emailID);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,Height);
        frame.setForeground(Color.darkGray);
        frame.pack();
        frame.setVisible(true);
        }
    
// group 25 code changed completley to verify the login details
    @Override
    public void actionPerformed(ActionEvent e) {

        String line="";
        String path="src\\main\\java\\CSV\\DataColect.csv";
		
		try{
			
			if (e.getSource()==SignUp){
          	  Login lp = new Login();
			  frame.dispose();
			  frame.setVisible(false);
            }
			
        if(e.getSource()==logbutton) {
            String UserId=Id.getText();
            String UserEmail=emailAddress.getText();
			boolean check = false;	
				
            if(!UserId.isEmpty() && !UserEmail.isEmpty()) {
					try {
						String firstName; String lastName; String mailId; String address; String userName; String pass="";
						sc = new Scanner(new File(path));
						sc.useDelimiter("[,\n]");
						
						while(sc.hasNext() && !check){
							firstName = sc.next();
							lastName = sc.next();
							mailId = sc.next();
							address = sc.next();
							userName = sc.next();
							pass = sc.next();
							
							if(UserId.equals(userName)&& UserEmail.equals(mailId)) {
								check = true;
							}
							
						}
						if(check){
							
							JOptionPane.showMessageDialog(null,"Your Password is"+pass);
							frame.setVisible(false);
							frame.dispose();
							Login lp = new Login();
							
							
						}
						
						else{
							JOptionPane.showMessageDialog(null,"sorry enter correct details");
							frame.setVisible(false);
							frame.dispose();
							frame.setVisible(true);
						}
						
					}
					catch(IOException a){
						a.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"sorry either of the details are missing");
					frame.setVisible(false);
					frame.dispose();
					frame.setVisible(true);
				}	
				
            }
            if (e.getSource()==logbutton1) {
            	frame.dispose();
            }
			
		}	
		catch (Exception e1){
			
			e1.printStackTrace();
			
		}
    }
}

