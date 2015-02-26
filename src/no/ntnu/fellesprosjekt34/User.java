package no.ntnu.fellesprosjekt34;

import no.ntnu.fellesprosjekt34.server.Database;
import no.ntnu.fellesprosjekt34.server.NotFoundInDBException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private static final String QUERY = "SELECT * FROM User WHERE email = \"%s\" LIMIT 1";

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String position;


    public User(String firstName, String lastName, String email, String phoneNumber, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }

    public static User getFromDB(Database db, String email) throws SQLException, NotFoundInDBException{
        ResultSet r = db.Q(String.format(QUERY, email));
        if(r.next()){
            return new User(r.getString("firstName"), r.getString("lastName"), r.getString("email"), r.getString("phoneNumber"), r.getString("position"));
        } else {
            throw new NotFoundInDBException();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }
}
