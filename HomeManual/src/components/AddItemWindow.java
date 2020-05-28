package components;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AddItemWindow() {
		setSize(800, 600);
		add(createWindow());
		setVisible(true);
	}
	
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
		JLabel nameOfFile = new JLabel("File Path: ");
		filePanel.add(nameOfFile);
		filePanel.add(file);
		
		JButton submit = new JButton("Add Item");
//		submit.addActionListener(theEvent -> {
//			// Something goes here
//		});		
		
		window.add(namePanel);
		window.add(tagsPanel);
		window.add(filePanel);
		window.add(submit);
		
		return window;
	}
	

}
