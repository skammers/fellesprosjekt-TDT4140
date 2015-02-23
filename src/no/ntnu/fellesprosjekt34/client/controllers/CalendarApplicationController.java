package no.ntnu.fellesprosjekt34.client.controllers;

import javafx.fxml.FXML;
import no.ntnu.fellesprosjekt34.Appointment;
import no.ntnu.fellesprosjekt34.client.CalendarApplication;

/**
 * Created by Eirik on 23.02.2015.
 */
public class CalendarApplicationController {

    //a reference to main.
    private CalendarApplication ca;

    public void setCalendarApplication(CalendarApplication ca){
        this.ca = ca;
    }

    /**
     * Creates a new appointment
     */
    @FXML
    private void handleCreateAppointment(){

        if(ca.showAppointmentView(new Appointment(null, null, null, null, null, null))){
            //do something here if the change happend.

        }
        else{

        }

    }

}
