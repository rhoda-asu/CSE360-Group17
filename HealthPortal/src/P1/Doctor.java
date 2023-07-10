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


public class Doctor extends User {
    private ArrayList<Appointment> schedule;
    private ArrayList<String> patients; // saves patients as strings of their ID's.
    private Stage secondaryStage;
    private Scene doctorPortalScene;

    public Doctor() {
        super();
    }

    public Doctor(String ID, String name, String password, String email) {
        super(ID, name, password, email);
        this.schedule = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public ArrayList<Appointment> getSchedule() {
        return schedule;
    }

    public ArrayList<String> getPatients() {
        return patients;
    }

    public void setSchedule(ArrayList<Appointment> schedule) {
        this.schedule = schedule;
        Database.getInstance().addDoctor(this); // Update the Doctor object in the database
    }

    public void setPatients(ArrayList<String> patients) {
        this.patients = patients;
        Database.getInstance().addDoctor(this); // Update the Doctor object in the database
    }

    @Override
    public void view(Stage primaryStage) {
        this.secondaryStage = primaryStage;
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.BASELINE_CENTER);
        pane.setHgap(5.5);
        pane.setVgap(15);

        Label title = new Label("Welcome to the Doctor Portal " + super.getName());

        Button viewPatientButton = new Button("View patient");
        Button addHistoryButton = new Button("Create med. history entry");
        Button editPatientButton = new Button("Edit patient");
        Button testPatientButton = new Button("Test patient");

        pane.addColumn(1, title, viewPatientButton, addHistoryButton, editPatientButton, testPatientButton);
        this.doctorPortalScene = new Scene(pane, 600, 350);
        primaryStage.setScene(this.doctorPortalScene);
        primaryStage.show();

        viewPatientButton.setOnAction( e -> viewPatient());
        
        editPatientButton.setOnAction(e -> editPatient());
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

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                User patient = searchPatient(patientIDField.getText());
                if (patient != null) {
                    patientArea.setText(patient.toString());
                } else {
                    patientArea.setText("Patient not found.");
                }
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                secondaryStage.setScene(doctorPortalScene);
                secondaryStage.show();
            }
        });

    }

    private User searchPatient(String ID) {
        return Database.getInstance().getUser(ID);
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
    		editPane.add(searchButton, 0, 2);
    		editPane.add(IDTextField, 1, 2);
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
    				}
    			}
    		});
    		
    		backButton1.setOnAction(new EventHandler<ActionEvent>() {
    			@Override public void handle(ActionEvent e) {
    				secondaryStage.setScene(doctorPortalScene);
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
    
    private void testPatient() {
		GridPane testPane = new GridPane();
		testPane.setAlignment(Pos.CENTER);
		testPane.setHgap(5.5);
		testPane.setVgap(15);
		
		Label typeLabel = new Label("Type of Test: ");
		Label resultsLabel = new Label("Results: ");
		Label observationsLabel = new Label("Observations: ");
		Label IDLabel = new Label("Enter Patient's ID: ");
		Label doctorIDLabel = new Label("Doctor ID");
		
		TextField typeTextField = new TextField();
		typeTextField.setEditable(false);
		TextField resultsTextField = new TextField();
		resultsTextField.setEditable(false);
		TextField observationsTextField = new TextField();
		observationsTextField.setEditable(false);
		TextField IDTextField = new TextField();
		TextField doctorIDTextField = new TextField();
		
		
		Button searchButton = new Button("Search");
		Button backButton1 = new Button("Back");
		Button saveButton = new Button("Save");
		
		testPane.add(backButton1, 0, 0);
		testPane.add(searchButton, 2, 2);
		testPane.add(IDTextField, 1, 2);
		testPane.add(IDLabel, 0, 2);
		testPane.addRow(3, typeLabel, typeTextField);
		testPane.addRow(4, resultsLabel, resultsTextField);    
		testPane.addRow(5, observationsLabel, observationsTextField);
		testPane.addRow(5, doctorIDLabel, doctorIDTextField);
		testPane.add(saveButton, 1, 7);
		
		Scene editScene = new Scene(testPane, 600, 350);
		
		this.secondaryStage.setScene(editScene);
		this.secondaryStage.show();
		
		Database userDatabase = new Database();
		userDatabase.initializeDatabase();
		
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if(typeTextField.getText().isEmpty() || resultsTextField.getText().isEmpty() || observationsTextField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("Information Missing.");
					alert.setContentText("Make sure all fields are complete.");
					alert.showAndWait();
				}
				else{
					Patient p = (Patient)searchPatient(IDTextField.getText());
					TestEntry x = new TestEntry(typeTextField.getText(), doctorIDTextField.getText(), IDTextField.getText(), resultsTextField.getText(), observationsTextField.getText());
					p.getTests().add(x);
				}
			}
		});
		
		backButton1.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				secondaryStage.setScene(doctorPortalScene);
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
					typeTextField.setEditable(true);
					resultsTextField.setEditable(true);		
					observationsTextField.setEditable(true);
				}
				
			}
		});
	}
}

