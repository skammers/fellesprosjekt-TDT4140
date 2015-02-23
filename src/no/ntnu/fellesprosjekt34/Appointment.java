package no.ntnu.fellesprosjekt34;

import java.time.LocalDateTime;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;


public class Appointment {

	//Variables
	private StringProperty description;
	private StringProperty shortName;
	private ObjectProperty<LocalDateTime> startTime;
	private ObjectProperty<LocalDateTime> endTime;
	
	
	/**
	 * The Constructor takes four arguements, description, shortName, startTime and endTime of the 
	 * appointment.
	 * @param description
	 * @param shortName
	 * @param startTime
	 * @param endTime
	 */
	public Appointment(StringProperty description, StringProperty shortName, ObjectProperty<LocalDateTime> startTime, ObjectProperty<LocalDateTime> endTime){
		
		this.description = description;
		this.shortName = shortName;
		
		if(validateTime(startTime, endTime)){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
	}
	
	
	//Getter and setter for description
	
	/**
	 * 
	 * @return description of the appointment
	 */
	public StringProperty getDescription(){
		return description;
	}
	
	/**
	 * Sets the description for the appointment. 
	 * @param description
	 */
	public void setDescription(StringProperty description){
		this.description = description;
	}
	
	/**
	 * 
	 * @return The shortName for the appointment
	 */
	public StringProperty getShortName() {
		return shortName;
	}


	/**
	 * Sets the shortName for the appointment.
	 * @param shortName
	 */
	public void setShortName(StringProperty shortName) {
		this.shortName = shortName;
	}


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
		
		
		//startTime needs to be before endTime
		if(startTime.getValue().isBefore(endTime.getValue())){
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	

}