package no.ntnu.fellesprosjekt34;

import java.time.LocalDateTime;


public class Appointment {

	//Variabler
	private String description;
	private String shortName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	public Appointment(String description, String shortName, LocalDateTime startTime, LocalDateTime endTime){
		
		this.description = description;
		this.shortName = shortName;
		
		if(checkTime(startTime, endTime)){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
	}
	
	
	//Getter and setter for description
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public boolean setStartTime(LocalDateTime startTime) {
		
		if(checkTime(startTime, this.endTime)){
			this.startTime = startTime;
			return true;
		}
		return false;
		
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public boolean setEndTime(LocalDateTime endTime) {
		
		if(checkTime(this.startTime, endTime)){
			this.endTime = endTime;
			return true;
		}
		return false;
	}
	

	//Validating start- and endTime
	private boolean checkTime(LocalDateTime startTime, LocalDateTime endTime){
		
		if(startTime.isBefore(endTime)){
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	

}