package P1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


public class Patient extends User{
	private double height;
	private double weight;
	private String sex;
	private ArrayList<HistoryEntry> medicalHistory;
	private ArrayList<TestEntry> tests;
	private ArrayList<Appointment> schedule;
	
	public Patient() {
		super();
	}
	

	public Patient(String ID, String name, String password, String email) {
		super(ID, name, password, email);
		this.height = 0.0;
		this.weight = 0.0;
		this.sex = "";
		this.medicalHistory = new ArrayList<HistoryEntry>();
		this.tests = new ArrayList<TestEntry>();
		this.schedule = new ArrayList<Appointment>();
	}


	public double getHeight() {
		return height;
	}


	public double getWeight() {
		return weight;
	}


	public String getSex() {
		return sex;
	}


	public ArrayList<HistoryEntry> getMedicalHistory() {
		return medicalHistory;
	}


	public ArrayList<TestEntry> getTests() {
		return tests;
	}


	public ArrayList<Appointment> getSchedule() {
		return schedule;
	}


	public void setHeight(double height) {
		this.height = height;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}


	public void setWeight(double weight) {
		this.weight = weight;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}


	public void setSex(String sex) {
		this.sex = sex;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}


	public void setMedicalHistory(ArrayList<HistoryEntry> medicalHistory) {
		this.medicalHistory = medicalHistory;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}


	public void setTests(ArrayList<TestEntry> tests) {
		this.tests = tests;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}


	public void setSchedule(ArrayList<Appointment> schedule) {
		this.schedule = schedule;
		Database.getInstance().addPatient(this); // Update the Patient object in the database
	}
	
	@Override
	public void view(Stage primaryStage) {
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.BASELINE_CENTER);
	    pane.setHgap(5.5);
	    pane.setVgap(15);

	    Label title = new Label("Welcome to the Patient Portal " + super.getName());

	    Button scheduleAppointment = new Button("Schedule Appointment");
	    Button messageDoctor = new Button("Message Doctor");
	    Button viewHistory = new Button("View Medical History");
	    Button viewAppointments = new Button("View Upcoming Appointments");

	    // Add event handlers for the buttons
	    scheduleAppointment.setOnAction(e -> scheduleAppointment(primaryStage));
	    viewAppointments.setOnAction(e -> viewUpcomingAppointments(primaryStage));
	    // You can add event handlers for the other buttons as well

	    pane.addColumn(1, title, scheduleAppointment, messageDoctor, viewHistory, viewAppointments);
	    Scene patientPortalScene = new Scene(pane, 600, 350);
	    primaryStage.setScene(patientPortalScene);
	    primaryStage.show();
	}

	public void scheduleAppointment(Stage primaryStage) {
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.BASELINE_CENTER);
	    pane.setHgap(5.5);
	    pane.setVgap(15);

	    Label titleLabel = new Label("Schedule Appointment");
	    Label doctorIDLabel = new Label("Doctor ID:");
	    Label timeDateLabel = new Label("Time and Date:");
	    Label descriptionLabel = new Label("Description:");

	    TextField doctorIDField = new TextField();
	    TextField timeDateField = new TextField();
	    TextField descriptionField = new TextField();

	    Button scheduleButton = new Button("Schedule");
	    Button cancelButton = new Button("Cancel");

	    pane.addColumn(1, titleLabel, doctorIDLabel, timeDateLabel, descriptionLabel);
	    pane.addColumn(2, doctorIDField, timeDateField, descriptionField);
	    pane.addColumn(1, scheduleButton, cancelButton);

	    Scene scheduleAppointmentScene = new Scene(pane, 600, 350);
	    primaryStage.setScene(scheduleAppointmentScene);
	    primaryStage.show();

	    scheduleButton.setOnAction(e -> {
	        String doctorID = doctorIDField.getText();
	        String timeDate = timeDateField.getText();
	        String description = descriptionField.getText();

	        // Create a new Appointment object
	        Appointment appointment = new Appointment(doctorID, this.getID(), timeDate, description);

	        // Add the appointment to the patient's schedule
	        ArrayList<Appointment> schedule = this.getSchedule();
	        schedule.add(appointment);
	        this.setSchedule(schedule);

	        // Display a confirmation message
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Appointment Scheduled");
	        alert.setHeaderText(null);
	        alert.setContentText("Appointment scheduled successfully!");
	        alert.showAndWait();

	        // Go back to the patient portal
	        view(primaryStage);
	    });

	    cancelButton.setOnAction(e -> view(primaryStage));
	}

	public void viewUpcomingAppointments(Stage primaryStage) {
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.BASELINE_CENTER);
	    pane.setHgap(5.5);
	    pane.setVgap(15);

	    Label titleLabel = new Label("Upcoming Appointments");
	    TextArea appointmentsArea = new TextArea();
	    appointmentsArea.setEditable(false);

	    Button backButton = new Button("Back");

	    pane.addColumn(1, titleLabel, appointmentsArea, backButton);

	    Scene viewAppointmentsScene = new Scene(pane, 600, 350);
	    primaryStage.setScene(viewAppointmentsScene);
	    primaryStage.show();

	    backButton.setOnAction(e -> view(primaryStage));

	    // Display the upcoming appointments in the text area
	    ArrayList<Appointment> schedule = this.getSchedule();
	    if (schedule.isEmpty()) {
	        appointmentsArea.setText("You have no upcoming appointments.");
	    } else {
	        StringBuilder sb = new StringBuilder();
	        for (Appointment appointment : schedule) {
	            sb.append("Doctor: ").append(appointment.getDoctorID()).append("\n");
	            sb.append("Date and Time: ").append(appointment.getTime_date()).append("\n");
	            sb.append("Description: ").append(appointment.getDescription()).append("\n\n");
	        }
	        appointmentsArea.setText(sb.toString());
	    }
	}

	
	@Override
	public String toString() {
		return (
				"Name: " + super.getName() + 
				"\nHeight: " + this.height + 
				"\nWeight: " + this.weight + 
				"\nSex: " + this.sex + 
				"\nMedical History:" + printHistory() + 
				"\nTests: " + printTests() + "\n"
				);
	}
	
	public String printHistory() {
		String str = "";
		for(int i = 0; i < this.medicalHistory.size(); i++) {
			str += this.medicalHistory.get(i).toString() + "\n";
		}
		return str;
	}
	
	public String printTests() {
		String str = "";
		for(int i = 0; i < this.tests.size(); i++) {
			str += this.tests.get(i).toString() + "\n";
		}
		return str;
	}
	
	
}
