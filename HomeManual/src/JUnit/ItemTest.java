package JUnit;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import model.Item;
/**
 * The ItemTest class 
 * test for the important
 * methods within it.
 * 
 * @author Darryl James
 */
public class ItemTest {
	
	/** The test items for testing purposes.*/
	private Item myItem1, myItem2, myItem3;
	
	@Before
	public void start() {
		myItem1 = new Item("AItem", this.getClass().getResource("/pdf/BioniclesManual.pdf"));
		myItem2 = new Item("BItem", this.getClass().getResource("/pdf/Bobcats-Deliverable1.pdf"));
		myItem3 = new Item("DItem", this.getClass().getResource("/pdf/Bobcats-Deliverable1.pdf"));
		
		myItem1.addTag("a");
		myItem2.addTag("b");
		
		myItem3.addTag("a");
		myItem3.addTag("b");
		myItem3.addTag("boba");
	}
	
	/**
	 * This is a test method for the 
	 * search and display functionality
	 * 
	 * @return A List of test items to search for
	 */
	@Test
	public void itemTagsTest() {
		HashSet<String> temp = new HashSet<>();
		temp.add("a");
		
		assertEquals(temp, myItem1.getTags());
		
		temp.clear();
		temp.add("b");
		
		assertEquals(temp, myItem2.getTags());
		
		temp.clear();
		temp.add("a");
		temp.add("b");
		temp.add("boba");
		
		assertEquals(temp, myItem3.getTags());
	}
	
	/**
	 * Test the clear tags functionality
	 * in the item class.
	 * 
	 * Here the item should have
	 * no tags when we assert.
	 * 
	 * @author Darryl James
	 */
	@Test 
	public void itemClearTags() {
		myItem3.clearTags();
		
		assertTrue(myItem3.getTags().equals(new HashSet<String>()));
		
		myItem3.addTag("a");
		myItem3.addTag("b");
		myItem3.addTag("boba");		
	}
	
	/**
	 * Test the add tags functionality
	 * in the item class.
	 * 
	 * Here the item should have tags
	 * "a", "b", and "boba" when we assert.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemAddTags() {
		HashSet<String> temp = new HashSet<>();
		temp.add("a");
		temp.add("b");
		temp.add("This is a tag".toLowerCase());
		
		myItem2.addTags(temp);
		assertEquals(myItem2.getTags(), temp);
	}
	
	/**
	 * Test the get item names
	 * functionality in the item class.
	 * 
	 * Here the items should have
	 * names AItem, BItem, and DItem
	 * when we assert
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemNamesTest() {
		assertTrue(myItem1.getName().equals("AItem"));
		assertTrue(myItem2.getName().equals("BItem"));
		assertTrue(myItem3.getName().equals("DItem"));
	}
	
	/**
	 * Test the set name functionality
	 * in the item class.
	 * 
	 * Here the items should have names
	 * "A new name", "Another name"', and
	 * "Really Long Name Here"
	 * when we assert.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemSetNameTest() {
		myItem1.setName("A new name");
		myItem2.setName("Another name");
		myItem3.setName("Really Long Name Here");
		
		assertEquals(myItem1.getName(), "A new name");
		assertEquals(myItem2.getName(), "Another name");
		assertEquals(myItem3.getName(), "Really Long Name Here");
		
		myItem1.setName("AItem");
		myItem2.setName("BItem");
		myItem3.setName("DItem");
	}
	
	/**
	 * Test the remove tag functionality
	 * in the item class.
	 * 
	 * Here item1 should have
	 * on tag 'a' on the
	 * final assert.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemRemoveTagTest() {
		HashSet<String> temp = new HashSet<>();
		temp.add("a");
		temp.add("wz");
		
		myItem1.addTag("wz");
		assertEquals(myItem1.getTags(), temp);
		
		myItem1.removeTag("wz");
		temp.remove("wz");
		assertEquals(myItem1.getTags(), temp);
	}
	
	/**
	 * Test the remove tags functionality
	 * in the item class.
	 * 
	 * Here item2 should have
	 * no tags when we assert.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemRemoveTags() {
		HashSet<String> temp = new HashSet<>();
		temp.add("a");
		temp.add("b");
		temp.add("This is a tag".toLowerCase());
		
		myItem2.removeTags(temp);
		assertEquals(myItem2.getTags(), new HashSet<String>());
		myItem2.addTag("b");
	}
	
	/**
	 * Test the get file functionality
	 * in the item class.
	 * 
	 * all the items files should be
	 * in the correct places.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemFileNameTest() {
		assertEquals(myItem1.getFile().getPath(), myItem1.getFile().getPath());
		assertEquals(myItem2.getFile().getPath(), myItem2.getFile().getPath());
		assertEquals(myItem3.getFile().getPath(), myItem3.getFile().getPath());
	}
	
	/**
	 * Test the set file functionality
	 * in the item class.
	 * 
	 * Here item3 should have
	 * the bionicles pdf file
	 * when we assert.
	 * 
	 * @author Darryl James
	 */
	@Test
	public void itemFileSetTest() {
		URL temp = myItem3.getFile();
		myItem3.setFile(this.getClass().getResource("/pdf/BioniclesManual.pdf"));
		assertEquals(myItem3.getFile().getPath(), myItem3.getFile().getPath());
		myItem3.setFile(temp);
	}
  
}
