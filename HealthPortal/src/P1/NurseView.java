package prototype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NurseView {
	private JButton SavaButton;
	private JButton patientHistoryButton;
	NurseView(){
		JFrame frame = new JFrame();
		SavaButton = new JButton("Save");
		patientHistoryButton = new JButton("Patient History");
		JLabel patientIntakeForm = new JLabel("Nurse View");
		JTextField FirstNameField = new JTextField();
		JTextField LastNameField = new JTextField();
		JTextField EmailField = new JTextField();
		JTextField PhonenumberField = new JTextField();
		JTextField HealthConcernsField = new JTextField();
		JTextField InsuranceIDField = new JTextField();
		JTextField heightField = new JTextField();
		JTextField bodyTempField = new JTextField();
		JTextField bloodPressField = new JTextField();
		JTextField allegesField = new JTextField();
		JTextField weightField = new JTextField();
		
		JLabel FirstNameL = new JLabel("First name:");
		JLabel LastNameL = new JLabel("Last name:");
		JLabel EmailL = new JLabel("Email:");
		JLabel PhonenumberL = new JLabel("Phone Number:");
		JLabel HealthConcernsL = new JLabel("Health concerns:");
		JLabel InsuranceIDFieldL = new JLabel("Insurance ID:");
		JLabel heightL = new JLabel("Height:");
		JLabel weightL = new JLabel("Weight:");
		JLabel bodyTempL = new JLabel("Body Temperature:");
		JLabel bloodPressL = new JLabel("Blood Pressure:");
		JLabel allegesL = new JLabel("Alleges:");
		
		SavaButton.setBounds(650,600,100,50);
		patientHistoryButton.setBounds(500,600,125,50);
		patientIntakeForm.setBounds(350,10,200,50);
		
		FirstNameField.setBounds(150,65,200,50);
		LastNameField.setBounds(150,150,200,50);
		EmailField.setBounds(150,250,200,50);
		PhonenumberField.setBounds(150,350,200,50);
		HealthConcernsField.setBounds(150,450,200,50);
		InsuranceIDField.setBounds(150,550,200,50);
		
		heightField.setBounds(525,65,200,50);
		weightField.setBounds(525,150,200,50);
		bodyTempField.setBounds(525,250,200,50);
		bloodPressField.setBounds(525,350,200,50);
		allegesField.setBounds(525,450,200,50);
		
		FirstNameL.setBounds(10,50,200,50);
		LastNameL.setBounds(10,150,200,50);
		EmailL.setBounds(10,250,200,50);
		PhonenumberL.setBounds(10,350,200,50);
		HealthConcernsL.setBounds(10,450,200,50);
		InsuranceIDFieldL.setBounds(10,550,200,50);
		
		heightL.setBounds(400,50,200,50);
		weightL.setBounds(400,150,200,50);
		bodyTempL.setBounds(400,250,200,50);
		bloodPressL.setBounds(400,350,200,50);
		allegesL.setBounds(400,450,200,50);
		
		frame.add(SavaButton);
		frame.add(patientHistoryButton);
		frame.add(patientIntakeForm);
		frame.add(FirstNameField);
		frame.add(LastNameField);
		frame.add(EmailField);
		frame.add(PhonenumberField);
		frame.add(HealthConcernsField);
		frame.add(InsuranceIDField);
		frame.add(heightField);
		frame.add(weightField);
		frame.add(bodyTempField);
		frame.add(bloodPressField);
		frame.add(allegesField);
		
		frame.add(FirstNameL);
		frame.add(LastNameL);
		frame.add(PhonenumberL);
		frame.add(EmailL);
		frame.add(HealthConcernsL);
		frame.add(InsuranceIDFieldL);
		frame.add(heightL);
		frame.add(weightL);
		frame.add(bodyTempL);
		frame.add(bloodPressL);
		frame.add(allegesL);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,700);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
