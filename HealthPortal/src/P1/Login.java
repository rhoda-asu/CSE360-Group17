package prototype;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton createButton = new JButton("Create account");
	JTextField userIDField = new JTextField();
	JPasswordField userPassField = new 	JPasswordField();
	JLabel userIDL = new JLabel("UserID:");
	JLabel userpassL = new JLabel("Password:");
	JLabel Title = new JLabel();
	HashMap<String,String> logininfo = new HashMap<String,String>();
	Login(HashMap<String,String> logininfoOG){
		logininfo = logininfoOG;
		
		userIDL.setBounds(50,250,75,25);
		userpassL.setBounds(50,350,75,25);
		frame.add(userIDL);
		frame.add(userpassL);
		Title.setBounds(600,250,250,35);
		userIDField.setBounds(125,250,200,50);
		userPassField.setBounds(125,350,200,50);
		
		loginButton.setBounds(400,500,125,75);
		createButton.setBounds(400,600,125,75);
		
		
		frame.add(loginButton);
		frame.add(createButton);
		frame.add(userIDField);
		frame.add(userPassField);		
		frame.add(Title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,900);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPassField.getPassword());
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					Title.setForeground(Color.green);
					Title.setText("sucess");
					
				}
			}
		}
		
	}

}
