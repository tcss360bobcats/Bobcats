/**
 * 
 */
package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.User;

/**
 * Tests the user class.
 * @author Andrew Lim
 *
 */
public class UserTest {
	/**
	 * User to be tested.
	 */
	private User myUser;

	/**
	 * Creates a user with username "bob" and email "bob@gmail.com".
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myUser = new User("bob", "bob@gmail.com");
	}

	/**
	 * Tests if getUsername returns the correct username.
	 */
	@Test
	public void testGetUsername() {
		assertEquals("getUsername failed", "bob", myUser.getUsername());
	}
	
	/**
	 * Tests if getEmail returns the correct email.
	 */
	@Test
	public void testGetEmail() {
		assertEquals("getEmail failed", "bob@gmail.com", myUser.getEmail());
	}
	
	/**
	 * Tests if username is correctly updated when updateUsername is called.
	 */
	@Test
	public void testUpdateUsername() {
		myUser.updateUsername("fred");
		assertEquals("updateUsername failed", "fred", myUser.getUsername());
	}
	
	/**
	 * Tests if email is correctly updated when updateEmail is called.
	 */
	@Test
	public void testUpdateEmail() {
		myUser.updateEmail("fred@gmail.com");
		assertEquals("updateEmail failed", "fred@gmail.com", myUser.getEmail());
	}

}
