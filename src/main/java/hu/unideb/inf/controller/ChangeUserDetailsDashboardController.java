package hu.unideb.inf.controller;

import hu.unideb.inf.model.Admin;
import hu.unideb.inf.model.JpaUserDAO;
import hu.unideb.inf.model.User;
import hu.unideb.inf.model.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeUserDetailsDashboardController {

    @FXML
    private Label addressDisplay;

    @FXML
    private TextField addressModify;

    @FXML
    private Label emailDisplay;

    @FXML
    private TextField emailModify;

    @FXML
    private Button modificationButton;

    @FXML
    private Label nameDisplay;

    @FXML
    private Label passwordAgainDisplay;

    @FXML
    private TextField passwordAgainModify;

    @FXML
    private Label passwordDisplay;

    @FXML
    private TextField passwordModify;

    @FXML
    private Label phoneDisplay;

    @FXML
    private TextField telefonnumberModify;

    @FXML
    private TextField usernameModify;

    @FXML
    private  Label usrnameDisplay;

    private static  User activeUser;

    UserDAO cDAO = new JpaUserDAO();

    public static void setActiveUser(User user) {
        activeUser = user;
    }

public void initialize(){

    activeUser=UserDashboardController.active();
        usrnameDisplay.setText(activeUser.getUsername());
        nameDisplay.setText(activeUser.getName());
        emailDisplay.setText(activeUser.getEmail());
        addressDisplay.setText(activeUser.getAdress());
        phoneDisplay.setText(activeUser.getPhone());
        passwordDisplay.setText(activeUser.getPassword());
        passwordAgainDisplay.setText(activeUser.getPassword());
}

    @FXML
    void advanceActionButton(ActionEvent event) throws Exception {
        boolean cont=true;
      String username= activeUser.getUsername();
       String name= activeUser.getName();
       String email =activeUser.getEmail();
        String address=activeUser.getAdress();
        String phone=activeUser.getPhone();
       String password=activeUser.getPassword();

        if(usernameModify.getText().equals("")){
            username=usrnameDisplay.getText();
        } else {
            username=usernameModify.getText();
        }
        if(addressModify.getText().equals("")){
            address=addressDisplay.getText();
        } else {
            address=addressModify.getText();
        }
        if(telefonnumberModify.getText().equals("")){
            phone=phoneDisplay.getText();
        } else {
            phone=telefonnumberModify.getText();
        }
        if(!emailModify.getText().equals("")){
            //System.out.println(emailModify.getText());
            if (!emailModify.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Az e-mail cím helytelen formátumú!");
                alert.showAndWait();
                cont = false;

            } else {
                email=emailModify.getText();
            }
        } else {
            email=emailDisplay.getText();
        }
        if(passwordModify.getText().equals("")){
            password=passwordDisplay.getText();
        } else {
            if (!passwordModify.getText().equals(passwordAgainModify.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "A jelszavak nem egyeznek!");
                alert.showAndWait();
                cont = false;
            }
            if (!passwordModify.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
                alert.showAndWait();
                cont = false;
            }
            if(cont==true){
                password=passwordModify.getText();
            }
        }
        if(cont==true){
            User.modify(activeUser,username, address,phone,password, email);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeresen megváltoztatta az adatait!");
            alert.showAndWait();
            activeUser = cDAO.getUserbyID(activeUser.getId());
            UserDashboardController.getActiveUser(activeUser);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        }

    }
}
