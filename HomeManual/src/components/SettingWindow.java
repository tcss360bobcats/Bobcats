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

public class SettingWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2545946456909824902L;
	private Settings s;
	private User user;
	private JLabel usernameText;
	private JLabel emailText;
	
	private JTextField usernameImport;
	private JTextField usernameExport;
	private JTextField emailExport;
	
	/**
	 * @author Anthony
	 */
	public SettingWindow() {
		this.s = new Settings();
		/**
		 * get the user in files/profile.ser
		 * profile.ser contains the current user of the application
		 * @author Andrew Lim
		 */
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/files/profile.ser"));
	        user = (User) ois.readObject();
	        ois.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
		setSize(500, 150);
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
		master.add(center, BorderLayout.CENTER);
		JPanel importForm = importForm();
		JPanel exportForm = exportForm();
		importForm.setVisible(false);
		exportForm.setVisible(false);
		JPanel south = new JPanel();
		south.add(importForm);
		south.add(exportForm);
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
	 * @author Andrew Lim
	 * @return
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
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/files/profile.ser"));
				        user = (User) ois.readObject();
				        usernameText.setText(user.getUsername());
				        emailText.setText(user.getEmail());
				        ois.close();
					} catch (Exception e1) {
						System.out.println(e1);
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return panel;
	}
	
	/**
	 * @author Andrew Lim
	 * @return
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
				} catch (FileAlreadyExistsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return panel;
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
