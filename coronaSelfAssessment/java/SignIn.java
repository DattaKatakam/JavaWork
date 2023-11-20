import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.*;
import java.util.Scanner;

public class SignIn implements ActionListener{
    List<User> users = new ArrayList<User>();
    String filePath = "src\\main\\java\\CSV\\DataColect.csv";
    User[] user=new User[5000];
	Scanner sc;

    private int i=0;
    String line="";
    JFrame frame=new JFrame();
    InputStream stream = getClass().getClassLoader().getResourceAsStream("Login_page_Image.png");
    JLabel background = new JLabel(new ImageIcon(ImageIO.read(stream)));
    JButton SignUp=new JButton("SignUp");
	JButton logIn=new JButton("Login Page");
	JButton exitBTN=new JButton("Exit");
    JTextField Id=new JTextField();
    JPasswordField password=new JPasswordField();
    JLabel userIdLabel=new JLabel("User Id*");
    JLabel userPassword=new JLabel("Password*");
    JTextField First_name=new JTextField();
    JLabel First_nameLabel=new JLabel("First Name* ");
    JTextField Last_name=new JTextField();
    JLabel Last_nameLabel=new JLabel("Last Name*");
    JTextField email=new JTextField();
    JLabel Email_Label=new JLabel("e-mail*");
    JTextField Address=new JTextField();
    JLabel Address_Label=new JLabel("Address*");
    SignIn() throws IOException {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int Width= (int) tk.getScreenSize().getWidth();
        int Height=(int) tk.getScreenSize().getHeight();
        First_nameLabel.setBounds(350,50,150,40);
        First_nameLabel.setFont(new Font(null,Font.ITALIC,18));
        Last_nameLabel.setBounds(350,130,150,40);
        Last_nameLabel.setFont(new Font(null,Font.ITALIC,18));
        First_name.setBounds(350,90,350,40);
        Last_name.setBounds(350,170,350,40);
        Email_Label.setBounds(350,210,150,40);
        Email_Label.setFont(new Font(null,Font.ITALIC,18));
        Address_Label.setBounds(350,290,150,40);
        Address_Label.setFont(new Font(null,Font.ITALIC,18));
        email.setBounds(350,250,350,40);
        Address.setBounds(350,330,350,40);
        userIdLabel.setBounds(350,370,150,40);
        userIdLabel.setFont(new Font(null,Font.ITALIC,18));
        userPassword.setBounds(350,450,350,40);
        userPassword.setFont(new Font(null,Font.ITALIC,18));
        password.setBounds(350,490,350,40);
        Id.setBounds(350,410,350,40);
        SignUp.setBounds(400,600,240,40);
        SignUp.setFocusable(false);
        SignUp.setBackground(Color.gray);
        SignUp.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        SignUp.addActionListener(this);
        
		exitBTN.setBounds(900,50,120,40);
        exitBTN.setFocusable(false);
        exitBTN.setBackground(Color.gray);
        exitBTN.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        exitBTN.addActionListener(this);
        
		logIn.setBounds(100,50,120,40);
        logIn.setFocusable(false);
        logIn.setBackground(Color.gray);
        logIn.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        logIn.addActionListener(this);
        		
		frame.setLayout(new BorderLayout());
        frame.add(background);
        background.add(SignUp);
		background.add(logIn);
		background.add(exitBTN);
        background.add(First_nameLabel);
        background.add(First_name);
        background.add(Last_nameLabel);
        background.add(Last_name);
        background.add(Email_Label);
        background.add(email);
        background.add(Address_Label);
        background.add(Address);
        background.add(userIdLabel);
        background.add(userPassword);
        background.add(Id);
        background.add(password);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,Height);
        frame.pack();
        frame.setLayout(null);
        frame.setVisible(true);
        try{
            BufferedReader br=new BufferedReader(new FileReader(filePath));
            while ((line= br.readLine())!=null){
                user[i]=new User();
                String[] row=line.split("\n");
                for(int j=0;j< row.length;j++){
                    String[] col=row[j].split(",");
                    user[i].setFirst_Name(col[0]);
                    user[i].setLast_Name(col[1]);
                    user[i].setemail(col[2]);
                    user[i].setAddress(col[3]);
                    user[i].setUser_Name(col[4]);
                    user[i].setPassword(col[5]);
                    users.add(user[i]);

                }i++;
            }
        } catch(IOException e){
            e.printStackTrace();
        }

    }

