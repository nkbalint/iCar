package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class UserDashboardController {

    @FXML
    private Button advanceButton;

    @FXML
    private AnchorPane background;

    @FXML
    private TableColumn<?, ?> carBrandColUT;

    @FXML
    private TableColumn<?, ?> carColorColUT;

    @FXML
    private TableColumn<?, ?> carCrowdColUT;

    @FXML
    private TableColumn<?, ?> carFuelColUT;

    @FXML
    private TableColumn<?, ?> carGearboxColUT;

    @FXML
    private TableColumn<?, ?> carIDColUT;

    @FXML
    private TableColumn<?, ?> carKMColUT;

    @FXML
    private TableColumn<?, ?> carLookColUT;

    @FXML
    private TableColumn<?, ?> carPerformanceColUT;

    @FXML
    private TableColumn<?, ?> carPersonColUT;

    @FXML
    private TableColumn<?, ?> carPriceColUT;

    @FXML
    private TableColumn<?, ?> carRollingColUT;

    @FXML
    private TableView<Car> carTableViewUT;

    @FXML
    private TableColumn<?, ?> carTypeColUT;

    @FXML
    private TableColumn<?, ?> carYearColUT;

    @FXML
    private TextField endPriceTextField;

    @FXML
    private Button filterAdminTableButton;

    @FXML
    private ComboBox<?> getColor;

    @FXML
    private ComboBox<?> getFuel;

    @FXML
    private ComboBox<?> getNumOfPerson;

    @FXML
    private ComboBox<?> getType;

    @FXML
    private Label headerNameLabel;

    @FXML
    private Label headerUsernameLabel;

    @FXML
    private Hyperlink logoutLink2;

    @FXML
    private Button refreshCarButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TextField startPriceTextField;

    @FXML
    private Button userdataModificationButton;

    CarDAO carDAO = new JpaCarDAO();

    private static User activeUser;
    public static void getActiveUser(User user) {
        activeUser = user;
    }

    public void initialize() {
        headerUsernameLabel.setText(activeUser.getUsername());
        headerNameLabel.setText(activeUser.getName());
        init_refreshCar();
    }

    void init_refreshCar() {

        List<Car> carList = carDAO.getCarAll();

        carIDColUT.setCellValueFactory(new PropertyValueFactory<>("id"));
        carBrandColUT.setCellValueFactory(new PropertyValueFactory<>("brand"));
        carTypeColUT.setCellValueFactory(new PropertyValueFactory<>("type"));
        carColorColUT.setCellValueFactory(new PropertyValueFactory<>("colour"));
        carFuelColUT.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        carPersonColUT.setCellValueFactory(new PropertyValueFactory<>("person"));
        carKMColUT.setCellValueFactory(new PropertyValueFactory<>("km"));
        carPerformanceColUT.setCellValueFactory(new PropertyValueFactory<>("performance"));
        carLookColUT.setCellValueFactory(new PropertyValueFactory<>("look"));
        carCrowdColUT.setCellValueFactory(new PropertyValueFactory<>("crowd"));
        carGearboxColUT.setCellValueFactory(new PropertyValueFactory<>("gearbox"));
        carYearColUT.setCellValueFactory(new PropertyValueFactory<>("year"));
        carRollingColUT.setCellValueFactory(new PropertyValueFactory<>("rolling"));
        carPriceColUT.setCellValueFactory(new PropertyValueFactory<>("price"));

        carTableViewUT.setItems(FXCollections.observableArrayList(carList));
    }

    @FXML
    void advanceActionButton(ActionEvent event) {

    }

    @FXML
    void clickedFilterButton(ActionEvent event) {

    }

    @FXML
    void clickedLogoutLink(ActionEvent event) {
        Stage stage = (Stage) background.getScene().getWindow();
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
    void clickedRefreshCarButton(ActionEvent event) {

    }

    @FXML
    void clickeduserdataModificationButton(ActionEvent event) throws IOException {
        Parent dashboard = FXMLLoader.load(getClass().getResource("/fxml/ChangeUserDetailsDashboard.fxml"));
        Scene checkout = new Scene(dashboard);
        Stage window = new Stage();
        window.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\iCar_icon.png")));
        window.setScene(checkout);
        window.setTitle("iCar");
        window.show();
    }

    @FXML
    void colorList(ActionEvent event) {

    }

    @FXML
    void listFuel(ActionEvent event) {

    }

    @FXML
    void listNumPerson(ActionEvent event) {

    }

    @FXML
    void typeList(ActionEvent event) {

    }
}
