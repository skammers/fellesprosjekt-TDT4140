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
	public boolean setEmail(String email) {
		
		if(validateEmail(email)){
			this.email = email;
			return true;
		}
		return false;
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
	
	
	private boolean validateEmail(String email){
		
		String[] splitMail = email.split("@");
		
		System.out.println("Dette funker ikke");
		
		
		return false;
	}
	
	public static void Main(String[] args){
		Login test = new Login("eirik@hamnvik.no", "123123");
		test.setEmail("eirik@hamnvik.no");
	}

	
	
	

}
