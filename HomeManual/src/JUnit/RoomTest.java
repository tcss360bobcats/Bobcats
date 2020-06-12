package JUnit;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Item;
import model.Room;

/**
 * The RoomTest class
 * tests for the important 
 * methods within the it.
 * 
 * @author Darryl James
 */
public class RoomTest {

	/** The test room for testing purposes.*/
	private Room myRoom;
	
	/** The test list of items for testing purposes.*/
	private ArrayList<Item> myItems;
	
	/** The test items for testing purposes.*/
	private Item myTestItem1, myTestItem2;
	
	@Before
	public void start() {
		myRoom = new Room("TestRoom");
		myItems = new ArrayList<Item>();
		
		myTestItem1 = new Item("AItem", new File("./res/pdf/BioniclesManual.pdf"));
		myTestItem2 = new Item("BItem", new File("./res/pdf/Bobcats-Deliverable1.pdf"));
		
		myItems.add(myTestItem1);
		myRoom.addItem(myTestItem1);
	}
	
	/**
	 * Test the get name functionality
	 * in the room class.
	 * 
	 * Here the room should be
	 * named "TestRoom"
	 * 
	 * @author Darryl James
	 */
	@Test
	public void RoomGetName() {		
		assertEquals(myRoom.getName(), "TestRoom");	
	}
	
	/**
	 * Test the set name functionality
	 * in the room class.
	 * 
	 * Here the room should be
	 * named "RoomTest".
	 * @author Darryl James
	 */
	@Test
	public void RoomSetName() {
		myRoom.setName("RoomTest");
		assertEquals(myRoom.getName(), "RoomTest");
	}
	
	/**
	 * Test the get item functionality
	 * in the room class.
	 * 
	 * Here the room should only
	 * have myTestItem1.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void RoomGetItemTest() {
		assertEquals(myItems, myRoom.getItems());
	}
	
	/**
	 * Test the add item functionality
	 * in the room class.
	 * 
	 * Here the room should have
	 * myTestItem1 and myTestItem2.
	 * 
	 * @author Darryl James
	 */
	@Test 
	public void RoomAddItemTest() {
		myRoom.addItem(myTestItem2);
		myItems.add(myTestItem2);
		assertEquals(myRoom.getItems(), myItems);
	}
	
	/**
	 * Test the clear items functionality
	 * in the room class.
	 * 
	 * Here the room should 
	 * be empty.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void RoomClearItemsTest() {
		myRoom.clearItems();
		assertEquals(myRoom.getItems(), new ArrayList<Item>());
	}
	
	/**
	 * Test the add items functionality
	 * in the room class.
	 * 
	 * Here the room should have 
	 * myTestItem1 and myTestItem2.
	 * 
	 * @author Tyke
	 */
	@Test 
	public void RoomAddItemsTest() {
		myItems.add(myTestItem2);
		myRoom.addItems(myItems);
		assertTrue(myRoom.getItems().containsAll(myItems) && myItems.containsAll(myRoom.getItems()));
	}
	
	/**
	 * Test the remove item functionality
	 * in the room class.
	 * 
	 * Here the room should only
	 * have myTestItem1.
	 * 
	 * @author Tyke
	 */
	@Test 
	public void RoomRemoveItemTest() {
		myItems.remove(myTestItem2);
		myRoom.removeItem(myTestItem2);
		
		assertEquals(myRoom.getItems(), myItems);
	}
	
	/**
	 * Test the remove Items functionality
	 * in the room class.
	 * 
	 * Here the room should be empty
	 * when we assert.
	 * 
	 * @author Anthony
	 */
	@Test
	public void RoomRemoveItemsTest() {
		myItems.add(myTestItem2);
		myItems.addAll(myItems);
		myRoom.addItems(myItems);
		
		myRoom.removeItems(myItems);
		myItems.clear();
		
		assertEquals(myRoom.getItems(), myItems);
	}

}
