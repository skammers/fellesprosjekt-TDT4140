package no.ntnu.fellesprosjekt34.client.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.fellesprosjekt34.Appointment;
import no.ntnu.fellesprosjekt34.User;


/**
 * Created by Eirik on 23.02.2015.
 */
public class AppointmentViewController {

    private Stage stage;
    private boolean okClicked;
    @FXML
    private TextField roomField,titleField,searchField,buildingField;
    @FXML
    private TextArea descriptionField, participantsField;
    // should be of type invitaion when we get that far


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //sets the field to their correct value if its an edit. if not it leaves every field empty
    public void setData(Appointment ap){
        this.roomField.setText(ap.getRoomName());
        this.titleField.setText(ap.getDescription());
        this.buildingField.setText(ap.getBuildingName());
        this.descriptionField.setText(ap.getDescription());
        String str = "";




    }

    //runs when the user presses ok. sets the final values to the appointment object that is being created
    @FXML
    private void handleOk(){
        //code goes here
        if(validData()){


        }


        //sets okclicked to true and closes the window
        okClicked = true;
        stage.close();
    }

    private void addParticipants(ObservableList<User> user){
        //sets up the participants list.
    }
    private boolean validData(){
        String errorMessage = "";


        return true;
    }

    //closes the window if cancel is clicked
    @FXML
    private void handleCancel(){stage.close();}
    public boolean okClicked(){
        return okClicked;
    }


}
