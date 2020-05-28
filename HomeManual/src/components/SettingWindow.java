package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilities.Settings;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2545946456909824902L;
	Settings mySettings;
	JTextField nameText;
	JTextField emailText;
	
	public SettingWindow() {
		mySettings = new Settings("DEFAULT USER", "DEFAULT EMAIL");
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
		
		/**
		 * @author Andrew Lim
		 */
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mySettings = new Settings(nameText.getText(), emailText.getText());
				mySettings.importSettings();
			}
		});
		
		/**
		 * @author Andrew Lim
		 */
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mySettings = new Settings(nameText.getText(), emailText.getText());
				mySettings.exportSettings();
			}
		});
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
		nameText = new JTextField();
		nameText.setText(mySettings.tagName);
		
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
		emailText = new JTextField();
		emailText.setText(mySettings.email);
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
