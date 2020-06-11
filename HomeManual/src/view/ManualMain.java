package view;
import java.awt.EventQueue;

public final class ManualMain {
	
	/**
	 * Private constructor to prevent instantiation
	 */
	private ManualMain() {
		//do nothing
	}
	
	/**
	 * Constructs the main GUI window frame
	 * @author Anthony
	 * @param theArgs Command line arguments (ignored).
	 */
	public static void main(String[] theArgs) {
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManualGUI();     
            }
        });
	}
}
