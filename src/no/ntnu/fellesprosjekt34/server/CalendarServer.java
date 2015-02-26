package no.ntnu.fellesprosjekt34.server;

import no.ntnu.fellesprosjekt34.Room;

import java.sql.SQLException;

public class CalendarServer {

    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://bull.ludvigjordet.com/kalender", "kalender", "unagi");
        try {
            Room strossa = Room.getFromDB(db, "Samfundet", "Strossa");
            System.out.println("Capacity: " + strossa.getCapacity());
            System.out.println("Location: " + strossa.getLocation());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotFoundInDBException e) {
            e.printStackTrace();
        }
    }
}
