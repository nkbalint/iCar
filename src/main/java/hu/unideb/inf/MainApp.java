package hu.unideb.inf;

import hu.unideb.inf.model.Car;
import hu.unideb.inf.model.CarDAO;
import hu.unideb.inf.model.JpaCarDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.h2.tools.Server;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/login.fxml"));
        stage.getIcons().add(new Image(new FileInputStream("src\\main\\resources\\Képek\\iCar_icon.png")));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Bejelentkezés");
        stage.setScene(scene);
        stage.show();

    }




    public static void main(String[] args )throws SQLException {

        startDatabase();

        try (CarDAO carDAO = new JpaCarDAO()) {
            //handleData(carDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
        stopDatabase();


    }

    private static final Server s = new Server();

    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }
}
