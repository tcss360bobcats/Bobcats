package components;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Item;
import model.Room;

/**
 * Panel that displays the file system to the user. 
 * @author Anthony Nguyen
 * @author Tyke Sykes
 */
public class FilePanel extends JPanel {

	/**
	 * Default serial Id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contains the file system. 
	 * @author Anthony
	 */
	public FilePanel(ArrayList<Room> theRooms) {
		setVisible(true);
		add(createTree(theRooms));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private JTree createTree(ArrayList<Room> theRooms) {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode();
		createNodes(theRooms, top);
		JTree jt = new JTree(top);
		jt.setRootVisible(false);
		
		return jt;
	}
	
	private void createNodes(ArrayList<Room> theRooms, DefaultMutableTreeNode theTop) {
		for(Room r : theRooms) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(r);
			for(Item i : r.getItems()) {
				DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(i);
				node.add(itemNode);
			}
			theTop.add(node);
		}
	}
}
