package components;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import utilities.About;
import view.ManualGUI;

/**
 * Creates a menu bar 
 * @author Anthony Nguyen
 * @author Tyke Sykes
 */
public class MenuBar extends JMenuBar{
	
	
	/** default serial id */
	private static final long serialVersionUID = 1L;
	
	/** main GUI*/
	private ManualGUI myGUI; 
	
	
	private JMenu myEditMenu; 
	
	
	
	/**
	 * Creates a menu bar for the GUI.
	 * @author Anthony
	 * @param theGUI the main display 
	 */
	public MenuBar(final ManualGUI theGUI) {
		myGUI = theGUI;
		add(createFile());
		myEditMenu = createEdit();
		add(myEditMenu);
		add(createUtility());
	}
	
	/**
	 * Creates the File menu.
	 * @author Anthony
	 * @return File menu.
	 */
	private JMenu createFile() {
		final JMenu file = new JMenu("File");
		// TODO: add file toolbar options
		final JMenuItem settings = new JMenuItem("Settings");
		settings.addActionListener(theEvent -> new SettingWindow());
		file.add(settings);
			
		return file;
	}
	
	/**
	 * Creates the Edit menu.
	 * @author Anthony
	 * @return the Edit menu.
	 */
	private JMenu createEdit() {
		final JMenu edit = new JMenu("Edit");
		edit.setEnabled(false);
		// TODO: add edit toolbar options
		final JMenuItem addItem = new JMenuItem("Add Item");
		addItem.addActionListener(theEvent -> new AddItemWindow());
		edit.add(addItem);
		
		return edit;
	}
	
	/**
	 * Creates the Help menu. Contains the About menu item
	 * that displays the authors and version of the app.
	 * @author Tyke
	 * @return the Help menu.
	 */
	private JMenu createUtility() {
		final JMenu utility = new JMenu("Utility");
		
		final JMenuItem about = new JMenuItem("About...");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theE) {
				try {
					String about = "Version: " + About.getVersion();
					about += "\nAuthors: " + Arrays.toString(About.getAuthors()).substring(1,
							Arrays.toString(About.getAuthors()).length() - 1);
					
					JOptionPane.showMessageDialog(myGUI, about);
				} catch (HeadlessException e) {
					JOptionPane.showMessageDialog(myGUI, "Cannot find version file.");
					e.printStackTrace();
				}
			}
		});
		
		//@author Anthony
		final JMenuItem login = new JMenuItem("Admin Log In...");
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//log in stuff		
				myEditMenu.setEnabled(true);
			}			
		});
		utility.add(login);
		utility.add(about);
		
		return utility;
	}
}
