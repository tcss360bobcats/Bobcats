package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;

import model.User;

/**
 * Settings that stores user information.
 * @author Andrew Lim
 */
public class Settings {
	
	/**
	 * Creates a setting.
	 */
	public Settings() {
		
	}
	
	/**
	 * Imports a user profile to the application.
	 * @param username used to import user information
	 * @throws FileNotFoundException thrown if user does not exist.
	 */
	public void importSettings(String username) throws FileNotFoundException {
		File f = new File("./src/users/" + username + ".ser");
		// if user does not exist
		if (!f.exists()) {
			// throw exception
			throw new FileNotFoundException();
		} else {
			// update files/profile.ser with the new user
			try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	            User importedUser = (User) ois.readObject();
	            FileOutputStream out = new FileOutputStream("./src/files/profile.ser");
	            ObjectOutputStream oout = new ObjectOutputStream(out);
	            oout.writeObject(importedUser);
	            oout.close();
	            ois.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		}	
	}
	
	/**
	 * Exports a new user setting.
	 * @param exportUser user information to be saved.
	 * @throws FileAlreadyExistsException thrown if user already exists.
	 */
	public void exportSettings(User exportUser) throws FileAlreadyExistsException {
		File f = new File("./src/users/" + exportUser.getUsername() + ".ser");
		// if user already exists
		if (f.exists()) {
			// throw exception
			throw new FileAlreadyExistsException(f.toString());
		} else {
			// update files/profile.ser with the new user
			try {
	            FileOutputStream out = new FileOutputStream(f);
	            ObjectOutputStream oout = new ObjectOutputStream(out);
	            oout.writeObject(exportUser);
	            oout.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		}
	}
	
}
