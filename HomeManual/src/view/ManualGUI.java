/*
 * 
 */


package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

import utilities.About;

/**
 * ManualGUI is the GUI for the HomeManual app.
 * 
 * @author Andrew Lim, Anthony Nguyen, Darryl James, Tyke Sykes
 * @version 2 May 2020
 */
public class ManualGUI extends JFrame {
	
	/**
	 * Runs the app.
	 * @param args
	 */
	public static void main(String[] args) {
	       EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                final ManualGUI frame = new ManualGUI();
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.setVisible(true);
	                frame.start();
	            }
	        });
	}

	/**
	 * The GUI JFrame.
	 */
	ManualGUI() {
		super();
		
	}
	
	/**
	 * Starts the JFrame.
	 */
	private void start() {
		setVisible(true);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createMenuBar();
		add(displayPanel(), BorderLayout.CENTER);
	}
	
	/**
	 * The menu bar for the app that contains 3 menus:
	 * File, Edit, and Help.
	 */
	private void createMenuBar() {
		final JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(createFile());
		menuBar.add(createEdit());
		menuBar.add(createHelp());
		
		setJMenuBar(menuBar);
	}
	
	/**
	 * Creates the File menu.
	 * @return File menu.
	 */
	private JMenu createFile() {
		final JMenu file = new JMenu("File");
		// TODO: add file toolbar options
		return file;
	}
	
	/**
	 * Creates the Edit menu.
	 * @return the Edit menu.
	 */
	private JMenu createEdit() {
		final JMenu edit = new JMenu("Edit");
		// TODO: add edit toolbar options
		return edit;
	}
	
	/**
	 * Creates the Help menu. Contains the About menu item
	 * that displays the authors and version of the app.
	 * @return the Help menu.
	 */
	private JMenu createHelp() {
		final JMenu help = new JMenu("Help");
		final JMenuItem about = new JMenuItem("About...");
		help.add(about);
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theE) {
				try {
					String about = "Version: " + About.getVersion();
					about += "\nAuthors: " + Arrays.toString(About.getAuthors()).substring(1,
							Arrays.toString(About.getAuthors()).length() - 1);
					
					JOptionPane.showMessageDialog(ManualGUI.this, about);
				} catch (HeadlessException | IOException e) {
					JOptionPane.showMessageDialog(ManualGUI.this, "Cannot find version file.");
					e.printStackTrace();
				}
			}
		});
		return help;
	}
	
	/**
	 * Creates the display panel of the app.
	 * @return the display panel.
	 */
	private JPanel displayPanel() {
		JPanel display = new JPanel();
		
		return display;
	}
}
