package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

import components.FilePanel;
import components.MenuBar;
import components.SearchPanel;
import components.DisplayPanel;
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
	 * This is a test method for the 
	 * search and display functionality
	 * 
	 * @return A List of test items to search for
	 */
	private ArrayList<Item> getItems() {
		Item item1 = new Item("AItem", new File("pdf/BioniclesManual.pdf"));
		Item item2 = new Item("BItem", new File("pdf/Bobcats-Deliverable1.pdf"));
		Item item3 = new Item("CItem", new File("pdf/c4611_sample_explain.pdf"));
		Item item4 = new Item("DItem", new File("pdf/checkin-3.pdf"));
		Item item5 = new Item("Keyword", new File("pdf/c4611_sample_explain.pdf"));
		Item item6 = new Item("Bionicle", new File("pdf/BioniclesManual.pdf"));
		Item item7 = new Item("Deliverable", new File("pdf/Bobcats-Deliverable1.pdf"));
		Item item8 = new Item("CheckIn", new File("pdf/checkin-3.pdf"));
		
		HashSet<String> test = new HashSet<String>();
		test.add("A");
		test.add("B");
		
		item1.addTag("A");
		item2.addTag("B");
		item3.addTags(test);
		item4.addTag("Boba");
		
		test.add("Boba");
		test.add("Deliverable");
		test.add("Bionicle");
		
		item5.addTag("Keyword");
		item6.addTag("Bionicle");
		item7.addTag("Deliverable");
		item8.addTags(test);
		
		ArrayList<Item> allItems = new ArrayList<Item>();
		allItems.add(item1);
		allItems.add(item2);
		allItems.add(item3);
		allItems.add(item4);
		allItems.add(item5);
		allItems.add(item6);
		allItems.add(item7);
		allItems.add(item8);
		allItems.add(item1);
		allItems.add(item2);
		allItems.add(item3);
		allItems.add(item4);
		allItems.add(item5);
		allItems.add(item6);
		allItems.add(item7);
		allItems.add(item8);
		
		for (Item item : allItems) item.addTag("Searching");
		
		return allItems;	
	}
	
	/**
	 * Initializes the GUI with all its components and panels. 
	 * @author Anthony
	 */
	private void initGUI() {
		
		// Test Item Stuff
		ArrayList<Item> allItems = getItems();
		// Test Item Stuff 
		
		setLayout(new BorderLayout());
		
		//main display for the manual
		final DisplayPanel displayPanel = new DisplayPanel();

		final FilePanel filePanel = new FilePanel();
		filePanel.setLayout(new BoxLayout(filePanel, WIDTH));


		// Makes the Scroll Bar appear and resizes its width
		final JScrollPane scrollPane = new JScrollPane(filePanel);	
        final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setPreferredSize(new Dimension(12, 12));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setVerticalScrollBar(scrollBar);
		// Makes the Scroll Bar appear and resizes its width

        
		final SearchPanel searchPanel = new SearchPanel(filePanel, displayPanel);
		searchPanel.setSize(this.getWidth() / 3 , this.getHeight() / 8);
		searchPanel.attachList(allItems);
					
		//TODO: ADD FILE SYSTEM
		//left file display system
		final JPanel westPanel = new JPanel(new BorderLayout());
		westPanel.add(searchPanel, BorderLayout.NORTH);

		//filePanel.setBackground(Color.BLACK);
		
		westPanel.add(scrollPane);
//		westPanel.add(filePanel);
				
		final JPanel masterPanel = new JPanel(new BorderLayout());
		masterPanel.add(displayPanel, BorderLayout.CENTER);
		masterPanel.add(westPanel, BorderLayout.WEST);

		add(masterPanel);
		pack();
   	 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (SCREEN_SIZE.width / 2), (int) Math.round(SCREEN_SIZE.height * 0.75));
   	 	setVisible(true);
	}
	

}
