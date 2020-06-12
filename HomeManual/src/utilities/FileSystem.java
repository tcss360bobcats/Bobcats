package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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

	public static ArrayList<Room> myRooms;
	
	public static ArrayList<Room> initialize() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		myRooms = rooms;
		
		ObjectInputStream ois = null;
		FileInputStream fin = null;
		try {
			File file = new File(FOLDER);
			String[] folders = file.list();
			for(String s : folders) {
				fin = new FileInputStream(FOLDER + s + "/room_" + s + ".ser");
				ois = new ObjectInputStream(fin);
				Room room = (Room) ois.readObject();
				myRooms.add(room);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(ois != null) {
				try {ois.close();} catch(Exception e) {}
			}
		}
		
		return myRooms;
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
	}
	
	public static void delete(Room theRoom, Item theItem) {
		Iterator<Room> i = myRooms.iterator();
		while(i.hasNext()) {
			Room room = i.next();
			if(room.getName().contentEquals(theRoom.getName())) {
				theRoom.getItems().remove(theItem);
				break;
			}
		}
		write(theRoom);
	}
	
	public static void delete(Room theRoom) {
		Iterator<Room> i = myRooms.iterator();
		while(i.hasNext()) {
			Room room = i.next();
			if(room.getName().equals(theRoom.getName())) {
				File file = new File(FOLDER + theRoom.getName());
				
				String[] entries = file.list();
				for(String s : entries) {
					File currentFile = new File(file.getPath(), s);
					currentFile.delete();
				}
				file.delete();
			}
		}
	}
}
