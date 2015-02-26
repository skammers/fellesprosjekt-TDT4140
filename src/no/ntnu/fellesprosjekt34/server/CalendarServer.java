package no.ntnu.fellesprosjekt34.server;

import no.ntnu.fellesprosjekt34.Room;
import no.ntnu.fellesprosjekt34.User;

import java.sql.SQLException;

public class CalendarServer {

    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://bull.ludvigjordet.com/kalender", "kalender", "unagi");
        try {
            User strossa = User.getFromDB(db, "ludvig.jordet@gmail.com");
            System.out.println("Capacity: " + strossa.getFirstName());
            System.out.println("Location: " + strossa.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotFoundInDBException e) {
            e.printStackTrace();
        }
    }
}
