package com.example.patientsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DiagnosisController {

    @FXML
    public TextField nameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField jmbgField;
    @FXML
    public TextArea diagnosisField;

    @FXML
    public void handleAddDiagnosisButtonAction(ActionEvent actionEvent) {
    }

    @FXML
    public void handleAddImageAction(ActionEvent actionEvent) {
    }

    @FXML
    public void handleAddPatientButtonAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();

            // Get the stage from the current scene
            Stage stage = (Stage) nameField.getScene().getWindow();

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

    public void handleFindPatientButtonAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
            Parent root = loader.load();

            // Get the stage from the current scene
            Stage stage = (Stage) nameField.getScene().getWindow();

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
    protected void handleSignOutButtonAction(){
        System.out.println("Sign out button clicked!");

        // TODO delete this is just for showcase
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            // Get the stage from the current scene
            Stage stage = (Stage) nameField.getScene().getWindow();

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
}
