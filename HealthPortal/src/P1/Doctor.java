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

        viewPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                viewPatient();
            }
        });
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
}

