package com.example.patientsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // TODO Verify user credentials and if correct change scene, else print invalid credentials

        //TODO delete this is just for showcase
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();

            // Get the stage from the current scene
            Stage stage = (Stage) usernameField.getScene().getWindow();

            // Create a new scene with the dashboard content
            Scene scene = new Scene(root);

            // Set the new scene
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: Handle the exception, for example, show an error message to the user
        }
    }

    @FXML
    protected void handleExitButtonAction() {
        System.exit(0);
    }
}

