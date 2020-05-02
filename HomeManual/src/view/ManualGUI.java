package iteration0;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManualGUI extends JFrame {

	private static final long serialVersionUID = 1L;

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

	ManualGUI() {
		super();
		
	}
	
	private void start() {
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		createMenuBar();
		add(displayPanel(), BorderLayout.CENTER);
	}
	
	private void createMenuBar() {
		final JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(createFile());
		menuBar.add(createEdit());
		menuBar.add(createHelp());
		
		setJMenuBar(menuBar);
	}
	
	private JMenu createFile() {
		final JMenu file = new JMenu("File");
		// TODO: add file toolbar options
		return file;
	}
	
	private JMenu createEdit() {
		final JMenu edit = new JMenu("Edit");
		// TODO: add edit toolbar options
		return edit;
	}
	
	private JMenu createHelp() {
		final JMenu help = new JMenu("Help");
		final JMenuItem about = new JMenuItem("About...");
		help.add(about);
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent theE) {
				// TODO: add version popup
				JOptionPane.showMessageDialog(ManualGUI.this, "Version 1");
			}
		});
		return help;
	}
	
	private JPanel displayPanel() {
		JPanel display = new JPanel();
		JTextField test = new JTextField("Search...", 25);	
		Font bigFont = test.getFont().deriveFont(Font.PLAIN, 25f);
		test.setFont(bigFont);
		test.setToolTipText("Please enter something here");
		display.add(test);
		
		return display;
	}
}
