package no.ntnu.fellesprosjekt34.client;

/**
 * Created by Eirik on 23.02.2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.ntnu.fellesprosjekt34.Appointment;
import no.ntnu.fellesprosjekt34.client.controllers.AppointmentViewController;
import no.ntnu.fellesprosjekt34.client.controllers.CalendarApplicationController;

import java.io.IOException;

public class CalendarApplication extends Application {

    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        //loads the primary stage
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CalendarApplication.class.getResource("/no/ntnu/fellesprosjekt34/client/fxml/CalendarApplication.fxml"));
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(new Scene((AnchorPane) loader.load(), 800, 600));
        primaryStage.show();


        //gives the main controller a reference to main.
        CalendarApplicationController cac = loader.getController();
        cac.setCalendarApplication(this);

    }

    /**
     * Handles the appointment editor from start to finish.
     * @param ap
     * @return
     */
    public boolean showAppointmentView(Appointment ap) {

        try {
            //loads the fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CalendarApplication.class.getResource("/no/ntnu/fellesprosjekt34/client/fxml/AppointmentView.fxml"));


            //creates the stage for the popup
            Stage stage = new Stage();
            stage.setTitle("Appointment");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(primaryStage);
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            stage.setScene(scene);

            //makes a reference to the application controller and sets the datafields.
            AppointmentViewController controller = loader.getController();
            controller.setDialogStage(stage);
            controller.setData(ap);


            //wait for the user to finish in before it continues
            stage.showAndWait();
            return controller.okClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
