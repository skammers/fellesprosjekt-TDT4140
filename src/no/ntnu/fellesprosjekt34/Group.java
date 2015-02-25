package no.ntnu.fellesprosjekt34;

import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by mikail on 25/02/15.
 */


public class Group {

    private StringProperty name;
    private ObservableList<User> users;
    //private Calendar groupCalendar;


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >0){
            this.name.set(name);
        }
        else {
            System.out.println("Feil! Skriv inn et navn");
        }
    }

    public boolean addUser(User user){
        return users.add(user);
    }

    public boolean removeUser(User user){
        return users.remove(user);
    }




}
