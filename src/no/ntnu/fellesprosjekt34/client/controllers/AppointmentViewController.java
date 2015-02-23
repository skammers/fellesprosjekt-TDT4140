package no.ntnu.fellesprosjekt34.client.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import no.ntnu.fellesprosjekt34.Appointment;

/**
 * Created by Eirik on 23.02.2015.
 */
public class AppointmentViewController {

    private Stage stage;
    private boolean okClicked;

    public void setDialogStage(Stage dialogStage) {
        this.stage = dialogStage;
    }

    //sets the field to their correct value.
    public void setData(Appointment ap){

    }

    //runs when the user presses ok. sets the final values to the appointment object that is being created
    @FXML
    private void handleOk(){

    }
    public boolean okClicked(){
        return okClicked;
    }

}
