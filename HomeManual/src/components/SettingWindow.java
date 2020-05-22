package components;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingWindow extends JFrame {

	
	public SettingWindow() {
		setSize(300, 250);
		add(createWindow());
		setVisible(true);
	}
	
	/**
	 * Creates a settings window
	 * @author Anthony
	 * @return Jpanel with settings options
	 */
	public JPanel createWindow() {
		JPanel master = new JPanel();
		
		
		//TODO Add action listeners to the buttons to import/export/change settings
		JButton importButton = new JButton("Import Settings");
		JButton exportButton = new JButton("Export Settings");
		JButton saveButton = new JButton("Update Settings");
		
		
		
		master.add(nameSettings());
		master.add(emailSettings());
		master.add(fileSettings());
		master.add(importButton);
		master.add(exportButton);
		master.add(saveButton);
		
		return master;
	}
	
	/**
	 * Creates a section to update name settings
	 * @author Anthony
	 * @return Panel with name settings
	 */
	public JPanel nameSettings() {	
		
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameText = new JTextField();
		nameText.setText("DEFAULT NAME");
		
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		return namePanel;
	}
	
	/**
	 * Creates a section to update email settings
	 * @author Anthony
	 * @return Panel with email settings
	 */
	public JPanel emailSettings() {
		JPanel emailPanel = new JPanel();
		JLabel emailLabel = new JLabel("Email: ");
		JTextField emailText = new JTextField();
		emailText.setText("DEFAULT EMAIL");
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailText);

		return emailPanel;
	}
	
	/**
	 * Creates a section to update file path settings
	 * @author Anthony
	 * @return Panel with file path settings
	 */
	public JPanel fileSettings() {
		JPanel filePanel = new JPanel();
		JButton fileButton = new JButton("DEFAULT FILE PATH");
		JLabel fileLabel = new JLabel("File Path: ");

		filePanel.add(fileLabel);
		filePanel.add(fileButton);
		
		return filePanel;
	}
	
}
