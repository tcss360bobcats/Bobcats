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
<<<<<<< HEAD
	
=======
>>>>>>> d202dc3e37e9725b57250837b6c0ddf570061f15
	private String username;
	private String email;
	
	/**
	 * Creates a user.
	 * @param username
	 * @param email
	 */
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	/**
	 * Getter for username.
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * getter for email.
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Updates username.
	 * @param username to update old username.
	 */
	public void updateUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Updates email
	 * @param email to update old email.
	 */
	public void updateEmail(String email) {
		this.email = email;
	}
}