//group 25 changed the code for making compulsary of mail id and username
// also code addded to check wether all boxes are filled
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == SignUp) {
            i++;
			String path="src\\main\\java\\CSV\\DataColect.csv";
			boolean check = false;
			String firstName = First_name.getText();
			String lastName = Last_name.getText();
			String emailAddress = email.getText();
			String addressFull = String.valueOf(Address.getText());
			String userName = Id.getText();
			String UserPass = String.valueOf(password.getPassword());
			
			if( !emailAddress.isEmpty() && !addressFull.isEmpty() && !userName.isEmpty() && !UserPass.isEmpty()
					&&	!firstName.isEmpty()&&	!lastName.isEmpty()	){
				try{
					String fName; String lName; String mailId; String address; String uName; String pass;
					sc = new Scanner(new File(path));
					sc.useDelimiter("[,\n]");
					
					while(sc.hasNext() && !check){
						fName = sc.next();
						lName = sc.next();
						mailId = sc.next();
						address = sc.next();
						uName = sc.next();
						pass = sc.next();
						
						if(userName.equalsIgnoreCase(uName)|| emailAddress.equalsIgnoreCase(mailId)) {
							check = true;
						}
							
					}
					if(check){
						
						JOptionPane.showMessageDialog(null,"sorry either mail id or username is repeated");
						frame.setVisible(false);
						frame.dispose();
						frame.setVisible(true);
						
					}
					else{
						
						user[i]=new User();
						user[i].setFirst_Name(firstName);
						user[i].setLast_Name(lastName);
						user[i].setemail(emailAddress);
						user[i].setAddress(addressFull);
						user[i].setUser_Name(userName);
						user[i].setPassword(UserPass);
						users.add(user[i]);
						
						FileWriter fileWriter = null ;
						try {
						fileWriter = new FileWriter (path);
							for ( User u : users ) {
								fileWriter . append ( u . getFirst_Name ());
								fileWriter . append ( "," );
								fileWriter .append ( u . getLast_Name ());
								fileWriter .append(",");
								fileWriter .append(u.getemail());
								fileWriter .append(",");
								fileWriter . append ( String . valueOf ( u . getAddress ()));
								fileWriter . append ( "," );
								fileWriter .append(u.getUser_Name());
								fileWriter .append(",");
								fileWriter .append(u.getPassword());
								fileWriter . append ( "\n" ); }
								JOptionPane.showMessageDialog(null,"You are successfully registered");
					
								frame.setVisible(false);
								frame.dispose();
								Login Login = new Login();
						}
						catch ( Exception ex ) {
							ex . printStackTrace (); } finally { try {
						assert fileWriter != null;
						fileWriter . flush ();
						fileWriter . close (); } catch ( Exception a ) {
						a . printStackTrace (); } }

						
						
					}
						
					
					
					
				}catch (Exception e1){
					
					e1.printStackTrace();
					
				}
				
				
				
			}
			
			else{
				
				JOptionPane.showMessageDialog(null,"sorry some details are missing");
				frame.setVisible(false);
				frame.dispose();
				frame.setVisible(true);
				
			}
			
			/*
            user[i]=new User();
            user[i].setFirst_Name(firstName);
            user[i].setLast_Name(lastName);
            user[i].setemail(emailAddress);
            user[i].setAddress(addressFull);
            user[i].setUser_Name(userName);
            user[i].setPassword(userPass);
            users.add(user[i]);*/
            
        }
		
		if (e.getSource() == logIn){
			
			frame.setVisible(false);
			frame.dispose();
			try{Login l = new Login();}
			catch(Exception ex){ex.printStackTrace();}
			
		}
		
		if (e.getSource() == exitBTN){
			
			frame.setVisible(false);
			frame.dispose();			
			
		}
		
		
		
        }



    }





