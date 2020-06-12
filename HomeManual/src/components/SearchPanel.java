package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Item;

/**
 *  Panel for the user to search tags/keywords 
 * @author Anthony Nguyen
 * @author Darryl James
 *
 */
public class SearchPanel extends JPanel{

	
	/** default serial id */
	private static final long serialVersionUID = 1L;
	
	/** text field for the user to search tags/keywords */
	private JTextField mySearchBox;
	
	/** search button to submit the text field. */
	private JButton mySearchButton;
	
	/** The file panel to show items*/
	private JPanel myFilePanel;
	
	/** The display panel to show notifications.*/
	private DisplayPanel myDisplayPanel;
	
	
	/**
	 * Panel with a text field and button to submit entry.
	 * @author Anthony
	 */
	public SearchPanel(JPanel theFilePanel, DisplayPanel theDisplayPanel) {
		myFilePanel = theFilePanel;
		myDisplayPanel = theDisplayPanel;
		mySearchBox = createSearchBox();
		mySearchButton = createSearchButton();
		
		add(mySearchBox);
		add(mySearchButton);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	/**
	 * Creates a text field for the user to search up tags/keywords. 
	 * @author Anthony 
	 * @return search bar 
	 */
	private JTextField createSearchBox() {
		final JTextField search = new JTextField(20);
		return search;
	}
	
	/**
	 * Creates a button that lets the user submit their text entry.
	 * @author Anthony
	 * @return submission button
	 */
	private JButton createSearchButton() {
		final JButton button = new JButton("Search");
		return button;
	}
	
	/**
	 * Attaches listeners to the search box and 
	 * search box button so users can 
	 * search for their items.
	 * 
	 * When the user presses the enter key
	 * or the search button the search
	 * will begin.
	 * 
	 * @author Darryl James
	 * @param theItems a list of the items that are searchable
	 */
	public void attachList(ArrayList<Item> theItems) {
		// Search the Items as the user types
		mySearchBox.getDocument().addDocumentListener(new DocumentListener() {			
			@Override
			public void insertUpdate(DocumentEvent e) {search(theItems);}
			@Override
			public void changedUpdate(DocumentEvent e) {search(theItems);}
			
			@Override
			public void removeUpdate(DocumentEvent e) {search(theItems);}
		});
		
		mySearchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				search(theItems);
			}
		});
	}
	
	/**
	 * Searches through the list of Items, and
	 * updates the file panel if an item
	 * meets the search / tag criteria. 
	 * 
	 * @author Darryl James
	 * @param theItems the list of items to search
	 */
	private void search(ArrayList<Item> theItems) {
		myFilePanel.removeAll();
		final String tag = mySearchBox.getText();
		final int count = searchItems(tag, theItems);

		if (count == 0) myFilePanel.add(new JLabel("\tNo Matches Found"));
		myFilePanel.revalidate();
		myFilePanel.repaint();			
	}
	
	/**
	 * Searches across the list that is given and 
	 * adds them to the file panel if they match the tag,
	 * and increment a counter to keep track of how many items 
	 * are found.
	 *   
	 * If no items are found the return value is 0 and a 
	 * pop message is displayed.
	 * 
	 * @author Darryl James
	 * @param theTag the tag to search for
	 * @param theItems the list of items
	 * @return how many items were found.
	 */
	private int searchItems(String theTag, ArrayList<Item> theItems) {
		if (theTag.equals("")) return 0;
		ArrayList<Item> temp = new ArrayList<Item>();
		
		for (final Item anItem : theItems) {
			// If the name of an Item matches the search tag, add it
			if (anItem.getName().toLowerCase().contains(theTag.toLowerCase())) {
				temp.add(anItem);
				
			// If a tag in the Item matches the search tag, add it
			} else if (anItem.getTags().size() > 0) {				
				for (String tag : anItem.getTags()) {
					if (tag.contains(theTag.toLowerCase())) {
						temp.add(anItem);
						break;
					}
				}
			}
		}
		
		// Sorts the list of found items in alphabetical order
		Collections.sort(temp, (Item a, Item b) -> a.getName().compareTo(b.getName()));
		// Add all found items to the search panel
		for (Item anItem : temp) addToFilePanel(anItem);
		return temp.size();
	}
	
	/**
	 * When an Item is found it is added to the filePanel.
	 * 
	 * Since our items are added as buttons, each time
	 * we add an item, an action listener is attached to it
	 * which sets the display area pdf when it is clicked on.
	 * 
	 * @author Darryl James
	 * @param theItem the item to be added to the file panel.
	 */
	private void addToFilePanel(Item theItem) {
		final JButton butt = new JButton(theItem.getName());
		butt.setMaximumSize(new Dimension(myFilePanel.getWidth(), 50));
		butt.setBackground(Color.WHITE);
		butt.setForeground(Color.BLACK);
		
		butt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDisplayPanel.setDisplay(theItem.getFile().toString());
			}
		});
		
		butt.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (butt.getModel().isRollover()) 
					butt.setBackground(Color.LIGHT_GRAY);
				else 
					butt.setBackground(Color.WHITE);
			}
		});
		
		myFilePanel.add(butt);
		myFilePanel.add(Box.createRigidArea(new Dimension(0, 5)));
	}
	
}
