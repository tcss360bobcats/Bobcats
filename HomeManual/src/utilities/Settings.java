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
 *
 */
public class Settings {
	// private User user;
	
	public Settings() {
		
	}
	
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
	
	/**
	 * Main method for testing purposes only.
	 * Will be removed in final version.
	 * @param args
	 */
	public static void main(String[] args) {
		Settings s = new Settings();
		User bob = new User("bob", "bob@gmail.com");
//		try {
//			s.exportSettings(bob);
//		} catch (FileAlreadyExistsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			s.importSettings("bob");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
