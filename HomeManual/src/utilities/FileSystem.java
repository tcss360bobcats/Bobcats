package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import model.Item;
import model.Room;

/**
 * @author Tyke Sykes
 *
 */
public class FileSystem implements Serializable {
	
	final static String FOLDER = "rooms/";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8801974321963152918L;

	public static HashSet<Room> initialize() {
		HashSet rooms = new HashSet<Room>();
		
		ObjectInputStream ois = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("test/room_test.ser");
			ois = new ObjectInputStream(fin);
			Room test = (Room) ois.readObject();
			rooms.add(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ois != null) {
				try {ois.close();} catch(Exception e) {}
			}
		}
		
		return rooms;
	}
	
	public static void write(Room room) {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		File file = new File(FOLDER + room.getName());
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			fout = new FileOutputStream(FOLDER + room.getName() + "/room_" + room.getName() + ".ser", false);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(room);
		} catch (Exception ex) {}
		finally {
			if(oos != null) {
				try {
					oos.close();
					} catch(Exception e) {}
			}
		}
		
		for(Item i : room.getItems()) {
			
		}
	}
	
	public static void delete(Item item) {
		//delete object from file system
	}
	
	public static void delete(Room room) {
		//delete whole room and items from file system
	}
}
