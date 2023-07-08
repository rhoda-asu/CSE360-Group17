package P1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public void setMedicalHistory(ArrayList<HistoryEntry> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}


	public void setTests(ArrayList<TestEntry> tests) {
		this.tests = tests;
	}


	public void setSchedule(ArrayList<Appointment> schedule) {
		this.schedule = schedule;
	}
	
	@Override
	public Scene view() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setHgap(5.5);
		pane.setVgap(15);
		
		Label title = new Label("Welcome to the Patient Portal " + super.getName());
		
		Button scheduleAppointment = new Button("Schedule Appointment");
		Button messageDoctor = new Button("Message Doctor");
		Button viewHistory = new Button("View Medical History");
		Button viewAppointments = new Button("View Upcoming Appointments");
		
		pane.addColumn(1, title, scheduleAppointment, messageDoctor, viewHistory, viewAppointments);
		Scene patientPortalScene = new Scene(pane, 600, 350);
		return patientPortalScene;
	}
	
	
	
}