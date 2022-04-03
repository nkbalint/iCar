package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordLabel;

    @FXML
    private Button registrationButton;

    @FXML
    void clickedLoginButton(ActionEvent event) {

    }

    @FXML
    void clickedRegistrationButton(ActionEvent event) {
        Parent register = null;
        try {
            register = FXMLLoader.load(getClass().getResource("/fxml/Register.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene registerScene = new Scene(register);
        Stage window = new Stage();
        //window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\bejelentkező.jpg")));
        window.setScene(registerScene);
        window.setTitle("Regisztráció");
        //window.getIcons().add(new Image("pontus/Image/logo.jpg"));
        window.show();
    }

}

