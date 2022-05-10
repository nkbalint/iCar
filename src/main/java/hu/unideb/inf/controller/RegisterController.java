package hu.unideb.inf.controller;

import hu.unideb.inf.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField addressLabel;

    @FXML
    private Button backButton;

    @FXML
    private TextField emailLabel;

    @FXML
    private AnchorPane handleScreen;

    @FXML
    private TextField nameLabel;

    @FXML
    private Label noMatchingPass;

    @FXML
    private Label noValidAddress;

    @FXML
    private Label noValidEmail;

    @FXML
    private Label noValidName;

    @FXML
    private Label noValidPass;

    @FXML
    private Label noValidPhone;

    @FXML
    private Label noValidUsername;

    @FXML
    private TextField passwordAgainLabel;

    @FXML
    private TextField passwordLabel;

    @FXML
    private Button registerButton;

    @FXML
    private TextField telefonnumberLabel;

    @FXML
    private TextField usernameLabel;

    @FXML
    void clickedBackButton(ActionEvent event) {
        Stage stage_Registration_Window = (Stage) handleScreen.getScene().getWindow();
        stage_Registration_Window.close();
        Parent login = null;
        try
        {
            login = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Scene loginScene = new Scene(login);
        Stage window = new Stage();
        window.setScene(loginScene);
        window.setTitle("Bejelentkezes");
        window.show();
    }

    @FXML
    void clickedRegistButton(ActionEvent event) throws Exception {

        boolean cont = true;
        noValidName.setVisible(false);
        noValidUsername.setVisible(false);
        noValidEmail.setVisible(false);
        noValidAddress.setVisible(false);
        noValidPhone.setVisible(false);
        noValidPass.setVisible(false);
        noMatchingPass.setVisible(false);
        if(nameLabel.getText().isEmpty()){
            noValidName.setVisible(true);
            cont = false;
        }
        if(usernameLabel.getText().isEmpty()){
            noValidUsername.setVisible(true);
            cont = false;
        }
        if(addressLabel.getText().isEmpty()){
            noValidAddress.setVisible(true);
            cont = false;
        }
        if(telefonnumberLabel.getText().isEmpty()){
            noValidPhone.setVisible(true);
            cont = false;
        }
        if(!passwordLabel.getText().equals(passwordAgainLabel.getText())){
            noMatchingPass.setVisible(true);
            cont = false;
        }
        if(!emailLabel.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            noValidEmail.setVisible(true);
            cont = false;

        }
        if(!passwordLabel.getText().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
            noValidPass.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
            alert.showAndWait();
            cont = false;
        }

        if(cont==true){
            User.register(nameLabel.getText(), usernameLabel.getText(), addressLabel.getText(),telefonnumberLabel.getText(),passwordLabel.getText(), emailLabel.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeresen regisztrált!");
            alert.showAndWait();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        }
    }


}