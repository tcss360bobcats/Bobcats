package components;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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
	
	private static DisplayPanel myDisplay;

	/**
	 * Contains the file system. 
	 * @author Anthony
	 */
	public FilePanel(ArrayList<Room> theRooms, DisplayPanel theDisplay) {
		setVisible(true);
		add(createTree(theRooms, theDisplay));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public static JTree createTree(ArrayList<Room> theRooms, DisplayPanel theDisplay) {
		DefaultMutableTreeNode top = new DefaultMutableTreeNode();
		myDisplay = theDisplay;
		createNodes(theRooms, top);
		JTree jt = new JTree(top);
		jt.setRootVisible(false);
		setUpListener(jt);
		
		return jt;
	}
	
	private static void createNodes(ArrayList<Room> theRooms, DefaultMutableTreeNode theTop) {
		for(Room r : theRooms) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(r);
			for(Item i : r.getItems()) {
				DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(i);
				node.add(itemNode);
			}
			theTop.add(node);
		}
	}

	private static void setUpListener(JTree theTree) {
		theTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();
				
				Object nodeObject = node.getUserObject();
				if(node.isLeaf()) {
					Item item = (Item) nodeObject;
					myDisplay.setDisplay(item.getFile());
				}
			}
		});
	}
}
