package P1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.Popup;
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
	public void view(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.setHgap(5.5);
		pane.setVgap(15);
		
		Label title = new Label("Welcome to the Doctor Portal " + super.getName());
		
		Button viewPatientButton = new Button("View patient");
		Button addHistoryButton = new Button("Create med. history entry");
		Button editPatientButton = new Button("Edit patient");
		Button testPatientButton = new Button("Test patient");

		TextField patientIDField = new TextField();
		
		pane.addColumn(1, title, viewPatientButton, addHistoryButton, editPatientButton, testPatientButton);
		Scene doctorPortalScene = new Scene(pane, 600, 350);
		primaryStage.setScene(doctorPortalScene);
		primaryStage.show();
	}	
	
//	private void viewPatient(Stage primaryStage) {
//		GridPane viewPane = new GridPane();
//		Button searchButton = new Button("Search");
//		Label patientIDLabel = new Label("Patient ID: ");
//	}
	
}
