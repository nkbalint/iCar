package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    void clickedLoginButton(ActionEvent event) throws Exception {
        boolean succ=false;
        if (emailLabel.getText().isEmpty() || passwordLabel.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Az e-mail vagy jelszó mező üres!");
            alert.showAndWait();
        }
        List<User> felhasznalok = new ArrayList<>();
        List<Admin> adminok = new ArrayList<>();
        try (UserDAO cDAO = new JpaUserDAO();
             AdminDAO aDAO = new JpaAdminDAO();) {
            felhasznalok = cDAO.getUserAll();
            adminok = aDAO.getAdminsAll();
            for (Admin admin :adminok){
                if(admin.getUserName().equals(emailLabel.getText())&& admin.getPassword().equals(passwordLabel.getText())){//jo admin
                    // invalidLabel.setVisible(false);
                    succ=true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("admin");
                    alert.showAndWait();
                    //activeAdmin = aDAO.getAdminbyID(admin.getId());
                    // AdminDashboardController.getActiveAdmin(activeAdmin);
                    //changeScene(event,"/fxml/AdminDashboard.fxml");
                }
            }//admin
            for (User user : felhasznalok) {
                if (user.getEmail().equals(emailLabel.getText()) && user.getPassword().equals(passwordLabel.getText())) {//jo user
                    //   invalidLabel.setVisible(false);
                    //   activeCustomer = cDAO.getCustomerbyID(customer.getId());
                    //   CustomerDashboardController.getActiveCustomer(activeCustomer);
                    //   changeScene(event,"/fxml/CustomerDashboard.fxml");
                    succ=true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("user");
                    alert.showAndWait();
                }
            }
        }
        if(succ==false) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Hibás e-mail vagy jelszó!");
            alert.showAndWait();
        }
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
        window.setScene(registerScene);
        window.setTitle("Regisztráció");
        window.show();
    }

}

