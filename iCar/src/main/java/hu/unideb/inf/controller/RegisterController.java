package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private AnchorPane handleScreen;

    @FXML
    private TextField addressLabel;

    @FXML
    private Button backButton;

    @FXML
    private TextField emailLabel;

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField passwordAgainLabel;

    @FXML
    private TextField passwordLabel;

    @FXML
    private Button registerButton;

    @FXML
    private TextField telefonnumberLabel;

    @FXML
    void clickedBackButton(ActionEvent event) {
        Stage stage = (Stage) handleScreen.getScene().getWindow();
        stage.close();
    }

    @FXML
    void clickedRegistButton(ActionEvent event) {

    }

    
}