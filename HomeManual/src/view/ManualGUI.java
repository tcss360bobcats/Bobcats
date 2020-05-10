package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

import components.FilePanel;
import components.MenuBar;
import components.SearchPanel;
import model.Item;

/**
 * ManualGUI is the GUI for the HomeManual app.
 * 
 * @author Andrew Lim, Anthony Nguyen, Darryl James, Tyke Sykes
 * @version 2 May 2020
 */
public class ManualGUI extends JFrame {
	
    /**default serial id */
	private static final long serialVersionUID = 1L;

	// constants to capture screen dimensions
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    
	private final static String TITLE = "Homeowner's Manual";
	

	/**
	 * The GUI JFrame.
	 */
	ManualGUI() {
		super(TITLE);
		
		setJMenuBar(new MenuBar(this));
		initGUI();
	}
	
	/**
	 * This is a test method for the search functionality
	 * 
	 * @return A List of test items to search for
	 */
	private ArrayList<Item> getItems() {
		Item item1 = new Item("AItem", new File("files/testItemFile,txt"));
		Item item2 = new Item("BItem", new File("files/testItemFile.txt"));
		Item item3 = new Item("CItem", new File("files/testItemFile.txt"));
		Item item4 = new Item("DItem", new File("files/testItemFile.txt"));
		
		item1.addTag("A");
		item2.addTag("B");
		
		HashSet<String> test = new HashSet<String>();
		test.add("A");
		test.add("B");
		item3.addTags(test);
		
		item4.addTag("Boba");
		
		ArrayList<Item> allItems = new ArrayList<Item>();
		allItems.add(item1);
		allItems.add(item2);
		allItems.add(item3);
		allItems.add(item4);
		
		return allItems;	
	}
	
	/**
	 * Initializes the GUI with all its components and panels. 
	 */
	private void initGUI() {
		
		// Test Stuff
		ArrayList<Item> allItems = getItems();
		// Test Stuff 
		
		setLayout(new BorderLayout());
		//main display for the manual
		final Container mainDisplay = new JPanel();
		
		final Container searchPanel = new SearchPanel();
		searchPanel.setSize(this.getWidth() / 3 , this.getHeight() / 8);
		
		final JTextField search = new JTextField(20);
						
		//TODO: ADD FILE SYSTEM
		//left file display system
		final Container filePanel = new FilePanel();
				
		final Container westPanel = new JPanel(new BorderLayout());
		westPanel.add(search, BorderLayout.NORTH);

		//		westPanel.add(searchPanel, BorderLayout.NORTH);
		westPanel.add(filePanel);
		
		// Add Found items to a list first before adding them to the panel
		// Make sure to go through all tags first
		search.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					int count = 0;
					String tag = search.getText();
					filePanel.removeAll();
					for (final Item anItem : allItems) {
						if (anItem.getName().toLowerCase().contains(tag.toLowerCase())) {
							filePanel.add(new JButton(anItem.getName()), BorderLayout.WEST);
							count++;
						} else if (anItem.getTags().size() > 0) {
							for (String word : anItem.getTags()) {
								if (word.contains(tag.toLowerCase())) {
									filePanel.add(new JButton(anItem.getName()), BorderLayout.WEST);
									count++;
									break;
								}
							}
							
						}
					}
					if (count == 0) JOptionPane.showMessageDialog(mainDisplay, "No Matches Found");
					revalidate();
					repaint();	
					System.out.println("Pressed: " + search.getText());
				}
			}
		});
		
		System.out.println(2 ^ 3 ^ 1);
		
		final Container masterPanel = new JPanel(new BorderLayout());
		masterPanel.add(mainDisplay, BorderLayout.CENTER);
		masterPanel.add(westPanel, BorderLayout.WEST);
		//masterPanel.add(filePanel, BorderLayout.WEST);

		add(masterPanel);
		pack();
   	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
        setSize(SCREEN_SIZE.width / 2, (int) Math.round(SCREEN_SIZE.height * 0.75));
	}
	

}
