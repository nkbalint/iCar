package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Button filter;

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

    @FXML
    private Label carerror;

    @FXML
    private ComboBox<String> getType;

    @FXML
    private ComboBox<String> getColor;

    @FXML
    private ComboBox<String> getFuel;

    @FXML
    private ComboBox<String> getNumOfPerson;


    String type=null;
    String color=null;
    String person=null;
    String fuel=null;
    //-----------------------------//

    public static void getActiveAdmin(Admin admin) {
        activeAdmin = admin;
    }

    public void initialize() {
        headerUsernameLabel.setText(activeAdmin.getUserName());
        headerNameLabel.setText(activeAdmin.getName());
        init_refreshCar();
        init_refreshUser();
        init_refreshAdmin();
        init_comboBoxes();
    }

    private void init_comboBoxes() {
        List<Car> carList = carDAO.getCarAll();
        HashSet<String> tipus = new HashSet<>();
        HashSet<String> szin = new HashSet<>();
        HashSet<String> szemely = new HashSet<>();
        HashSet<String> uzemanyag = new HashSet<>();
        tipus.add("");
        szin.add("");
        szemely.add("");
        uzemanyag.add("");
            for (Car car : carList) {
                tipus.add(car.getType());
                szin.add(car.getColour());
                szemely.add(car.getPerson());
                uzemanyag.add(car.getFuel());
                }


            getType.setItems(FXCollections.observableArrayList(tipus));
            getColor.setItems(FXCollections.observableArrayList(szin));
            getNumOfPerson.setItems(FXCollections.observableArrayList(szemely));
            getFuel.setItems(FXCollections.observableArrayList(uzemanyag));
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

        if (nameTextLabel2.getText().isEmpty()) {
            nameErrorLabel2.setVisible(true);
            cont = false;
        }

        List<Admin> adminok = new ArrayList<>();

        try (AdminDAO aDAO = new JpaAdminDAO()) {
            adminok = aDAO.getAdminsAll();
            for (Admin admin : adminok) {
                if (admin.getUserName().equals(usernameTextLabel2.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Ez a felhasználónév foglalt!");
                    alert.showAndWait();
                    cont = false;
                }
            }
        }
        if (usernameTextLabel2.getText().isEmpty()) {
            usernameErrorLabel2.setVisible(true);
            cont = false;
        }
        if (addressTextLabel2.getText().isEmpty()) {
            addressErrorLabel2.setVisible(true);
            cont = false;
        }
        if (phoneTextLabel2.getText().isEmpty()) {
            phoneErrorLabel2.setVisible(true);
            cont = false;
        }
        if (!emailTextLabel2.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            emailTextLabel2.setVisible(true);
            cont = false;
        }
        if (!passwordTextLabel2.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            passwordErrorLabel2.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
            alert.showAndWait();
            cont = false;
        }
        if (cont == true) {
            Admin.register(nameTextLabel2.getText(), usernameTextLabel2.getText(), addressTextLabel2.getText(), phoneTextLabel2.getText(), passwordTextLabel2.getText(), emailTextLabel2.getText());
            init_refreshAdmin();
        }
    }

    @FXML
    void clickedAddCarButton(ActionEvent event) throws Exception {
        carerror.setVisible(false);
        boolean cont3 = true;

        if (addBrandTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addColorTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addTypeTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }

        if (addPerformanceTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addPersonTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addKMTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addLookTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addYearTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addCrowdTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addFuelTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addPriceTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addGearboxTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }
        if (addRollingTextField.getText().isEmpty()) {
            carerror.setVisible(true);
            cont3 = false;
        }

        if (cont3 == true) {
            // tring brand, String type, int year, String fuel, int km, String look, String person, int crowd, int rolling, int performance, String gearbox, String colour, int price
            Car.addcar(addBrandTextField.getText(), addTypeTextField.getText(), Integer.parseInt(addYearTextField.getText()), addFuelTextField.getText(), Integer.parseInt(addKMTextField.getText()), addLookTextField.getText(), addPersonTextField.getText(), Integer.parseInt(addCrowdTextField.getText()), Integer.parseInt(addRollingTextField.getText()), Integer.parseInt(addPerformanceTextField.getText()), addGearboxTextField.getText(), addColorTextField.getText(), Integer.parseInt(addPriceTextField.getText()));
        }
        init_refreshCar();

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
        if (nameTextLabel1.getText().isEmpty()) {
            nameErrorLabel1.setVisible(true);
            cont2 = false;
        }

        List<User> felhasznalok = new ArrayList<>();

        try (UserDAO cDAO = new JpaUserDAO()) {
            felhasznalok = cDAO.getUserAll();
            for (User user : felhasznalok) {
                if (user.getUsername().equals(usernameTextLabel1.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Ez a felhasználónév foglalt!");
                    alert.showAndWait();
                    cont2 = false;
                }
            }
        }


        if (usernameTextLabel1.getText().isEmpty()) {
            usernameErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if (addressTextLabel1.getText().isEmpty()) {
            addressErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if (phoneTextLabel1.getText().isEmpty()) {
            phoneErrorLabel1.setVisible(true);
            cont2 = false;
        }
        if (!emailTextLabel1.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            emailTextLabel1.setVisible(true);
            cont2 = false;
        }
        if (!passwordTextLabel1.getText().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            passwordErrorLabel1.setVisible(true);
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "A jelszónak tartalmaznia kell legalább egy kisbetűt, nagybetűt, számot, speciális karaktert, valamint 8 és 20 karakter közötti hosszúságúnak kell lennie!");
            alert.showAndWait();
            cont2 = false;
        }
        if (cont2 == true) {
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

        Car car = carTableView.getSelectionModel().getSelectedItem();
        carTableView.getItems().remove(car);
        carDAO.deleteCar(car);

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
        try {
            login = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        } catch (IOException e) {
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


///szuresek


    @FXML
    void clickedFilterButton(ActionEvent event) {

        List<Car> finalfilter=null;
        finalfilter=carDAO.getCarAll();

        if(startPriceTextField.getText()!=""){
            List<Car> lowerfilter=carDAO.getCarByLowerPrice(startPriceTextField.getText());
            finalfilter.retainAll(lowerfilter);
         //   System.out.println("also");
        }
        if(endPriceTextField.getText()!=""){
            List<Car> upperfilter=carDAO.getCarByUpperPrice(endPriceTextField.getText());
            finalfilter.retainAll(upperfilter);
          //  System.out.println("felso");

        }
        if(searchTextField.getText()!=""){
            List<Car> namefilter = carDAO.getCarByBrand(searchTextField.getText());
            finalfilter.retainAll(namefilter);
         //   System.out.println("kereses");

        }
       // type=getType.getValue();
        if(type!=null && type!=""){
            List<Car> tipuszuro=carDAO.getCarByType(type);
            finalfilter.retainAll(tipuszuro);
         //   System.out.println("tipus "+type);

        }
       // color=getColor.getValue();
        if(color!=null && color!=""){
            List<Car> szinszuro=carDAO.getCarByColor(color);
            finalfilter.retainAll(szinszuro);
          //  System.out.println("szin"+color);

        } if(person!=null && person!=""){
            List<Car> szamszuro=carDAO.getCarByPerson(person);
            finalfilter.retainAll(szamszuro);
          //  System.out.println("szemelyes"+person);

        } if(fuel!=null && fuel!=""){
        List<Car> uzemanyagszuro  = carDAO.getCarByFuel(fuel);
        finalfilter.retainAll(uzemanyagszuro);
           // System.out.println("motor"+fuel);
        }


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
        carTableView.setItems(FXCollections.observableArrayList(finalfilter));
        //init_comboBoxes();
    }

    @FXML
    void colorList(ActionEvent event) {
        color = getColor.getValue();
    }

    @FXML
    void listFuel(ActionEvent event) {
        fuel = getFuel.getValue();
    }

    @FXML
    void listNumPerson(ActionEvent event) {
        person = getNumOfPerson.getValue();
    }

    @FXML
    void typeList(ActionEvent event) {
       type = getType.getValue();
    }
}