import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class NurseView {
    private JButton saveButton;
    private JButton patientHistoryButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField healthConcernsField;
    private JTextField insuranceIDField;
    private JTextField heightField;
    private JTextField weightField;
    private JTextField bodyTempField;
    private JTextField bloodPressField;
    private JTextField allergiesField;

    public NurseView() {
        JFrame frame = new JFrame();
        saveButton = new JButton("Save");
        patientHistoryButton = new JButton("Patient History");
        JLabel patientIntakeForm = new JLabel("Nurse View");
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        healthConcernsField = new JTextField();
        insuranceIDField = new JTextField();
        heightField = new JTextField();
        weightField = new JTextField();
        bodyTempField = new JTextField();
        bloodPressField = new JTextField();
        allergiesField = new JTextField();
        JLabel firstNameLabel = new JLabel("First name:");
        JLabel lastNameLabel = new JLabel("Last name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel healthConcernsLabel = new JLabel("Health concerns:");
        JLabel insuranceIDLabel = new JLabel("Insurance ID:");
        JLabel heightLabel = new JLabel("Height:");
        JLabel weightLabel = new JLabel("Weight:");
        JLabel bodyTempLabel = new JLabel("Body Temperature:");
        JLabel bloodPressLabel = new JLabel("Blood Pressure:");
        JLabel allergiesLabel = new JLabel("Allergies:");

        saveButton.setBounds(650, 600, 100, 50);
        patientHistoryButton.setBounds(500, 600, 125, 50);
        patientIntakeForm.setBounds(350, 10, 200, 50);
        firstNameField.setBounds(150, 65, 200, 50);
        lastNameField.setBounds(150, 150, 200, 50);
        emailField.setBounds(150, 250, 200, 50);
        phoneNumberField.setBounds(150, 350, 200, 50);
        healthConcernsField.setBounds(150, 450, 200, 50);
        insuranceIDField.setBounds(150, 550, 200, 50);
        heightField.setBounds(525, 65, 200, 50);
        weightField.setBounds(525, 150, 200, 50);
        bodyTempField.setBounds(525, 250, 200, 50);
        bloodPressField.setBounds(525, 350, 200, 50);
        allergiesField.setBounds(525, 450, 200, 50);
        firstNameLabel.setBounds(10, 50, 200, 50);
        lastNameLabel.setBounds(10, 150, 200, 50);
        emailLabel.setBounds(10, 250, 200, 50);
        phoneNumberLabel.setBounds(10, 350, 200, 50);
        healthConcernsLabel.setBounds(10, 450, 200, 50);
        insuranceIDLabel.setBounds(10, 550, 200, 50);
        heightLabel.setBounds(400, 50, 200, 50);
        weightLabel.setBounds(400, 150, 200, 50);
        bodyTempLabel.setBounds(400, 250, 200, 50);
        bloodPressLabel.setBounds(400, 350, 200, 50);
        allergiesLabel.setBounds(400, 450, 200, 50);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToFile();
            }
        });

        frame.add(saveButton);
        frame.add(patientHistoryButton);
        frame.add(patientIntakeForm);
        frame.add(firstNameField);
        frame.add(lastNameField);
        frame.add(emailField);
        frame.add(phoneNumberField);
        frame.add(healthConcernsField);
        frame.add(insuranceIDField);
        frame.add(heightField);
        frame.add(weightField);
        frame.add(bodyTempField);
        frame.add(bloodPressField);
        frame.add(allergiesField);
        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(emailLabel);
        frame.add(phoneNumberLabel);
        frame.add(healthConcernsLabel);
        frame.add(insuranceIDLabel);
        frame.add(heightLabel);
        frame.add(weightLabel);
        frame.add(bodyTempLabel);
        frame.add(bloodPressLabel);
        frame.add(allergiesLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void saveDataToFile() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        String healthConcerns = healthConcernsField.getText();
        String insuranceID = insuranceIDField.getText();
        String height = heightField.getText();
        String weight = weightField.getText();
        String bodyTemp = bodyTempField.getText();
        String bloodPress = bloodPressField.getText();
        String allergies = allergiesField.getText();

        // Prepare the data string
        String data = "First Name: " + firstName + "\n" +
                      "Last Name: " + lastName + "\n" +
                      "Email: " + email + "\n" +
                      "Phone Number: " + phoneNumber + "\n" +
                      "Health Concerns: " + healthConcerns + "\n" +
                      "Insurance ID: " + insuranceID + "\n" +
                      "Height: " + height + "\n" +
                      "Weight: " + weight + "\n" +
                      "Body Temperature: " + bodyTemp + "\n" +
                      "Blood Pressure: " + bloodPress + "\n" +
                      "Allergies: " + allergies + "\n";

        // Save the data to a text file
        try {
            FileWriter writer = new FileWriter("patient_data.txt");
            writer.write(data);
            writer.close();
            System.out.println("Data saved to patient_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
        new NurseView();
    }*/
}
