import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import java.net.*;

public class Advice implements ActionListener{
	
	Boolean cough;
	Boolean cold;
	Boolean fever;
	Boolean heada;
	Boolean bodya;
	Boolean breatht;
	Boolean vomiting;
	int risk = 0;
	String UserId;
	public String Severity;

	JFrame frame = new JFrame();
    JLabel riskTips =new JLabel("", SwingConstants.CENTER);
	JLabel adviceTips =new JLabel("", SwingConstants.CENTER);
	JButton Submit=new JButton("Exit");
	JButton dashBoard=new JButton("DashBoard");
	
	Advice(Boolean Fever, Boolean Cold, Boolean Cough, Boolean HeadA, Boolean BodyA, Boolean BreathT, Boolean Vomiting, String uId) { 
		this.cough = Cough;
		this.cold = Cold;
		this.fever = Fever;
		this.heada = HeadA;
		this.bodya = BodyA;
		this.breatht = BreathT;
		this.vomiting = Vomiting;
		this.UserId = uId;
		
		
        riskTips.setFont(new Font(null,Font.ITALIC,18));
        riskTips.setBounds(75,50,700,200);
		adviceTips.setFont(new Font(null,Font.ITALIC,18));
		adviceTips.setBounds(75,100,700,200);
		Submit.setBounds(150,250,240,40);
        Submit.setFocusable(false);
        Submit.setBackground(Color.gray);
        Submit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        Submit.addActionListener(this);
        
		dashBoard.setBounds(450,250,240,40);
        dashBoard.setFocusable(false);
        dashBoard.setBackground(Color.gray);
        dashBoard.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        dashBoard.addActionListener(this);
		
        frame.add(Submit);
		frame.add(dashBoard);
		
		if (Fever) risk += 3; 
		if (Cold) risk += 3;
		if (HeadA) risk += 3;
		if (BreathT) risk += 3;
		if (Vomiting) risk += 1;
		if  (Cough) risk += 2;
		if (BodyA) risk += 2;
    	else risk += 0;
		
		
		if (risk >= 10) {
			Severity="High risk";
			riskTips.setText("Your are in a high risk group.");
			adviceTips.setText("Call 112 if your condition get worse after a few hours");
		} else if (risk < 10 && risk >= 5) {
			Severity="Prone to Risk";
			riskTips.setText("Your are in a middle risk group.");
			adviceTips.setText("You should self-quarantine. Try to not to go out. You may affect other!");
		} else if (risk < 5 && risk > 0){
			Severity="Low risk";
			riskTips.setText("Your are in a low risk group.");
			adviceTips.setText("Drink more water and take rest! ");
		} else {
			Severity="Healthy";
			adviceTips.setText("You are not under any risks. Keep healthy :)");
		}
		
		frame.add(riskTips);
		frame.add(adviceTips);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Submit) {
            	frame.setVisible(false);
				frame.dispose();
            }
		if (e.getSource()==dashBoard) {
            	frame.setVisible(false);
				frame.dispose();
				try{dash da=new dash(UserId);}
				catch(Exception m){m.printStackTrace();}
				
            }
		
	}
}