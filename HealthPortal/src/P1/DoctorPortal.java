package prototype;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.IOException;

public class DoctorPortal {
    private JButton saveButton;
    private JButton patientHistoryButton;

    DoctorPortal() {
        JFrame frame = new JFrame();
        saveButton = new JButton("Save");
        patientHistoryButton = new JButton("Patient History");
        JLabel physicalTest = new JLabel("Physical Test");
        JTextField medicationField = new JTextField();
        JTextField earField = new JTextField();
        JTextField visionField = new JTextField();
        JTextField throatField = new JTextField();
        JTextField skinField = new JTextField();
        JTextField lesionsField = new JTextField();

        JLabel medicationLabel = new JLabel("Medication:");
        JLabel earLabel = new JLabel("Ear:");
        JLabel visionLabel = new JLabel("Vision:");
        JLabel throatLabel = new JLabel("Throat:");
        JLabel skinLabel = new JLabel("Skin:");
        JLabel lesionsLabel = new JLabel("Lesions:");

        saveButton.setBounds(650, 600, 100, 50);
        patientHistoryButton.setBounds(500, 600, 125, 50);
        physicalTest.setBounds(350, 10, 200, 50);

        medicationField.setBounds(150, 65, 300, 50);
        earField.setBounds(150, 150, 300, 50);
        visionField.setBounds(150, 250, 300, 50);
        throatField.setBounds(150, 350, 300, 50);
        skinField.setBounds(150, 450, 300, 50);
        lesionsField.setBounds(150, 550, 300, 50);

        medicationLabel.setBounds(10, 50, 200, 50);
        earLabel.setBounds(10, 150, 200, 50);
        visionLabel.setBounds(10, 250, 200, 50);
        throatLabel.setBounds(10, 350, 200, 50);
        skinLabel.setBounds(10, 450, 200, 50);
        lesionsLabel.setBounds(10, 550, 200, 50);

        saveButton.addActionListener(e -> {
            String medication = medicationField.getText();
            String ear = earField.getText();
            String vision = visionField.getText();
            String throat = throatField.getText();
            String skin = skinField.getText();
            String lesions = lesionsField.getText();

            String data = "Medication: " + medication + "\n" +
                    "Ear: " + ear + "\n" +
                    "Vision: " + vision + "\n" +
                    "Throat: " + throat + "\n" +
                    "Skin: " + skin + "\n" +
                    "Lesions: " + lesions;

            try {
                FileWriter writer = new FileWriter("data.txt");
                writer.write(data);
                writer.close();
                System.out.println("Data saved to file.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        frame.add(saveButton);
        frame.add(patientHistoryButton);
        frame.add(physicalTest);
        frame.add(medicationField);
        frame.add(earField);
        frame.add(visionField);
        frame.add(throatField);
        frame.add(skinField);
        frame.add(lesionsField);

        frame.add(medicationLabel);
        frame.add(earLabel);
        frame.add(visionLabel);
        frame.add(throatLabel);
        frame.add(skinLabel);
        frame.add(lesionsLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.setLayout(null);
        frame.setVisible(true);
    }
/*
    public static void main(String[] args) {
        new DoctorPortal();
    }*/
}
