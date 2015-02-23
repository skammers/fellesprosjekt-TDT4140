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

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //sets the field to their correct value if its an edit. if not it leaves every field empty
    public void setData(Appointment ap){

    }

    //runs when the user presses ok. sets the final values to the appointment object that is being created
    @FXML
    private void handleOk(){
        //code goes here



        //sets okclicked to true and closes the window
        okClicked = true;
        stage.close();
    }

    //closes the window if cancel is clicked
    @FXML
    private void handleCancel(){stage.close();}
    public boolean okClicked(){
        return okClicked;
    }


}
