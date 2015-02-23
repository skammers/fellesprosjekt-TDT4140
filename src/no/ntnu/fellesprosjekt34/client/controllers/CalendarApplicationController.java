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

        if(ca.showAppointmentView(new Appointment())){
            //do something here if the change happend.
            System.out.println("ok clicked");

        }
        else{
            System.out.println("something went wrong");

        }

    }

}
