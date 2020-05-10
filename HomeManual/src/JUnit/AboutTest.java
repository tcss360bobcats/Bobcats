package JUnit;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;

import utilities.About;

/**
 * 
 * @author Darryl James
 * @version 5/02/2020
 */
public class AboutTest {	
	
	/**
	 * This test makes sure the versions are 
	 * only updated when About.getVersion is called.
	 * 
	 */
	@Test 
	public void getVersionTest() { 
		// if we need to test it change the date
		String date = LocalDate.now().toString();
		About.updateVersion();
		assertEquals(date, About.getVersion());
	}
	
	/**
	 * This test makes sure the authors are 
	 * the same when we call About.getAuthors()
	 * for output.
	 * 
	 */
	@Test 
	public void getAuthors() {
		String[] authors = {"Darryl James", "Andrew Lim", "Tyke Sykes", "Anthony Nguyen"};
		assertTrue(Arrays.toString(authors).equals(Arrays.toString(About.getAuthors())));
	}

}
