package no.ntnu.fellesprosjekt34;

public class Login {
	

	private String email;
	private String password;
	
	/**
	 * The Constructor takes two arguments, email and password of the user. 
	 * @param email
	 * @param password
	 */
	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
	/**
	 * 
	 * @return The email of the user. 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email for the object. 
	 * @param email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return The users password.
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * Sets the password for the object. 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
