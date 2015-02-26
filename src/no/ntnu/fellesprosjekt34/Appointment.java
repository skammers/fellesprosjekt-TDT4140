package no.ntnu.fellesprosjekt34;

import java.time.LocalDateTime;
import java.util.Observable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;


public class Appointment {

	//Variables
	private StringProperty description;
	private StringProperty title;
    private StringProperty roomName;
    private StringProperty buildingName;
	private ObjectProperty<LocalDateTime> startTime;
	private ObjectProperty<LocalDateTime> endTime;
    private ObservableList<User> participants;
	
	
	/**
	 * The Constructor takes four arguments, description, shortName, startTime and endTime of the 
	 * appointment.
	 * @param description
	 * @param title
	 * @param startTime
	 * @param endTime
	 */
	public Appointment(ObservableList<User> participants,String roomName, String buildingName, String description, String title, ObjectProperty<LocalDateTime> startTime, ObjectProperty<LocalDateTime> endTime){
		
		this.description = new SimpleStringProperty(description);
		this.title = new SimpleStringProperty(title);
        this.buildingName = new SimpleStringProperty(buildingName);
        this.roomName = new SimpleStringProperty(roomName);
        this.participants = participants;
		
		if(validateTime(startTime, endTime)){
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

    /**
     * Constructor for making an empty appointment
     */
    public Appointment(){
        this(null,null,null,null,null,null,null);
    }
	
	
	//Getter and setter for description
	
	/**
	 * 
	 * @return description of the appointment
	 */
	public String getDescription(){
		return description.getValue();
	}
	
	/**
	 * Sets the description for the appointment. 
	 * @param description
	 */
	public void setDescription(String description){
		this.description.setValue(description);
	}
	
	/**
	 * 
	 * @return The shortName for the appointment
	 */
	public String getTitle() {
		return title.getValue();
	}


	/**
	 * Sets the shortName for the appointment.
	 * @param title
	 */
	public void setTitle(String title) {this.title.set(title);}


    public String getRoomName(){return this.roomName.getValue();}
    public void setRoomName(String roomName){this.roomName.setValue(roomName);}
    public String getBuildingName(){return this.buildingName.getValue();}
    public void setBuildingName(String buildingName){this.buildingName.set(buildingName);}
	/**
	 * 
	 * @return The startTime of the appointment. 
	 */
	public ObjectProperty<LocalDateTime> getStartTime() {
		return startTime;
	}


	/**
	 * Sets the startTime for the appointment, and checks that it is valid.
	 * @param startTime
	 * @return boolean, true if done correctly, false otherwise.
	 */
	public boolean setStartTime(ObjectProperty<LocalDateTime> startTime) {
		
		if(validateTime(startTime, this.endTime)){
			this.startTime = startTime;
			return true;
		}
		return false;
		
	}

    public ObservableList<User> getParticipants(){
        return this.participants;
    }

	/**
	 * 
	 * @return The endTime of the appointment. 
	 */
	public ObjectProperty<LocalDateTime> getEndTime() {
		return endTime;
	}


	/**
	 * Sets the endTime for the appointment, and checks that it is valid. 
	 * @param endTime
	 * @return boolean, true if it is done correctly, false otherwise. 
	 */
	public boolean setEndTime(ObjectProperty<LocalDateTime> endTime) {
		
		if(validateTime(this.startTime, endTime)){
			this.endTime = endTime;
			return true;
		}
		return false;
	}
	

	/**
	 * Validates time. startTime needs to be before endTime. 
	 * @param startTime
	 * @param endTime
	 * @return boolean, true if done correctly, false otherwise. 
	 */
	private boolean validateTime(ObjectProperty<LocalDateTime> startTime, ObjectProperty<LocalDateTime> endTime){
		
		
		//startTime needs to be before endTime unless they both are null
		if((startTime == null && endTime == null) || startTime.getValue().isBefore(endTime.getValue())){
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	

}