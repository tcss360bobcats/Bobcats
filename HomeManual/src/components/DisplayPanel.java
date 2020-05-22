package components;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;


public class DisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final SwingController myController = new SwingController();
	private static final SwingViewBuilder myFactory = new SwingViewBuilder(myController);
	
	private String filePath;
	private JPanel myViewerComponentPanel;
	
	
    public DisplayPanel() {
    	// This Line is for Testing and Demo Purposes
    	this.filePath = "pdf/c4611_sample_explain.pdf";
    	// This Line is for Testing and Demo Purposes
    	
        myViewerComponentPanel = myFactory.buildViewerPanel();
        myViewerComponentPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));

    	setDisplay(filePath);
    }
    
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
