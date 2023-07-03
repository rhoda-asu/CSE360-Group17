package prototype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class PaientPortal {
		private JButton MessageButton;
		private JButton ContactInformationButton;
		PaientPortal(){
			JFrame frame = new JFrame();
			MessageButton = new JButton("Message Portal");
			ContactInformationButton = new JButton("Edit Contact information");
			JLabel PatientPortal = new JLabel("Patient Portal");
			
			JTextField NameField = new JTextField();
			JTextField ContactInformationField = new JTextField();
			JTextField SummaryField = new JTextField();
			
			JLabel NameL = new JLabel("Name and Birthday:");
			JLabel ContactInformationL = new JLabel("Contact Information:");
			JLabel SummaryL = new JLabel("Summary of Vist:");
			
			MessageButton.setBounds(550,600,150,50);
			ContactInformationButton.setBounds(200,385,175,50);
			PatientPortal.setBounds(350,10,200,50);
			
			NameField.setBounds(150,65,300,125);
			ContactInformationField.setBounds(150,250,300,125);
			SummaryField.setBounds(150,450,300,125);
		
			
			NameL.setBounds(10,65,300,100);
			ContactInformationL.setBounds(10,250,300,100);
			SummaryL.setBounds(10,450,300,100);
			
			frame.add(MessageButton);
			frame.add(ContactInformationButton);
			frame.add(PatientPortal);
			frame.add(NameField);
			frame.add(ContactInformationField);
			frame.add(SummaryField);
			
			frame.add(NameL);
			frame.add(ContactInformationL);
			frame.add(SummaryL);
		
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,700);
			frame.setLayout(null);
			frame.setVisible(true);
		}
	}

