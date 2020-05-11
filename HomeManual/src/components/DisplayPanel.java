package components;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;


public class DisplayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String filePath;
	
    public DisplayPanel() {
    	this.filePath = "files/c4611_sample_explain.pdf";
    	SwingController controller = new SwingController();

        SwingViewBuilder factory = new SwingViewBuilder(controller);

        JPanel viewerComponentPanel = factory.buildViewerPanel();

        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));
        add(viewerComponentPanel);
        
        controller.openDocument(filePath);
        setVisible(true);
    }
}
