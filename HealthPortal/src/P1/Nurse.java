package P1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Nurse extends User{
	
	private ArrayList<Appointment> schedule;
	private ArrayList<String> patients;
	
	public Nurse() {
		super();
	}

	public Nurse(String ID, String name, String password, String email) {
		super(ID, name, password, email);
		this.schedule = new ArrayList<Appointment>();
		this.patients = new ArrayList<String>();
	}

	public ArrayList<Appointment> getSchedule() {
		return schedule;
	}

	public ArrayList<String> getPatients() {
		return patients;
	}

	public void setSchedule(ArrayList<Appointment> schedule) {
		this.schedule = schedule;
		Database.getInstance().addNurse(this); // Update the Nurse object in the database
	}

	public void setPatients(ArrayList<String> patients) {
		this.patients = patients;
		Database.getInstance().addNurse(this); // Update the Nurse object in the database
	}
	
	@Override
	public void view(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setHgap(5.5);
		pane.setVgap(15);
		
		Label title = new Label("Welcome to the Nurse Portal " + super.getName());
		
		Button createPatient = new Button("Create Patient");//when patients walk in without signing up
		Button viewPatientButton = new Button("View Patient");
		Button editPatientButton = new Button("Edit Patient");
		Button scheduleAppointmentButton = new Button("Schedule Appointment");
		
		pane.addColumn(1, title, createPatient, viewPatientButton, editPatientButton, scheduleAppointmentButton);
		Scene nursePortalScene = new Scene(pane, 600, 350);
		primaryStage.setScene(nursePortalScene);
		primaryStage.show();
	}
	
}
