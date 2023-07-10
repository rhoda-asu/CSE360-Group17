package P1;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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

public class Nurse extends User{
	
	private ArrayList<Appointment> schedule;
	private ArrayList<String> patients;
	private Stage secondaryStage;
	private Scene nursePortalScene;
	
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
		this.secondaryStage = primaryStage;
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
		this.secondaryStage.setScene(nursePortalScene);
		this.secondaryStage.show();
	}
	
	private User searchPatient(String ID) {
		Database obj = new Database();
		obj.initializeDatabase();
		if(obj.userExists(ID))
			return obj.getUser(ID);
		return null;
	}
	
	private void viewPatient() {
			
			GridPane viewPane = new GridPane();
			viewPane.setAlignment(Pos.CENTER);
			viewPane.setHgap(5.5);
			viewPane.setVgap(15);
			
			Label patientIDLabel = new Label("Patient ID: ");
					
			Button searchButton = new Button("Search");
			Button backButton = new Button ("Back");
			
			TextField patientIDField = new TextField();
			
			TextArea patientArea = new TextArea();
			patientArea.setEditable(false);
			
			viewPane.add(backButton, 0, 0);
			viewPane.add(patientIDLabel, 0, 2);
			viewPane.add(searchButton, 2, 2);
			viewPane.add(patientIDField, 1, 2);
			viewPane.add(patientArea, 1, 3);
			
			Scene patientViewScene = new Scene(viewPane, 600, 350);
			
			this.secondaryStage.setScene(patientViewScene);
			this.secondaryStage.show();
			
			searchButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					patientArea.setText(searchPatient(patientIDField.getText()).toString());
				}
			});
	
			backButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					secondaryStage.setScene(nursePortalScene);
					secondaryStage.show();
				}
			});
			
		}
	
	public void createPatient() {
		GridPane signUpPane = new GridPane();
		signUpPane.setAlignment(Pos.CENTER);
		signUpPane.setHgap(5.5);
		signUpPane.setVgap(15);
		
		Label firstNameLabel = new Label("First name: ");
		Label lastNameLabel = new Label("Last name: ");
		Label emailLabel = new Label("Email: ");
		Label passwordLabel = new Label("Password: ");
		Label rePasswordLabel = new Label("Re-enter password: ");
		Label signUpTitle = new Label("Create Patient");
		
		TextField firstNameTextField = new TextField();
		TextField lastNameTextField = new TextField();
		TextField emailTextField = new TextField();
		TextField passwordTextField = new TextField();
		TextField rePasswordTextField = new TextField();
		
		Button backButton = new Button("Back");
		Button createAccountButton = new Button("Create account");
			
		
		signUpPane.add(backButton, 0, 0);
		signUpPane.add(firstNameLabel, 0, 2);
		signUpPane.add(lastNameLabel, 0, 3);
		signUpPane.add(emailLabel, 0, 4);
		signUpPane.add(passwordLabel, 0, 5);
		signUpPane.add(rePasswordLabel, 0, 6);
		
		signUpPane.add(signUpTitle, 1, 1);
		signUpPane.add(firstNameTextField, 1, 2);
		signUpPane.add(lastNameTextField, 1, 3);
		signUpPane.add(emailTextField, 1, 4);
		signUpPane.add(passwordTextField, 1, 5);
		signUpPane.add(rePasswordTextField, 1, 6);
		signUpPane.add(createAccountButton, 1, 7);
		
		Scene signUpScene = new Scene(signUpPane, 600, 350);
		
		Database userDatabase = new Database();
		userDatabase.initializeDatabase();
		
		createAccountButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if(firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || rePasswordTextField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Information Missing.");
					alert.setContentText("Make sure all fields are complete before pressing the Create Account button.");
					alert.showAndWait();
				}
				else {
					if(passwordTextField.getText().equals(rePasswordTextField.getText())) {
				
						String newID = userDatabase.createUser(0, firstNameTextField.getText() + " " + lastNameTextField.getText(), passwordTextField.getText(), emailTextField.getText());
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Success!");
						alert.setHeaderText("The patient's User ID is : " + newID + "\n\nPlease relay this information to them.");
						alert.showAndWait();
						secondaryStage.setScene(nursePortalScene);
						secondaryStage.show();
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Incorrect, or non-existent user information, please try again.");
						alert.showAndWait();
					}
				}
			}
		});
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				secondaryStage.setScene(nursePortalScene);
				secondaryStage.show();
			}
		});
	}
	
}
