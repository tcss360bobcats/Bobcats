package model;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * An Item object holds a name, a File, and tags. There can be no duplicate tags.
 * 
 * @author Tyke Sykes
 * @version 5/08/2020
 */
public class Item implements Serializable {
	/**
	 * Default serial Id.
	 */
	private static final long serialVersionUID = 1L;

	/** The name of the Item. */
	private String myName;

	/** The File object associated with the Item. */
	private URL myFile;

	/** The Set of tags associated with the Item. */
	private Set<String> myTags;

	/**
	 * Constructor for Item object with no tags.
	 * 
	 * @param theName is the name of the Item.
	 * @param theFile is the File to be associated with the Item.
	 */
	public Item(String theName, URL theFile) {
		this(theName, theFile, new HashSet<String>());
	}

	/**
	 * Constructor for Item object with tags.
	 * 
	 * @param theName is the name of the Item.
	 * @param theFile is the File to be associated with the Item.
	 * @param theTags is a Set of tags to be associated with the Item.
	 */
	public Item(String theName, URL theFile, Set<String> theTags) {
		myName = theName;
		myFile = theFile;
		myTags = theTags; 
	}

	/**
	 * Sets the name of the Item.
	 * 
	 * @param theName is the new name to be set.
	 */
	public void setName(String theName) {
		myName = theName;
	}

	/**
	 * Returns the name of the Item.
	 * 
	 * @return the name of the Item.
	 */
	public String getName() {
		return myName;
	}

	/**
	 * Sets the File to be associated with the Item.
	 * 
	 * @param theFile is the File to be associated with the Item.
	 */
	public void setFile(URL theFile) {
		myFile = theFile;
	}

	/**
	 * Returns the File associated with the Item.
	 * 
	 * @return the File associated with the Item.
	 * @throws IOException 
	 */
	public URL getFile() {
		return myFile;
	}

	/**
	 * Adds a single tag to the Item.
	 * 
	 * @param theTag is the tag to add to the Item.
	 */
	public void addTag(String theTag) {
		myTags.add(theTag.toLowerCase());
	}

	/**
	 * Adds multiple tags to the Item.
	 * 
	 * @param theTags is the Set of tags to add to the Item.
	 */
	public void addTags(Set<String> theTags) {
		for (String tag : theTags) myTags.add(tag.toLowerCase());
	}

	/**
	 * Removes a single tag from the Item.
	 * 
	 * @param theTag is the tag to be removed from the Item.
	 */
	public void removeTag(String theTag) {
		myTags.remove(theTag);
	}

	/**
	 * Removes multiple tags from the Item.
	 * 
	 * @param theTags is the Set of tags to be removed from the Item.
	 */
	public void removeTags(Set<String> theTags) {
		myTags.removeAll(theTags);
	}

	/**
	 * Removes all tags from the Item.
	 */
	public void clearTags() {
		myTags.clear();
	}

	/**
	 * Returns the Set of tags associated with the Item.
	 * 
	 * @return the Set of tags associated with the Item.
	 */
	public Set<String> getTags() {
		return myTags;
	}
}
