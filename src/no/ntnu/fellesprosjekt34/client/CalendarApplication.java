package no.ntnu.fellesprosjekt34.client;

/**
 * Created by Eirik on 23.02.2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/no/ntnu/fellesprosjekt34/client/fxml/CalendarApplication.fxml"));
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
