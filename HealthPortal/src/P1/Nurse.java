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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


public class Nurse extends User {
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

        Button createPatient = new Button("Create Patient");
        Button viewPatientButton = new Button("View Patient");
        Button editPatientButton = new Button("Edit Patient");
        Button scheduleAppointmentButton = new Button("Schedule Appointment");

        pane.addColumn(1, title, createPatient, viewPatientButton, editPatientButton, scheduleAppointmentButton);
        Scene nursePortalScene = new Scene(pane, 600, 350);
        this.secondaryStage.setScene(nursePortalScene);
        this.secondaryStage.show();

        createPatient.setOnAction(e -> createPatient());

        viewPatientButton.setOnAction(e -> viewPatient());
        
        editPatientButton.setOnAction(e -> editPatient());

        scheduleAppointmentButton.setOnAction(e -> scheduleAppointment());
    }

    private User searchPatient(String ID) {
        Database obj = new Database();
        obj.initializeDatabase();
        if (obj.userExists(ID))
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
        Button backButton = new Button("Back");
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

        searchButton.setOnAction(e -> {
            User patient = searchPatient(patientIDField.getText());
            if (patient != null) {
                patientArea.setText(patient.toString());
            } else {
                patientArea.setText("Patient not found.");
            }
        });

        backButton.setOnAction(e -> {
            secondaryStage.setScene(nursePortalScene);
            secondaryStage.show();
        });
    }

    private void scheduleAppointment() {
        GridPane schedulePane = new GridPane();
        schedulePane.setAlignment(Pos.CENTER);
        schedulePane.setHgap(5.5);
        schedulePane.setVgap(15);

        Label patientIDLabel = new Label("Patient ID: ");
        Label dateLabel = new Label("Date: ");
        Label timeLabel = new Label("Time: ");

        Button scheduleButton = new Button("Schedule");
        Button backButton = new Button("Back");

        TextField patientIDField = new TextField();
        TextField dateField = new TextField();
        TextField timeField = new TextField();

        schedulePane.add(backButton, 0, 0);
        schedulePane.add(patientIDLabel, 0, 2);
        schedulePane.add(dateLabel, 0, 3);
        schedulePane.add(timeLabel, 0, 4);
        schedulePane.add(scheduleButton, 2, 5);
        schedulePane.add(patientIDField, 1, 2);
        schedulePane.add(dateField, 1, 3);
        schedulePane.add(timeField, 1, 4);

        Scene scheduleScene = new Scene(schedulePane, 600, 350);

        this.secondaryStage.setScene(scheduleScene);
        this.secondaryStage.show();

        scheduleButton.setOnAction(e -> {
            String patientID = patientIDField.getText();
            String date = dateField.getText();
            String time = timeField.getText();

            // Perform validation and appointment scheduling logic here

            // If the appointment is successfully scheduled
            Appointment appointment = new Appointment("doctorID", patientID, date + " " + time, "Description");
            schedule.add(appointment);
            Database.getInstance().addNurse(this); // Update the Nurse object in the database

            // Show confirmation message or perform any other necessary actions
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointment Scheduled");
            alert.setHeaderText(null);
            alert.setContentText("The appointment has been scheduled.");
            alert.showAndWait();
        });

        backButton.setOnAction(e -> {
            secondaryStage.setScene(nursePortalScene);
            secondaryStage.show();
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
		
		Button backButton1 = new Button("Back");
		Button createAccountButton = new Button("Create account");
			
		
		signUpPane.add(backButton1, 0, 0);
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
		
		this.secondaryStage.setScene(signUpScene);
		this.secondaryStage.show();
		
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
		
		backButton1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				secondaryStage.setScene(nursePortalScene);
				secondaryStage.show();
			}
		});
	}
	
    private void editPatient() {
		GridPane editPane = new GridPane();
		editPane.setAlignment(Pos.CENTER);
		editPane.setHgap(5.5);
		editPane.setVgap(15);
		
		Label firstNameLabel = new Label("First name: ");
		Label lastNameLabel = new Label("Last name: ");
		Label emailLabel = new Label("Email: ");
		Label heightLabel = new Label("Height: ");
		Label weightLabel = new Label("Weight: ");
		Label saveChanges = new Label("Save changes");
		Label IDLabel = new Label("Enter ID: ");
		
		TextField firstNameTextField = new TextField();
		firstNameTextField.setEditable(false);
		TextField lastNameTextField = new TextField();
		lastNameTextField.setEditable(false);
		TextField emailTextField = new TextField();
		emailTextField.setEditable(false);
		TextField heightTextField = new TextField();
		heightTextField.setEditable(false);
		TextField weightTextField = new TextField();
		weightTextField.setEditable(false);
		TextField IDTextField = new TextField();
		
		Button searchButton = new Button("Search");
		Button backButton1 = new Button("Back");
		Button saveButton = new Button("Save");
		
		editPane.add(backButton1, 0, 0);
		editPane.add(searchButton, 2, 2);
		editPane.add(IDLabel, 0, 2);
		editPane.add(IDTextField, 1, 2);
		editPane.addRow(2, IDLabel, IDTextField, searchButton);
		editPane.addRow(3, firstNameLabel, firstNameTextField);
		editPane.addRow(4, lastNameLabel, lastNameTextField);    
		editPane.addRow(5, emailLabel, emailTextField);
		editPane.addRow(6, heightLabel, heightTextField);
		editPane.addRow(7, weightLabel, weightTextField);
		editPane.add(saveButton, 1, 9);
		
		Scene editScene = new Scene(editPane, 600, 350);
		
		this.secondaryStage.setScene(editScene);
		this.secondaryStage.show();
		
		Database userDatabase = new Database();
		userDatabase.initializeDatabase();
		
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if(firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Information Missing.");
					alert.setContentText("Make sure all fields are complete.");
					alert.showAndWait();
				}
				else{
					Patient p = (Patient)searchPatient(IDTextField.getText());
					p.setName(firstNameTextField.getText() + lastNameTextField.getText());
					p.setEmail(emailTextField.getText());
					p.setHeight(Double.parseDouble(heightTextField.getText()));
					p.setWeight(Double.parseDouble(weightTextField.getText()));
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Success!");
					alert.setHeaderText("User successfuly edited.");
					alert.showAndWait();
				}
			}
		});
		
		backButton1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				secondaryStage.setScene(nursePortalScene);
				secondaryStage.show();
			}
		});
		
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Patient p = (Patient)searchPatient(IDTextField.getText());
				if(p.equals(null)) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("User not found.");
					alert.setContentText("A user with the patient ID entered couldn't be found.");
					alert.showAndWait();
				}
				else {
					firstNameTextField.setText(p.getName());
					firstNameTextField.setEditable(true);
					lastNameTextField.setText(p.getName());
					lastNameTextField.setEditable(true);
					emailTextField.setText(p.getEmail());		
					emailTextField.setEditable(true);
					weightTextField.setText(String.valueOf(p.getWeight()));		
					weightTextField.setEditable(true);
					heightTextField.setText(String.valueOf(p.getHeight()));		
					heightTextField.setEditable(true);
				}
				
			}
		});
	}
	
}
