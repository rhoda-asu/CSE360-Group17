package P1;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

public class Main extends Application{

	public void start(Stage primaryStage) {
		
		Database userDatabase = new Database();
		userDatabase.initializeDatabase(); // Initialize the database by loading or saving it from/to the file
		
		GridPane login = new GridPane();
		
		Label IDLabel = new Label("User ID: ");
		Label passLabel = new Label("Password: ");
		Label title = new Label("Welcome to the Health Portal");
		
		TextField IDField = new TextField();
		TextField passField = new TextField();
		
		Button loginButton = new Button("Login");
		Button signUpButton = new Button("Sign Up");
		
		loginButton.setMinSize(200, 50);
		signUpButton.setMinSize(200, 50);
		
		login.setAlignment(Pos.CENTER);
		login.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		login.setHgap(5.5);
		login.setVgap(15);
		
		login.add(IDLabel, 0, 1);
		login.add(passLabel, 0, 2);
		login.addColumn(1, title, IDField, passField, loginButton, signUpButton);
	
		Scene loginScene = new Scene(login, 600, 350);
		
		GridPane signUpPane = new GridPane();
		signUpPane.setAlignment(Pos.CENTER);
		signUpPane.setHgap(5.5);
		signUpPane.setVgap(15);
		
		Label firstNameLabel = new Label("First name: ");
		Label lastNameLabel = new Label("Last name: ");
		Label emailLabel = new Label("Email: ");
		Label passwordLabel = new Label("Password: ");
		Label rePasswordLabel = new Label("Re-enter password: ");
		Label signUpTitle = new Label("Sign up Page");
		
		TextField firstNameTextField = new TextField();
		TextField lastNameTextField = new TextField();
		TextField emailTextField = new TextField();
		TextField passwordTextField = new TextField();
		TextField rePasswordTextField = new TextField();
		
		Button backButton = new Button("Back");
		Button createAccountButton = new Button("Create account");
		
		ComboBox userType = new ComboBox();
		
		userType.getItems().add("Patient");
		userType.getItems().add("Doctor");
		userType.getItems().add("Nurse");
		
		
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
		signUpPane.add(userType, 2, 6);
		signUpPane.add(createAccountButton, 1, 7);
		
		Scene signUpScene = new Scene(signUpPane, 600, 350);
		
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				if(IDField.getText().isEmpty() || passField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText("ID or password missing.");
					alert.setContentText("Make sure all fields are complete before pressing the login button.");
					alert.showAndWait();
				}
				else {
					if(userDatabase.checkPassword(IDField.getText(), passField.getText())) {
						primaryStage.setScene(userDatabase.getUser(IDField.getText()).view());
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
		
		signUpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(signUpScene);
				primaryStage.show();
			}
		});
		
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				primaryStage.setScene(loginScene);
				primaryStage.show();
			}
		});
		
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
						int selectedIndex = userType.getSelectionModel().getSelectedIndex();
						String newID = userDatabase.createUser(selectedIndex, firstNameTextField.getText() + " " + lastNameTextField.getText(), passwordTextField.getText(), emailTextField.getText());
						Alert alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Success!");
						alert.setHeaderText("Your User ID is : " + newID + "\n\nKeep this information in a safe place, as it is needed for login.");
						alert.showAndWait();
						primaryStage.setScene(loginScene);
						primaryStage.show();
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
		
		
		
		primaryStage.setScene(loginScene);
		primaryStage.show();
		
	}
	
	public static void main(String[]args) {
		launch(args);
	}

}
