package no.ntnu.fellesprosjekt34;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

/**
 * Created by mikail on 25/02/15.
 */


public class Group {

    private StringProperty name;
    private ObservableList<User> users;
    //private Calendar groupCalendar;
    public Group(String name){
        this.name = new SimpleStringProperty();
        this.users = FXCollections.observableArrayList();
    }

    public String getName() {
        return name.getValue();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >0){
            this.name.setValue(name);
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
