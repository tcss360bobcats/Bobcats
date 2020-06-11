

package components;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		JPanel namePanel = new JPanel();
		JTextField name = new JTextField(20);
		name.setToolTipText("Enter the name of your Item here");
		JLabel nameOfItem = new JLabel("Name of Item: ");
		namePanel.add(nameOfItem);
		namePanel.add(name);
		
		JPanel tagsPanel = new JPanel();
		JTextField tags = new JTextField(20);
		tags.setToolTipText("Make sure the tags are space separated");
		JLabel nameOfTags = new JLabel("Tags: ");
		tagsPanel.add(nameOfTags);
		tagsPanel.add(tags);
		
		JPanel filePanel = new JPanel();
		JFileChooser file = new JFileChooser();
//		JLabel nameOfFile = new JLabel("File Path: ");
//		filePanel.add(nameOfFile);
		filePanel.add(file);
		
		JButton submit = new JButton("Add Item");
		submit.addActionListener(theEvent -> {
			// Something goes here
			String aName = name.getText();
			String[] someTags = tags.getText().split(" ");
			String aFileName = file.getSelectedFile().getAbsolutePath();
			// FileWriter fw = new FileWriter(this.getClass().getResource("/files/testItemFile.txt").getFile().toString(), true)
			try (FileWriter fw = new FileWriter("./src/files/testItemFile.txt", true); 
				 BufferedWriter bw = new BufferedWriter(fw);
				 PrintWriter out = new PrintWriter(bw)){
				out.print("\n" + aName + ", " + aFileName + ", ");
				for (String t : someTags) {
					out.print(t + " ");
				}
				
				out.close();
				fw.close();
				bw.close();
				System.out.println("Success");
				System.out.println(aName);
				System.out.println(aFileName);
				System.out.println(Arrays.toString(someTags));
				
				System.out.println(this.getClass().getResource("/files/testItemFile.txt").getFile().toString());
			} catch (Exception e) {
				System.out.println("Something went wrong with the add item process");
				e.printStackTrace();
			}
			
		});		
		
		window.add(namePanel);
		window.add(tagsPanel);
		window.add(filePanel);
		window.add(submit);
		
		
		return window;
	}
	

}
	