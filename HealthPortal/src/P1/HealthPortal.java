package com.example.healthportal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HealthPortal extends Application {
    private List<User> users; // List to store all users in the system

    @Override
    public void start(Stage stage) throws IOException {
        // Load the main view from FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HealthPortal.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Health Portal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public HealthPortal() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String userID, String password) {
        for (User user : users) {
            if (user.getID().equals(userID) && user.getPassword().equals(password)) {
                return user; // User found, return the user object
            }
        }
        return null; // User not found
    }

    public void signUp(String ID, String name, String password, String email, String userType) {
        User newUser;
        switch (userType) {
            case "Doctor":
                newUser = new Doctor(new ArrayList<>(), new ArrayList<>(), ID, name, password, email);
                break;
            case "Nurse":
                newUser = new Nurse(new ArrayList<>(), new ArrayList<>(), ID, name, password, email);
                break;
            case "Patient":
                newUser = new Patient(ID, name, password, 0.0, 0.0, "", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), email);
                break;
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
        addUser(newUser);
    }
}
