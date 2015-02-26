package no.ntnu.fellesprosjekt34;

import no.ntnu.fellesprosjekt34.server.Database;
import no.ntnu.fellesprosjekt34.server.NotFoundInDBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Room {
	
	private String location;
	private String name;
	private String building;
    private int capacity;
    private static final String QUERY = "SELECT * FROM Room WHERE roomName = \"%s\" AND buildingName = \"%s\" LIMIT 1";
	
	/**
	 * Constructor for Room, takes three arguments: the location, name and building of the room
	 */
	public Room (String location, String name, String building, int capacity) {
		this.location = location;
		this.name = name;
		this.building = building;
        this.capacity = capacity;
	}

    public static Room getFromDB(Database db, String building, String name) throws SQLException, NotFoundInDBException{
        ResultSet r = db.Q(String.format(QUERY, name, building));
        if(r.next()){
            return new Room(r.getString("location"), r.getString("roomName"), r.getString("buildingName"), r.getInt("capacity"));
        } else {
            throw new NotFoundInDBException();
        }
    }

	/**
	 * Method returns the location of the Room-object
	 */
	
	public String getLocation() {
		return location;
	}
	
	/**
	 * Method returns the name of the Room-object
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Method returns the name of the building of the Room-object
	 */
	
	public String getBuilding() {
		return building;
	}

    /**
     * Returns the capacity of the room in number of people
     * @return An int representing the number of people the room takes
     */
    public int getCapacity() { return capacity; }
}
