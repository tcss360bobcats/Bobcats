package model;

import java.io.Serializable;

/**
 * Model of a User that contains username and email.
 * @author Andrew Lim
 *
 */
public class User implements Serializable {
	/**
	 * A default serial id.
	 */
	private static final long serialVersionUID = 2128034274378880644L;
	
	private String username;
	private String email;
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void updateUsername(String username) {
		this.username = username;
	}
	
	public void updateEmail(String email) {
		this.email = email;
	}
}
