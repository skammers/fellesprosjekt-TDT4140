package no.ntnu.fellesprosjekt34;

public class Invitation {
	
	private int rsvp;
	private Appointment appointment;
	private User user;
	private static final int NO_ANSWER = 0, GOING = 1, NOT_GOING = 2, MAYBE = 3;
	
	/**
	 * Constructor
	 * @param appointment
	 * @param user
	 */
	public Invitation(Appointment appointment, User user, int rsvp){
		this.appointment = appointment;
		this.user = user;
		
		if(validRSVP(rsvp)){
			setRSVP(rsvp);
		}
	}
	
	/**
	 * Empty constructor 
	 */
	public Invitation(){
		
	}
	
	/**
	 * Constructor, taking only rsvp value
	 * @param rsvp
	 */
	public Invitation(int rsvp) {
		if(validRSVP(rsvp)){
			setRSVP(rsvp);
		}
	}
	
	/**
	 * getter for the rsvp value.
	 * @return int, the rsvp value.
	 */
	public int getRSVP() {
		return rsvp;
	}
	
	/**
	 * sets the rsvp value, only if it is validated. 
	 * @param rsvp
	 * @return boolean, true if the value is set, false otherwise. 
	 */
	public boolean setRSVP(int rsvp) {
		if(validRSVP(rsvp)){
			this.rsvp = rsvp;
			return true;
		}
		return false;
	}
	
	/**
	 * Getter for the appointment
	 * @return The appointment of the invitation. 
	 */
	public Appointment getAppointment(){
		return appointment;
	}
	
	/**
	 * Getter for the user.
	 * @return The user of the invitation.
	 */
	public User getUser(){
		return user;
	}
	
	/**
	 * Validates if the RSVP value is one of the predefined values.
	 * @param rsvp
	 * @return boolean, true if it is good, false if it doesn't exist. 
	 */
	private boolean validRSVP(int rsvp){
		
		if(rsvp == NO_ANSWER || rsvp == GOING || rsvp == NOT_GOING || rsvp == MAYBE){
			return true;
		}
		
		return false;
	}
}
