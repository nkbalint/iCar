package hu.unideb.inf.controller;

import hu.unideb.inf.model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import javafx.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import static javafx.collections.FXCollections.*;

public class UserDashboardController {

    @FXML
    private Button advanceButton;

    @FXML
    private AnchorPane windowPane;

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
    private ComboBox<String> getColor;

    @FXML
    private ComboBox<String> getFuel;

    @FXML
    private ComboBox<String> getNumOfPerson;

    @FXML
    private ComboBox<String> getType;

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

    String type=null;
    String color=null;
    String person=null;
    String fuel=null;

    public static void getActiveUser(User user) {
        activeUser = user;
    }

    public void initialize() {
        headerUsernameLabel.setText(activeUser.getUsername());
        headerNameLabel.setText(activeUser.getName());
        init_refreshCar();
        init_comboBoxes();
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

        carTableViewUT.setItems(observableArrayList(carList));
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


        getType.setItems(observableArrayList(tipus));
        getColor.setItems(observableArrayList(szin));
        getNumOfPerson.setItems(observableArrayList(szemely));
        getFuel.setItems(observableArrayList(uzemanyag));
    }

    @FXML
    void advanceActionButton(ActionEvent event) {
        //ugras eloleg ablakra
    }

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
        carTableViewUT.setItems(FXCollections.observableArrayList(finalfilter));
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
        init_refreshCar();
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
