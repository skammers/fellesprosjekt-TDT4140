package no.ntnu.fellesprosjekt34.client.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import no.ntnu.fellesprosjekt34.Appointment;
import no.ntnu.fellesprosjekt34.User;
import no.ntnu.fellesprosjekt34.client.CalendarApplication;
import org.controlsfx.dialog.Dialogs;
import javafx.scene.control.Button;

/**
 * Created by Eirik on 23.02.2015.
 */
public class CalendarApplicationController {

    //a reference to main.
    private CalendarApplication ca;
    private Button button;





    public void setCalendarApplication(CalendarApplication ca){
        this.ca = ca;
    }

    /**
     * Creates a new appointment
     */
    @FXML
    private void handleCreateAppointment(){

        if(ca.showAppointmentView(new Appointment(,"lol","rofl",""))){
            //do something here if the change happend.
            System.out.println("ok clicked");

        }
        else{
            System.out.println("something went wrong");
            Dialogs.create()
                    .title("FEIL!!")
                    .masthead("DETTA VA FEIL!!")
                    .message("IDIOT!!!")
                    .showError();
        }

    }


}
