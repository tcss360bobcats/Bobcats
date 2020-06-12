

package components;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The AddRoomWindow class displays the window
 * to add room into the application
 * 
 * @author Anthony
 */
public class AddRoomWindow extends JFrame {

	/**
	 * The default serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Sets the size of the window
	 * and creates the window to display
	 * the file directory to choose items.
	 */
	public AddRoomWindow() {
		setSize(324, 183);
		add(createWindow());
		setVisible(true);
	}
	
	/**
	 * Creates the window to display
	 * the files to add to the program.
	 * 
	 * @return the window to add files.
	 */
	private JPanel createWindow() {
		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.PAGE_AXIS));
		
		JPanel namePanel = new JPanel();
		JTextField name = new JTextField(20);
		name.setToolTipText("Enter the name of your Room here");
		JLabel nameOfItem = new JLabel("Name of Room: ");
		namePanel.add(nameOfItem);
		namePanel.add(name);

		JButton submit = new JButton("Add Room");
		submit.addActionListener(theEvent -> {
			//TODO: Add Room HERE 
		});		
		
		window.add(namePanel);
		window.add(submit);
		
		return window;
	}
	
}
	