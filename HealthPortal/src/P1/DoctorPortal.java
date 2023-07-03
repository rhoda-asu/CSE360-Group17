package prototype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DoctorPortal {
	private JButton SavaButton;
	private JButton patientHistoryButton;
	DoctorPortal(){
		JFrame frame = new JFrame();
		SavaButton = new JButton("Save");
		patientHistoryButton = new JButton("Patient History");
		JLabel PhysicalTest = new JLabel("Physical Test");
		
		JTextField EarField = new JTextField();
		JTextField MedicationField = new JTextField();
		JTextField VisionField = new JTextField();
		JTextField ThroutField = new JTextField();
		JTextField SkinField = new JTextField();
		JTextField LesionsField = new JTextField();
		
		JLabel MedicationL = new JLabel("Medication:");
		JLabel EarL = new JLabel("Ear:");
		JLabel VisionL = new JLabel("Vision:");
		JLabel ThroutL = new JLabel("Throut:");
		JLabel SkinL = new JLabel("Skin:");
		JLabel LesionsL = new JLabel("Lesions:");
		
		SavaButton.setBounds(650,600,100,50);
		patientHistoryButton.setBounds(500,600,125,50);
		PhysicalTest.setBounds(350,10,200,50);
		
		MedicationField.setBounds(150,65,300,50);
		EarField.setBounds(150,150,300,50);
		VisionField.setBounds(150,250,300,50);
		ThroutField.setBounds(150,350,300,50);
		SkinField.setBounds(150,450,300,50);
		LesionsField.setBounds(150,550,300,50);
		
		MedicationL.setBounds(10,50,200,50);
		EarL.setBounds(10,150,200,50);
		VisionL.setBounds(10,250,200,50);
		ThroutL.setBounds(10,350,200,50);
		SkinL.setBounds(10,450,200,50);
		LesionsL.setBounds(10,550,200,50);
		
		frame.add(SavaButton);
		frame.add(patientHistoryButton);
		frame.add(PhysicalTest);
		frame.add(MedicationField);
		frame.add(EarField);
		frame.add(VisionField);
		frame.add(ThroutField);
		frame.add(SkinField);
		frame.add(LesionsField);
		
		frame.add(MedicationL);
		frame.add(EarL);
		frame.add(VisionL);
		frame.add(ThroutL);
		frame.add(SkinL);
		frame.add(LesionsL);
	
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
