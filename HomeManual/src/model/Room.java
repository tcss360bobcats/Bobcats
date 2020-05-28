package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Room object contains a List of Items and has a name. There can be duplicate Items in a Room.
 * 
 * @author Tyke Sykes
 * @version 5/08/2020
 */
public class Room implements Serializable {
	/**
	 * Default serial Id.
	 */
	private static final long serialVersionUID = 1L;

	/** The name of the Room. */
	private String myName;
	
	/** The List of Items in the Room. */
	private ArrayList<Item> myItems;
	
	/**
	 * Constructor for a Room with no Items.
	 * 
	 * @param theName is the name of the Room.
	 */
	public Room(String theName) {
		this(theName, new ArrayList<Item>());
	}
	
	/**
	 * Constructor for a Room with Items.
	 * 
	 * @param theName is the name of the Room.
	 * @param theItems is the List of Items in the Room.
	 */
	@SuppressWarnings("unchecked")
	public Room(String theName, ArrayList<Item> theItems) {
		myName = theName;
		myItems = (ArrayList<Item>) theItems.clone();
	}
	
	/**
	 * Sets the name of the Room.
	 * 
	 * @param theName is the new name to be set.
	 */
	public void setName(String theName) {
		myName = theName;
	}
	
	/**
	 * Returns the name of the Room.
	 * 
	 * @return the name of the Room.
	 */
	public String getName() {
		return myName;
	}
	
	/**
	 * Adds an Item to the room.
	 * 
	 * @param theItem is the Item to be added to the Room.
	 */
	public void addItem(Item theItem) {
		myItems.add(theItem);
	}
	
	/**
	 * Adds multiple Items to the room.
	 * 
	 * @param theItems is the list of Items to be added to the Room.
	 */
	public void addItems(ArrayList<Item> theItems) {
		myItems.addAll(theItems);
	}
	
	/**
	 * Removes an Item from the Room.
	 * 
	 * @param theItem is the Item to be removed to the Room.
	 */
	public void removeItem(Item theItem) {
		myItems.remove(theItem);
	}
	
	/**
	 * Removes multiple Items from the Room.
	 * 
	 * @param theItems is the List of Items to be removed from the Room.
	 */
	public void removeItems(ArrayList<Item> theItems) {
		myItems.removeAll(theItems);
	}
	
	/**
	 * Removes all Items from the Room.
	 */
	public void clearItems() {
		myItems.clear();
	}
	
	/**
	 * Returns the List of Items in the Room.
	 * 
	 * @return the List of Items in the Room.
	 */
	public ArrayList<Item> getItems() {
		return myItems;
	}
}
