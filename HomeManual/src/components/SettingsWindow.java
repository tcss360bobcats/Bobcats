package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.ObjectInputStream;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.User;
import utilities.Settings;

/**
 * Displays settings options of the application.
 * @author Anthony, Andrew
 */
public class SettingsWindow extends JFrame {
	/**
	 * A default serial id.
	 */
	private static final long serialVersionUID = 2545946456909824902L;
	private Settings s;
	private User user;
	private JLabel usernameText;
	private JLabel emailText;
	private JLabel successErrorMessage;
	private JTextField usernameImport;
	private JTextField usernameExport;
	private JTextField emailExport;
	
	/**
	 * @author Anthony
	 */
	public SettingsWindow() {
		this.s = new Settings();
		/**
		 * get the user in files/profile.ser
		 * profile.ser contains the current user of the application
		 * @author Andrew Lim
		 */		
		try {
			//ObjectInputStream ois = new ObjectInputStream(this.getClass().getResource("/files/testItemFile.txt").openStream());

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./res/files/profile.ser"));
	        user = (User) ois.readObject();
	        ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
		setSize(500, 200);
		setResizable(false);
		add(createWindow());
		setVisible(true);
	}
	
	/**
	 * Creates a settings window
	 * @author Anthony
	 * @return JPanel with settings options
	 */
	public JPanel createWindow() {
		JPanel master = new JPanel(new BorderLayout());
		JPanel north = new JPanel();
		north.add(usernameSettings());
		north.add(emailSettings());
		master.add(north, BorderLayout.NORTH);
		JButton importButton = new JButton("Import Settings");
		JButton exportButton = new JButton("Export Settings");
		JPanel center = new JPanel();	
		center.add(importButton);
		center.add(exportButton);
//		master.add(center, BorderLayout.CENTER);
		JPanel importForm = importForm();
		JPanel exportForm = exportForm();
		importForm.setVisible(false);
		exportForm.setVisible(false);
		JPanel south = new JPanel();
		successErrorMessage = new JLabel();
//		south.add(importForm);
//		south.add(exportForm);
		center.add(importForm);
		center.add(exportForm);
		south.add(successErrorMessage);
		master.add(center, BorderLayout.CENTER);
		master.add(south, BorderLayout.SOUTH);
		/**
		 * @author Andrew Lim
		 */
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exportForm.setVisible(false);
				importForm.setVisible(true);
			}
		});
		/**
		 * @author Andrew Lim
		 */
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				importForm.setVisible(false);
				exportForm.setVisible(true);
			}
		});
		return master;
	}
	
	/**
	 * Creates the import form.
	 * @author Andrew Lim
	 * @return JPanel containing the import form.
	 */
	public JPanel importForm() {
		JPanel panel = new JPanel();
		JLabel usernameLabel = new JLabel("Username:");
		usernameImport = new JTextField(10);
		JButton importButton = new JButton("Import");
		panel.add(usernameLabel);
		panel.add(usernameImport);
		panel.add(importButton);
		importButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					s.importSettings(usernameImport.getText());
					try {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./res/files/profile.ser"));
				        user = (User) ois.readObject();
				        usernameText.setText(user.getUsername());
				        emailText.setText(user.getEmail());
				        ois.close();
					} catch (Exception e1) {
						System.out.println(e1);
					}
					// display success message: user settings successfully imported
					successErrorMessage.setText("User settings successfully imported.");
				} catch (FileNotFoundException e1) {
					// display error message: user does not exist
					successErrorMessage.setText("Error: User does not exist. Please try a different username.");
					e1.printStackTrace();
				}
			}
		});
		return panel;
	}
	
	/**
	 * Creates the export form.
	 * @author Andrew Lim
	 * @return JPanel containing the export form.
	 */
	public JPanel exportForm() {
		JPanel panel = new JPanel();
		JLabel usernameLabel = new JLabel("Username:");
		JLabel emailLabel = new JLabel("Email:");
		usernameExport = new JTextField(10);
		emailExport = new JTextField(10);
		JButton exportButton = new JButton("Export");
		panel.add(usernameLabel);
		panel.add(usernameExport);
		panel.add(emailLabel);
		panel.add(emailExport);
		panel.add(exportButton);
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User exportUser = new User(usernameExport.getText(), emailExport.getText());
				try {
					s.exportSettings(exportUser);
					// display success message: user setting successfully exported
					successErrorMessage.setText("User settings successfully exported.");
				} catch (FileAlreadyExistsException e1) {
					// display error message: user already exists
					successErrorMessage.setText("Error: User already exists. Please try a different username.");
					e1.printStackTrace();
				}
			}
		});
		return panel;
	}
	
	/**
	 * Creates a section to update name settings
	 * @author Anthony
	 * @return JPanel with name settings
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
	 * @return JPanel with email settings
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
