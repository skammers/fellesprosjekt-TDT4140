package no.ntnu.fellesprosjekt34.client.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.ntnu.fellesprosjekt34.Appointment;
import no.ntnu.fellesprosjekt34.User;
import org.controlsfx.dialog.Dialogs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * Created by Eirik on 23.02.2015.
 */
public class AppointmentViewController {
    private String errorMessage = "";
    private Appointment ap;
    private Stage stage;
    private boolean okClicked;
    @FXML
    private TextField roomField,titleField,searchField,buildingField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private DatePicker startDate, endDate;
    @FXML
    private ComboBox startTime, endTime;









    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //sets the field to their correct value if its an edit. if not it leaves every field empty
    public void setData(Appointment ap){
        this.ap = ap;
        this.roomField.setText(ap.getRoomName());
        this.titleField.setText(ap.getDescription());
        this.buildingField.setText(ap.getBuildingName());
        this.descriptionArea.setText(ap.getDescription());
        setLocalDates(ap.getStartTime().getValue(), ap.getEndTime().getValue());
        setLocalTimes(ap.getStartTime().getValue(), ap.getEndTime().getValue());
       // System.out.println(ap.getStartTime().getValue().toLocalTime().toString());





    }

    /**
     * Converts from localdatetime to localdate even if the localdatetime obejct is null.
     * @param start
     * @param end
     */
    private void setLocalDates(LocalDateTime start,LocalDateTime end){
        if(start == null){this.startDate.setValue(null);}
        else{this.startDate.setValue(start.toLocalDate());}
        if(end == null){this.endDate.setValue(null);}
        else{this.endDate.setValue(end.toLocalDate());}

    }
    private void setLocalTimes(LocalDateTime start,LocalDateTime end){
        if(start == null){this.startTime.setValue(null);}
        else{this.startTime.setValue(start.toLocalTime());}
        if(end == null){this.endTime.setValue(null);}
        else{this.endTime.setValue(end.toLocalTime());}

    }

    /**
     * converts back to LocalDateTime before saving
     * @param ld
     * @param time
     * @return
     */
    private LocalDateTime toLocalDateTime(LocalDate ld, String time){


            String[] split = time.split(":");
            LocalDateTime ldt = LocalDateTime.of(ld, LocalTime.of(Integer.parseInt(split[0]),Integer.parseInt(split[1])));

            return ldt;

    }

    //runs when the user presses ok. sets the final values to the appointment object that is being created

    /**
     * set all the appointment fields to their correct value after validating them.
     */
    @FXML
    private void handleOk(){
        //code goes here
        if(validData()){
            ap.setBuildingName(buildingField.getText());
            ap.setDescription(descriptionArea.getText());
            ap.setStartTime(toLocalDateTime(this.startDate.getValue(),(String) this.startTime.getValue()));
            ap.setEndTime((toLocalDateTime(this.endDate.getValue(),(String) this.endTime.getValue())));
            ap.setTitle(this.titleField.getText());
            ap.setRoomName(roomField.getText());

            //sets okclicked to true and closes the window
            okClicked = true;
            stage.close();
        }
        else{
            Dialogs.create()
                    .title("Ugyldige felt").masthead("Følgende ting på fikses")
                    .message(errorMessage)
                    .showError();
        }





    }

    private void addParticipants(ObservableList<User> user){
        //sets up the participants list.
    }

    /**
     * Validates all the data before saving
     * @return
     */
    private boolean validData(){
        errorMessage = "";
        if(this.startTime.getValue() == null){
            errorMessage += "Ikke satt start tid \n";
        }
        if(this.endTime.getValue() == null){
            errorMessage += "Ikke satt slutt tid \n";
        }
        if(this.buildingField.getText() == null){
            errorMessage += "Ikke satt byggning \n";
        }
        if(this.roomField.getText() == null){
            errorMessage += "Ikke satt rom \n";
        }
        if(this.startDate.getValue() == null){
            errorMessage += "Ikke satt start dato\n";
        }
        if(this.endDate.getValue() == null){
            errorMessage += "ikke satt slutt dato\n";
        }
        if(errorMessage.length() > 0){
            return false;
        }


        return true;
    }


    /*
       private boolean validateTime(ObjectProperty<LocalDateTime> startTime, ObjectProperty<LocalDateTime> endTime){


           //startTime needs to be before endTime unless they both are null
         if((startTime == null && endTime == null) ||
                   LocalDateTime.of(this.startDate.getValue(),this.startTime.getValue())
                           .isBefore(LocalDateTime.of(this.endDate,this.endDate));){
               return true;

           }

           return false;
       }
   */
    //closes the window if cancel is clicked

    @FXML
    private void handleCancel(){stage.close();}
    public boolean okClicked(){
        return okClicked;
    }


}
