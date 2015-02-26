package no.ntnu.fellesprosjekt34;

public class Invitation {
	
	private int rsvp;
	private Appointment appointment;
	private User user;
	
	/**
	 * Constructor
	 * @param appointment
	 * @param user
	 */
	public Invitation(Appointment appointment, User user){
		this.appointment = appointment;
		this.user = user;
	}
	
	/**
	 * Empty consuctor 
	 */
	public Invitation(){
		
	}
	
	public Invitation(int rsvp) {
		setRSVP(rsvp);
	}
	
	public int getRSVP() {
		return rsvp;
	}
	
	public void setRSVP(int rsvp) {
		this.rsvp = rsvp;
	}
	
}
