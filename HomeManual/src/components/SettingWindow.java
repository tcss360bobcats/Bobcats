package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2545946456909824902L;
	private User user;
	private JLabel usernameText;
	private JLabel emailText;
	
	public SettingWindow() {
		/**
		 * get the user in files/profile.ser
		 * profile.ser contains the current user of the application
		 * @author Andrew Lim
		 */
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./files/profile.ser"));
	        user = (User) ois.readObject();
	        ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
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
		/**
		 * @author Andrew Lim
		 */
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		/**
		 * @author Andrew Lim
		 */
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
		usernameText = new JLabel(user.getUsername());
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
		emailText = new JLabel(user.getEmail());
		emailPanel.add(emailLabel);
		emailPanel.add(emailText);
		return emailPanel;
	}	
}
