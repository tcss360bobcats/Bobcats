package components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  Panel for the user to search tags/keywords 
 * @author Anthony Nguyen
 *
 */
public class SearchPanel extends JPanel{

	
	/** default serial id */
	private static final long serialVersionUID = 1L;
	
	/** text field for the user to search tags/keywords */
	private JTextField mySearchBox;
	
	/** search button to submit the text field. */
	private JButton mySearchButton;

	
	/**
	 * Panel with a text field and button to submit entry.
	 */
	public SearchPanel() {
		mySearchBox = createSearchBox();
		mySearchButton = createSearchButton();
		add(mySearchBox);
		add(mySearchButton);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	/**
	 * Creates a text field for the user to search up tags/keywords. 
	 * @return search bar 
	 */
	private JTextField createSearchBox() {
		
		JTextField test= new JTextField(20);
		return test;
	}
	
	/**
	 * Creates a button that lets the user submit their text entry.
	 * @return submission button
	 */
	private JButton createSearchButton() {
		JButton button = new JButton();
		//TODO: Add action listener to button to submit the text
		return button;
	}
}
