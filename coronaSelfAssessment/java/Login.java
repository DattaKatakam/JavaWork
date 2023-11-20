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

public class Login implements ActionListener {
    HashMap<String,String> logininfo=new HashMap<>();
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("Login_page_Image.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));
    JLabel Company_Name=new JLabel("Corona -- Info Thuringia");
    JButton logbutton1=new JButton("Exit");
    JButton logbutton=new JButton("Log in");
    JButton SignUp=new JButton("Sign up");
	JButton forgotPass=new JButton("Forgot Password?");
    JTextField Id=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel userIdLabel=new JLabel("User Name :");
    JLabel userPassword=new JLabel("Password :");
    JLabel Message=new JLabel("Log in to veiw your details  ");
	Scanner sc;

    Login() throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
        Company_Name.setBounds(300,90,500,60);
        Company_Name.setFont(new Font(null,Font.CENTER_BASELINE,35));
        userIdLabel.setBounds(325,250,150,40);
        userIdLabel.setFont(new Font(null,Font.BOLD,25));
        userPassword.setBounds(325,350,150,40);
        userPassword.setFont(new Font(null,Font.BOLD,25));
        Message.setBounds(400,520,450,35);
        Message.setFont(new Font(null,Font.TYPE1_FONT,15));
        Id.setBounds(325,300,400,45);
        password.setBounds(325,400,400,45);
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
		
		forgotPass.setBounds(330,450,120,20);
		forgotPass.setFocusable(false);
		forgotPass.setBackground(Color.gray);
		forgotPass.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		forgotPass.addActionListener(this);
		
        SignUp.setBounds(750,40,140,40);
        SignUp.setFocusable(false);
        SignUp.setBackground(Color.gray);
        SignUp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        SignUp.addActionListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(background);
        background.setLayout(null);
        background.setVisible(true);
        background.add(logbutton1);
		background.add(forgotPass);
        background.add(logbutton);
        background.add(SignUp);
        background.add(Company_Name);
        background.add(Id);
        background.add(password);
        background.add(Message);
        background.add(userIdLabel);
        background.add(userPassword);
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
          	  SignIn SignIn = new SignIn();
			  frame.dispose();
			  frame.setVisible(false);
            }
			
			if (e.getSource()==forgotPass){
          	  ForgotPassword fp = new ForgotPassword();
			  frame.dispose();
			  frame.setVisible(false);
            }
			
        if(e.getSource()==logbutton) {
            String UserId=Id.getText();
            String UserPass=String.valueOf(password.getPassword());
			boolean check = false;	
				
            if(!UserId.isEmpty() && !UserPass.isEmpty()) {
					try {
						String firstName; String lastName; String mailId; String address; String userName; String pass;
						sc = new Scanner(new File(path));
						sc.useDelimiter("[,\n]");
						
						while(sc.hasNext() && !check){
							firstName = sc.next();
							lastName = sc.next();
							mailId = sc.next();
							address = sc.next();
							userName = sc.next();
							pass = sc.next();
							
							if(UserId.equals(userName)&& UserPass.equals(pass)) {
								check = true;
							}
							
						}
						if(check){
							
							//User_Welcome_Page Page=new User_Welcome_Page(UserId);
							frame.setVisible(false);
							frame.dispose();
							dash db = new dash(UserId);
							//db.setVisible(true);
							JOptionPane.showMessageDialog(null,"succesfully logged in");
							
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
