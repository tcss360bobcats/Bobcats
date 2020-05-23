package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings implements Serializable {
    /**
	 * @author Andrew Lim
	 */
	private static final long serialVersionUID = 2545946456909824902L;
	public String tagName;
    public String email;
    public Settings(String tagName, String email) {
        this.tagName = tagName;
        this.email = email;
    }
    
    /**
	 * @author Andrew Lim
	 */
    public String toString() {
        return tagName + " " + email;
    }
    
    /**
	 * @author Andrew Lim
	 */
    public void exportSettings() {
    	try {
            FileOutputStream out = new FileOutputStream("./files/" + this.tagName + ".txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(this);
            oout.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
    
    /**
	 * @author Andrew Lim
	 */
    public void importSettings() {
    	try {
    		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./files/" + this.tagName + ".txt"));
            Settings currentSettings = (Settings) ois.readObject();
            FileOutputStream out = new FileOutputStream("./files/Settings.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(currentSettings);
            oout.close();
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }
}