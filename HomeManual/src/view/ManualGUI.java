package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import components.FilePanel;
import components.MenuBar;
import components.SearchPanel;

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
	 * Initializes the GUI with all its components and panels. 
	 */
	private void initGUI() {
		
		setLayout(new BorderLayout());
		//main display for the manual
		final Container mainDisplay = new JPanel();
		
		
		final Container searchPanel = new SearchPanel();
		searchPanel.setSize(this.getWidth() / 3 , this.getHeight() / 8);
		
		//TODO: ADD FILE SYSTEM
		//left file display system
		final Container filePanel = new FilePanel();
		
		
		final Container westPanel = new JPanel(new BorderLayout());
		westPanel.add(searchPanel, BorderLayout.NORTH);
		westPanel.add(filePanel);
		
		
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
