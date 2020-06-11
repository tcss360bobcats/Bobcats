package components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

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
		addClickListener(jt);
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


	/**
	 * Creates a popup menu when an item on the JTree is rightclicked 
	 * @author Anthony Nguyen
	 * @param theTree
	 */
	private static void addClickListener(JTree theTree) {
		
		TreePopup treePopup = new TreePopup(theTree);
	    theTree.addMouseListener(new MouseAdapter() {
	    	public void mouseReleased(MouseEvent e) {
	    		//if the tree is right click then dispaly the option to delete nodes 
	    		if(e.isPopupTrigger()) {
	    	        TreePath selPath = theTree.getPathForLocation(e.getX(), e.getY());
	    			theTree.setSelectionPath(selPath);
	    			treePopup.show(e.getComponent(), e.getX(), e.getY());
	                
	            }
	    		//if the tree is left clicked then display the contents on the main display
	    		//@author Tyke 
	    		if(e.getButton() == MouseEvent.BUTTON1) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) theTree.getLastSelectedPathComponent();
					
					Object nodeObject = node.getUserObject();
					if(node.isLeaf()) {
						Item item = (Item) nodeObject;
						myDisplay.setDisplay(item.getFile());
					}
	    		}
	    	}
	    });	
	}
}

/**
 * Popup menu for the JTree.
 * @author Anthony
 *
 */
class TreePopup extends JPopupMenu {
	
	JTree myTree;
	
	public TreePopup(JTree theTree) {
		myTree = theTree;
		//creates a popup menu with an option to delete an item
		JMenuItem delete = new JMenuItem("Delete");
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//deletes the node from the tree and the object associate with the node from the app
				System.out.println("DELETE");

				//TODO Remove the item 
				

                DefaultTreeModel model = (DefaultTreeModel) theTree.getModel();
                TreePath[] paths = theTree.getSelectionPaths();
                if (paths != null) {
                    for (TreePath path : paths) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
                            path.getLastPathComponent();
                        if (node.getParent() != null) {
                        	Item tempItem = (Item) node.getUserObject();
                        	//TODO REMOVE ITEM FUNCTION 
                            model.removeNodeFromParent(node);
                        }
                    }
                }

			}	
		});
		add(delete);
	}
}
