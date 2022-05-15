package hu.unideb.inf.controller;
import hu.unideb.inf.model.Car;
import hu.unideb.inf.model.CarDAO;
import hu.unideb.inf.model.JpaCarDAO;
import hu.unideb.inf.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Date;

public class PaymentWidthContractController {


    @FXML
    private Label addressLabel;

    @FXML
    private Label advancePriceLabel;

    @FXML
    private Label brandLabel;

    @FXML
    private Button buyingButton;

    @FXML
    private Label colorLabel;

    @FXML
    private Label crowdLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label fuelLabel;

    @FXML
    private Label gearboxLabel;

    @FXML
    private Label kmLabel;

    @FXML
    private Label lookLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label performanceLabel;

    @FXML
    private Label personLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label rollingLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label yearLabel;

    @FXML
    private Label dateChange;

    @FXML
    private Label dateNow;

    @FXML
    private Label dateSale;

    @FXML
    private CheckBox eula;

    Car selected=UserDashboardController.getSelectedCar();
    User activeUser=UserDashboardController.active();
    CarDAO carDAO = new JpaCarDAO();

    public void initialize(){

        brandLabel.setText(selected.getBrand());
        typeLabel.setText(selected.getType());
        colorLabel.setText(selected.getColour());
        fuelLabel.setText(selected.getFuel());
        personLabel.setText(selected.getPerson());
        kmLabel.setText(String.valueOf(selected.getKm()));
        performanceLabel.setText(String.valueOf(selected.getPerformance()));
        lookLabel.setText(selected.getLook());
        crowdLabel.setText(String.valueOf(selected.getCrowd()));
        gearboxLabel.setText(selected.getGearbox());
        yearLabel.setText(String.valueOf(selected.getYear()));
        rollingLabel.setText(String.valueOf(selected.getRolling()));
        nameLabel.setText(activeUser.getName());
        emailLabel.setText(activeUser.getEmail());
        addressLabel.setText(activeUser.getAdress());
        usernameLabel.setText(activeUser.getUsername());
        Date today = new Date();
        Date sevendays = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 7));
        Date month = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 30));
        dateChange.setText(sevendays.toString());
        dateSale.setText(month.toString());
        dateNow.setText(today.toString());
        priceLabel.setText(String.valueOf(selected.getPrice()) + " Ft");
        advancePriceLabel.setText(String.valueOf(selected.getPrice()/10) +" Ft");


    }

    @FXML
    void clickedBuyingButton(ActionEvent event) {


        if(eula.isSelected()){

            carDAO.buyCar(selected);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Sikeresen leelőlegezte a kiválasztott autót!");
            alert.showAndWait();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

        } else {
                Alert alert = new Alert(Alert.AlertType.WARNING,
                        "Fogadja el a szerződést!");
                alert.showAndWait();
        }

    }

}
