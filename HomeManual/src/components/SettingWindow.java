package components;

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
	JLabel usernameText;
	JLabel emailText;
	
	public SettingWindow() {
		setSize(300, 250);
		add(createWindow());
		setVisible(true);
	}
	
	/**
	 * Creates a settings window
	 * @author Anthony
	 * @return JPanel with settings options
	 */
	public JPanel createWindow() {
		JPanel master = new JPanel();
		JButton importButton = new JButton("Import Settings");
		JButton exportButton = new JButton("Export Settings");
		master.add(usernameSettings());
		master.add(emailSettings());
		master.add(importButton);
		master.add(exportButton);
		return master;
	}
	
	/**
	 * Creates a section to update name settings
	 * @author Anthony
	 * @return Panel with name settings
	 */
	public JPanel usernameSettings() {	
		JPanel usernamePanel = new JPanel();
		JLabel usernameLabel = new JLabel("Username: ");
		usernameText = new JLabel("Bob");
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameText);
		return usernamePanel;
	}
	
	/**
	 * Creates a section to update email settings
	 * @author Anthony
	 * @return Panel with email settings
	 */
	public JPanel emailSettings() {
		JPanel emailPanel = new JPanel();
		JLabel emailLabel = new JLabel("Email: ");
		emailText = new JLabel("bob@gmail.com");
		emailPanel.add(emailLabel);
		emailPanel.add(emailText);
		return emailPanel;
	}	
}
