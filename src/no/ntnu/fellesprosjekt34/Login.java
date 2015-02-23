package no.ntnu.fellesprosjekt34;


public class Login {	

	//Variables
	private String email;
	private String password;
	
	/**
	 * The Constructor takes two arguments, email and password of the user. 
	 * @param email
	 * @param password
	 */
	public Login(String email, String password) {
		
		//Må få inn try/catch
		if(validateEmail(email)){
			this.email = email;			
		}
		
		if(validatePassword(password)){
			this.password = password;			
		}
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
	public boolean setPassword(String password) {
		
		if(validatePassword(password)){
			this.password = password;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Validates if email is allowed. Needs to be one '@'. 
	 * @param email
	 * @return boolean, true if done correctly, false otherwise. 
	 */
	private boolean validateEmail(String email){
		
		//Splits at '@'
		String[] splitMail = email.split("@");
		
		//Can only be one '@'.
		if(splitMail.length != 2){
			System.out.println("Needs one '@'");
			return false;
		}
		
		//Before the '@', it is only allowed with letters, numbers and '.', '_' and '-'.
		if(!splitMail[0].matches("[A-Za-z0-9\\.\\_\\-]+")){
			System.out.println("Some characters are not allowed.");
			return false;
		}
		
		//If it is good, return true;
		return true;
	}
	
	/**
	 * Validates the password. Needs to be at least 8 characters long and contain at least
	 * one upper case letter and one digit. 
	 * @param password
	 * @return
	 */
	private boolean validatePassword(String password){
		
		//Needs to be at least 8 characters long. 
		if(password.length() < 8){
			System.out.println("Password must be at least 8 characters");
			return false;
		}
		
		//Needs to be at least one upper case letter and one digit
		boolean upper = false;
		boolean digit = false;
		for (char c : password.toCharArray()) {
			if(Character.isUpperCase(c)){
				upper = true;
			}
			
			else if(Character.isDigit(c)){
				digit = true;
			}
		}
		
		if(!upper || !digit){
			System.out.println("Needs to be at least one upper case letter and a number.");
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Login test = new Login("eirik-@hamnvik.no", "123123");
	}

	
	
	

}
