package components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Panel that displays the file system to the user. 
 * @author Anthony Nguyen
 *
 */
public class FilePanel extends JPanel{

	/**
	 * Default serial Id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contains the file system. 
	 * @author Anthony
	 */
	public FilePanel() {
		//add(fileSystem);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
