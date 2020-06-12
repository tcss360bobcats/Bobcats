
package components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import model.Item;
import model.Room;
import utilities.FileSystem;
import view.ManualGUI;

/**
 * The AddItemWindow class displays the window
 * to add items into the application
 * 
 * @author Darryl James
 */
public class AddItemWindow extends JFrame {
	
	/**
	 * The default serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Sets the size of the window
	 * and creates the window to display
	 * the file directory to choose items.
	 */
	public AddItemWindow() {
		setSize(800, 600);
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
		
		// Add The Name option for the user
		JPanel namePanel = new JPanel();
		JTextField name = new JTextField(20);
		name.setToolTipText("Enter the name of your Item here");
		JLabel nameOfItem = new JLabel("Name of Item: ");
		namePanel.add(nameOfItem);
		namePanel.add(name);
		
		// Add The room option for the user
		JPanel roomPanel = new JPanel();
		JTextField room = new JTextField(20);
		room.setToolTipText("Enter the name of the room you want it to be in");
		JLabel roomName = new JLabel("Name of the Room: ");
		roomPanel.add(roomName);
		roomPanel.add(room);
		
		// Add The tags option for the user
		JPanel tagsPanel = new JPanel();
		JTextField tags = new JTextField(20);
		tags.setToolTipText("Make sure the tags are space separated");
		JLabel nameOfTags = new JLabel("Tags: ");
		tagsPanel.add(nameOfTags);
		tagsPanel.add(tags);
		
		// Add The file option for the user
		JPanel filePanel = new JPanel();
		JFileChooser file = new JFileChooser(".");
		file.setControlButtonsAreShown(false);
		filePanel.add(file);
		
		// Add The submit button for the user
		JButton submit = new JButton("Add Item");
		submit.addActionListener(theEvent -> {

			String aName = name.getText();
			String[] someTags = tags.getText().split(" ");
			String aFileName = file.getSelectedFile().getAbsolutePath();
			String aRoomName = room.getText();
			
			try (FileWriter fw = new FileWriter("./res/files/testItemFile.txt", true); 
				 BufferedWriter bw = new BufferedWriter(fw);
				 PrintWriter out = new PrintWriter(bw)){
				out.print("\n" + aName + ", " + aFileName + ", ");
				for (String t : someTags) {
					out.print(t + " ");
				}
				
				out.close();
				fw.close();
				bw.close();
				this.dispose();
				JOptionPane.showMessageDialog(this, "File Successfully added");
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "The file was not added");
				e.printStackTrace();
			}
//				File inFile = new File(aFileName);
//				Item item = new Item(aName, inFile);
//				Iterator<Room> i = FileSystem.myRooms.iterator();
//				while(i.hasNext() ) {
//					Room room = i.next();
//					if(room.getName().equals("test")) {
//						room.addItem(item);
//						FileSystem.write(room);
//					}
//					
//			String aRoomName = room.getText();
//				
//				for (String t : someTags) {out.print(t + " ");}
//				
//				out.close();
//				fw.close();
//				bw.close();
//				// Closes the window when the button is pressed
//				this.dispose();
//				JOptionPane.showMessageDialog(this, "File Added Successfully");
//
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(this, "The File was not added Successfully");
//				e.printStackTrace();
//			}
		});		
		
		window.add(namePanel);
		window.add(roomPanel);
		window.add(tagsPanel);
		window.add(filePanel);
		window.add(submit);
		
		return window;
	}
}
	
