package prototype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PatientHistory {
	private JButton ReturnButton;
	PatientHistory(){
		JFrame frame = new JFrame();
		ReturnButton = new JButton("Return To Main");
		JLabel PatientHistory = new JLabel("Patient History");
		
		JTextField MedicationField = new JTextField();
		JTextField HealthConcernsField = new JTextField();
		JTextField immunizationField = new JTextField();
		
		JLabel MedicationL = new JLabel("Prescribed Medication:");
		JLabel HealthConcernsL = new JLabel("Health concerns:");
		JLabel immunizationL = new JLabel("Immunization:");
		
		ReturnButton.setBounds(550,575,150,75);
		PatientHistory.setBounds(350,10,200,50);
		
		MedicationField.setBounds(170,65,400,75);
		HealthConcernsField.setBounds(170,200,400,75);
		immunizationField.setBounds(170,335,400,75);
		
		MedicationL.setBounds(10,65,200,50);
		HealthConcernsL.setBounds(10,200,200,50);
		immunizationL.setBounds(10,335,200,50);
		
		frame.add(ReturnButton);
		frame.add(PatientHistory);
		frame.add(MedicationField);
		frame.add(HealthConcernsField);
		frame.add(immunizationField);

		
		frame.add(MedicationL);
		frame.add(HealthConcernsL);
		frame.add(immunizationL);		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}

