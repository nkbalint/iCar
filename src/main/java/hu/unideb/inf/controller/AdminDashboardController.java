package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboardController {

    private static Admin activeAdmin;

    AdminDAO adminDAO = new JpaAdminDAO();
    CarDAO carDAO = new JpaCarDAO();
    UserDAO userDAO = new JpaUserDAO();

    @FXML
    private TextField addBrandTextField;

    @FXML
    private Button addCarButton;

    @FXML
    private TextField addColorTextField;

    @FXML
    private TextField addCrowdTextField;

    @FXML
    private TextField addFuelTextField;

    @FXML
    private TextField addGearboxTextField;

    @FXML
    private TextField addKMTextField;

    @FXML
    private TextField addLookTextField;

    @FXML
    private TextField addPerformanceTextField;

    @FXML
    private TextField addPersonTextField;

    @FXML
    private TextField addPriceTextField;

    @FXML
    private TextField addRollingTextField;

    @FXML
    private TextField addTypeTextField;

    @FXML
    private TextField addYearTextField;

    @FXML
    private Button additionAdminButton;

    @FXML
    private Button additionUserButton;

    @FXML
    private Label addressErrorLabel1;

    @FXML
    private Label addressErrorLabel2;

    @FXML
    private TextField addressTextLabel1;

    @FXML
    private TextField addressTextLabel2;

    @FXML
    private TableColumn<?, ?> adminAddressCol;

    @FXML
    private TableColumn<?, ?> adminEmailCol;

    @FXML
    private TableColumn<?, ?> adminIDCol;

    @FXML
    private TableColumn<?, ?> adminNameCol;

    @FXML
    private TableColumn<?, ?> adminPasswordCol;

    @FXML
    private TableColumn<?, ?> adminPhoneCol;

    @FXML
    private TableView<Admin> adminTableView;

    @FXML
    private TableColumn<?, ?> adminUsernameCol;

    @FXML
    private TableColumn<?, ?> carBrandCol;

    @FXML
    private TableColumn<?, ?> carColorCol;

    @FXML
    private TableColumn<?, ?> carCrowdCol;

    @FXML
    private TableColumn<?, ?> carFuelCol;

    @FXML
    private TableColumn<?, ?> carGearboxCol;

    @FXML
    private TableColumn<?, ?> carIDCol;

    @FXML
    private TableColumn<?, ?> carKMCol;

    @FXML
    private TableColumn<?, ?> carLookCol;

    @FXML
    private TableColumn<?, ?> carPerformanceCol;

    @FXML
    private TableColumn<?, ?> carPersonCol;

    @FXML
    private TableColumn<?, ?> carPriceCol;

    @FXML
    private TableColumn<?, ?> carRollingCol;

    @FXML
    private TableView<Car> carTableView;

    @FXML
    private TableColumn<?, ?> carTypeCol;

    @FXML
    private TableColumn<?, ?> carYearCol;

    @FXML
    private Button deleteAdminButton;

    @FXML
    private Button deleteCarButton;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Label emailErrorLabel1;

    @FXML
    private Label emailErrorLabel2;

    @FXML
    private TextField emailTextLabel1;

    @FXML
    private TextField emailTextLabel2;

    @FXML
    private TextField endPriceTextField;

    @FXML
    private Label headerNameLabel;

    @FXML
    private Label headerUsernameLabel;

    @FXML
    private Label nameErrorLabel1;

    @FXML
    private Label nameErrorLabel2;

    @FXML
    private TextField nameTextLabel1;

    @FXML
    private TextField nameTextLabel2;

    @FXML
    private Label passwordErrorLabel1;

    @FXML
    private Label passwordErrorLabel2;

    @FXML
    private TextField passwordTextLabel1;

    @FXML
    private TextField passwordTextLabel2;

    @FXML
    private Label phoneErrorLabel1;

    @FXML
    private Label phoneErrorLabel2;

    @FXML
    private TextField phoneTextLabel1;

    @FXML
    private TextField phoneTextLabel2;

    @FXML
    private Button refreshAdminButton;

    @FXML
    private Button refreshCarButton;

    @FXML
    private Button refreshUserButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField startPriceTextField;

    @FXML
    private AnchorPane tabAnchPane1;

    @FXML
    private AnchorPane tabAnchPane2;

    @FXML
    private AnchorPane tabAnchPane3;

    @FXML
    private TabPane tableBackground;

    @FXML
    private TableColumn<?, ?> userAddressCol;

    @FXML
    private TableColumn<?, ?> userEmailCol;

    @FXML
    private TableColumn<?, ?> userIDCol;

    @FXML
    private TableColumn<?, ?> userNameCol;

    @FXML
    private TableColumn<?, ?> userPasswordCol;

    @FXML
    private TableColumn<?, ?> userPhoneCol;

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<?, ?> userUsernameCol;

    @FXML
    private Label usernameErrorLabel1;

    @FXML
    private Label usernameErrorLabel2;

    @FXML
    private TextField usernameTextLabel1;

    @FXML
    private TextField usernameTextLabel2;

    @FXML
    private AnchorPane windowPane;

    @FXML
    private Hyperlink logoutLink;

    public static void getActiveAdmin(Admin admin) {
        activeAdmin = admin;
    }

    public void initialize(){
        headerUsernameLabel.setText(activeAdmin.getUserName());
        headerNameLabel.setText(activeAdmin.getName());
        init_refreshCar();
        init_refreshUser();
        init_refreshAdmin();
    }

    // Admin tábla kezdetleges betöltése
    private void init_refreshAdmin() {
        List<Admin> adminList = adminDAO.getAdminsAll();

        adminIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        adminNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        adminUsernameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        adminAddressCol.setCellValueFactory(new PropertyValueFactory<>("adress"));
        adminPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        adminPasswordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        adminEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        adminTableView.setItems(FXCollections.observableArrayList(adminList));
    }

    // User tábla kezdetleges betöltése
    private void init_refreshUser() {
        List<User> userList = userDAO.getUserAll();

        userIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        userUsernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        userAddressCol.setCellValueFactory(new PropertyValueFactory<>("adress"));
        userPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        userPasswordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        userEmailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        userTableView.setItems(FXCollections.observableArrayList(userList));
    }

    // Car tábla kezdetleges betöltése
    void init_refreshCar() {
        List<Car> carList = carDAO.getCarAll();

        carIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        carBrandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));
        carTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        carColorCol.setCellValueFactory(new PropertyValueFactory<>("colour"));
        carFuelCol.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        carPersonCol.setCellValueFactory(new PropertyValueFactory<>("person"));
        carKMCol.setCellValueFactory(new PropertyValueFactory<>("km"));
        carPerformanceCol.setCellValueFactory(new PropertyValueFactory<>("performance"));
        carLookCol.setCellValueFactory(new PropertyValueFactory<>("look"));
        carCrowdCol.setCellValueFactory(new PropertyValueFactory<>("crowd"));
        carGearboxCol.setCellValueFactory(new PropertyValueFactory<>("gearbox"));
        carYearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        carRollingCol.setCellValueFactory(new PropertyValueFactory<>("rolling"));
        carPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        carTableView.setItems(FXCollections.observableArrayList(carList));
    }

    @FXML
    void clickedAddAdminButton(ActionEvent event) throws Exception {
        boolean cont = true;
        nameErrorLabel2.setVisible(false);
        usernameErrorLabel2.setVisible(false);
        emailErrorLabel2.setVisible(false);
        addressErrorLabel2.setVisible(false);
        phoneErrorLabel2.setVisible(false);
        passwordErrorLabel2.setVisible(false);

        if(nameTextLabel2.getText().isEmpty()){
            nameErrorLabel2.setVisible(true);
            cont = false;
        }

        List<Admin> adminok = new ArrayList<>();

        try (AdminDAO aDAO = new JpaAdminDAO()) {
            adminok = aDAO.getAdminsAll();
            for (Admin admin : adminok) {
                if (admin.getUserName().equals(usernameTextLabel2.getText()) ) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Ez a felhasználónév foglalt!");
                    alert.showAndWait();
                    cont = false;
                }
            }
        }

        if(usernameTextLabel2.getText().isEmpty()){
            usernameErrorLabel2.setVisible(true);
            cont = false;
        }
        if(addressTextLabel2.getText().isEmpty()){
            addressErrorLabel2.setVisible(true);
            cont = false;
        }
        if(phoneTextLabel2.getText().isEmpty()){
            phoneErrorLabel2.setVisible(true);
            cont = false;
        }
        if(!emailTextLabel2.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            emailTextLabel2.setVisible(true);
            cont = false;
        }
        if(!passwordTextLabel2.getText().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
            passwordErrorLabel2.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
            alert.showAndWait();
            cont = false;
        }
        if(cont==true) {
            Admin.register(nameTextLabel2.getText(), usernameTextLabel2.getText(), addressTextLabel2.getText(), phoneTextLabel2.getText(), passwordTextLabel2.getText(), emailTextLabel2.getText());
            init_refreshAdmin();
        }
    }

    @FXML
    void clickedAddCarButton(ActionEvent event) {

    }

    @FXML
    void clickedAddUserButton(ActionEvent event) throws Exception {
        boolean cont2 = true;
        nameErrorLabel1.setVisible(false);
        usernameErrorLabel1.setVisible(false);
        emailErrorLabel1.setVisible(false);
        addressErrorLabel1.setVisible(false);
        phoneErrorLabel1.setVisible(false);
        passwordErrorLabel1.setVisible(false);
        if(nameTextLabel1.getText().isEmpty()){
            nameErrorLabel1.setVisible(true);
            cont2 = false;
        }

        List<User> felhasznalok = new ArrayList<>();

        try (UserDAO cDAO = new JpaUserDAO()) {
            felhasznalok = cDAO.getUserAll();
            for (User user : felhasznalok) {
                if (user.getUsername().equals(usernameTextLabel1.getText()) ) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Ez a felhasználónév foglalt!");
                    alert.showAndWait();
                    cont2 = false;
                }
            }
        }


        if(usernameTextLabel1.getText().isEmpty()){
            usernameErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if(addressTextLabel1.getText().isEmpty()){
            addressErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if(phoneTextLabel1.getText().isEmpty()){
            phoneErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if(!emailTextLabel1.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            emailTextLabel1.setVisible(true);
            cont2 = false;
        }
        if(!passwordTextLabel1.getText().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
            passwordErrorLabel1.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
            alert.showAndWait();
            cont2 = false;
        }
        if(cont2==true) {
            // System.out.println("regi");
            User.register(nameTextLabel1.getText(), usernameTextLabel1.getText(), addressTextLabel1.getText(), phoneTextLabel1.getText(), passwordTextLabel1.getText(), emailTextLabel1.getText());
            init_refreshUser();
        }
    }

    @FXML
    void clickedDeleteAdminButton(ActionEvent event) {
        Admin admin = adminTableView.getSelectionModel().getSelectedItem();
        adminTableView.getItems().remove(admin);
        adminDAO.deleteAdmin(admin);
    }

    @FXML
    void clickedDeleteCarButton(ActionEvent event) {
    }

    @FXML
    void clickedDeleteUserButton(ActionEvent event) {
        User user = userTableView.getSelectionModel().getSelectedItem();
        userTableView.getItems().remove(user);
        userDAO.deleteUser(user);
    }

    @FXML
    void clickedLogoutLink(ActionEvent event) {
        Stage stage = (Stage) windowPane.getScene().getWindow();
        stage.close();
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
    void clickedRefreshAdminButton(ActionEvent event) {
    init_refreshAdmin();
    }

    @FXML
    void clickedRefreshCarButton(ActionEvent event) {
    init_refreshCar();
    }

    @FXML
    void clickedRefreshUserButton(ActionEvent event) {
    init_refreshUser();
    }
}
