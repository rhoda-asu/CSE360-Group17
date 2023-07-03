package prototype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu implements ActionListener{
	private JButton nurseViewButton;
	private JButton DoctorViewButton;
	private JButton PatientViewButton;
	
	Menu(){
	JFrame frame = new JFrame();
	nurseViewButton = new JButton("Nurse Portal");
	nurseViewButton.addActionListener(this);
	
	DoctorViewButton = new JButton("Doctor Portal");
	DoctorViewButton.addActionListener(this);
	PatientViewButton = new JButton("Patient Portal");
	PatientViewButton.addActionListener(this);
	JLabel Title = new JLabel("Office Automation System for Pediatric Doctor’s Office");
	
	nurseViewButton.setBounds(250,100,300,75);
	DoctorViewButton.setBounds(250,250,300,75);
	PatientViewButton.setBounds(250,400,300,75);
	Title.setBounds(235,5,400,75);
	
	frame.add(nurseViewButton);
	frame.add(DoctorViewButton);
	frame.add(PatientViewButton);
	frame.add(Title);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800,700);
	frame.setLayout(null);
	frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== nurseViewButton) {
			NurseView NurseView = new NurseView();
			
		}
		if(e.getSource()== DoctorViewButton) {
			DoctorPortal DoctorPortal = new DoctorPortal();
			
		}
		if(e.getSource()== PatientViewButton) {
			PaientPortal PaientPortal = new PaientPortal();
			
		}
		
		
	}
}
