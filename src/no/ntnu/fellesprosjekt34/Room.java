package no.ntnu.fellesprosjekt34;

public class Room {
	
	private String location;
	private String name;
	private String building;
	
	/**
	 * Constructor for Room, takes three arguments: the location, name and building of the room
	 */
	public Room (String location, String name, String building) {
		this.location = location;
		this.name = name;
		this.building = building;
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
}
