package components;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 * 
 * @author Andrew Lim, Darryl James
 *
 */
public class DisplayPanel extends JPanel {

	/** Default serial ID. */
	private static final long serialVersionUID = 1L;
	
	/** The swing controller to place inside the SwingViewBuilder. */
	private static final SwingController myController = new SwingController();
	
	/** The swing view builder to display the items. */
	private static final SwingViewBuilder myFactory = new SwingViewBuilder(myController);
	
	/** The file path of the currently displayed item. */
	private String filePath;
	
	/** The panel to display the item. */
	private JPanel myViewerComponentPanel;
	
	/**
	 * The display panel, displays the items
	 * and their contents to the display area.
	 * 
	 * @author Darryl James
	 */
    public DisplayPanel() {
    	// This Line is for Testing and Demo Purposes
    	this.filePath = "./res/pdf/c4611_sample_explain.pdf";
    	
        myViewerComponentPanel = myFactory.buildViewerPanel();
        myViewerComponentPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

    	setDisplay(filePath);
    }
    
    /**
     * Sets the display item 
     * on the display panel.
     * @author Andrew Lim
     * @param theFile the new item file to display
     */
    public void setDisplay(String theFile) {
    	filePath = theFile;
    	removeAll();
        
        myController.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        myController.getDocumentViewController()));

        addComponentListener(new ComponentListener() {
			@Override
			public void componentResized(ComponentEvent e) {
		        myViewerComponentPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
		        repaint();
		        revalidate();
			}
			
			@Override
			public void componentShown(ComponentEvent e) {}
			@Override
			public void componentMoved(ComponentEvent e) {}
			@Override
			public void componentHidden(ComponentEvent e) {}
		});
        
        add(myViewerComponentPanel);
        myController.openDocument(filePath);
        repaint();
        revalidate();
        setVisible(true);
    }
}
