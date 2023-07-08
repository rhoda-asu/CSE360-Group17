package P1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane; //***
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;


public class Doctor extends User{
	private ArrayList<Appointment> schedule;
	private ArrayList<String> patients; //saves patients as strings of their ID's. 
	
	public Doctor() {
		super();
	}
	
	public Doctor(String ID, String name, String password, String email) {
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
	}

	public void setPatients(ArrayList<String> patients) {
		this.patients = patients;
	}
	
	@Override
	public Scene view() {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setHgap(5.5);
		pane.setVgap(1.5);
		
		Label title = new Label("Welcome to the Doctor Portal " + super.getName());
		
		Button viewPatientButton = new Button("View patient");
		Button addHistoryButton = new Button("Create med. history entry");
		Button editPatientButton = new Button("Edit patient");
		Button testPatientButton = new Button("Test patient");
		
		pane.addColumn(1, title, viewPatientButton, addHistoryButton, editPatientButton, testPatientButton);
		Scene doctorPortalScene = new Scene(pane, 600, 350);
		return doctorPortalScene;
	}	
	
}
