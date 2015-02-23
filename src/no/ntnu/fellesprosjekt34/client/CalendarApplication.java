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

import java.io.IOException;

public class CalendarApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/no/ntnu/fellesprosjekt34/client/fxml/CalendarApplication.fxml"));
        primaryStage.setTitle("Calendar");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public boolean showApplicationView(Appointment ap) {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CalendarApplication.class.getResource("/no/ntnu/fellesprosjekt34/client/fxml/AppointmentView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Appointment");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            AppointmentViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setData(ap);



            dialogStage.showAndWait();

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
