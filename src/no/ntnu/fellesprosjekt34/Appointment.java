package no.ntnu.fellesprosjekt34;

import java.time.LocalDateTime;


public class Appointment {

	//Variables
	private String description;
	private String shortName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	
	/**
	 * The Constructor takes four arguements, description, shortName, startTime and endTime of the 
	 * appointment.
	 * @param description
	 * @param shortName
	 * @param startTime
	 * @param endTime
	 */
	public Appointment(String description, String shortName, LocalDateTime startTime, LocalDateTime endTime){
		
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
	public String getDescription(){
		return description;
	}
	
	/**
	 * Sets the description for the appointment. 
	 * @param description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	 * 
	 * @return The shortName for the appointment
	 */
	public String getShortName() {
		return shortName;
	}


	/**
	 * Sets the shortName for the appointment.
	 * @param shortName
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	/**
	 * 
	 * @return The startTime of the appointment. 
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}


	/**
	 * Sets the startTime for the appointment, and checks that it is valid.
	 * @param startTime
	 * @return boolean, true if done correctly, false otherwise.
	 */
	public boolean setStartTime(LocalDateTime startTime) {
		
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
	public LocalDateTime getEndTime() {
		return endTime;
	}


	/**
	 * Sets the endTime for the appointment, and checks that it is valid. 
	 * @param endTime
	 * @return boolean, true if it is done correctly, false otherwise. 
	 */
	public boolean setEndTime(LocalDateTime endTime) {
		
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
	private boolean validateTime(LocalDateTime startTime, LocalDateTime endTime){
		
		if(startTime.isBefore(endTime)){
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	

}