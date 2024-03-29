package DBLP;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** \class SearchEngine
 *  \brief Overall GUI for application
 *  
 *  Contains Header, QueryInputPanel, QueryOutputPanel
 */

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class SearchEngine extends JFrame {
    
    static final Font PFONT = new Font("Arial", Font.PLAIN, 13);
    static final int FRAMEW = 800;
    static final int FRAMEH = 600;
    static final int NOFROWS = 20;
    
    Header header;
    QueryInputPanel queryInputPan;
    QueryOutputPanel queryOutputPan;
    
    public SearchEngine() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(FRAMEW, FRAMEH);
        this.setMaximumSize(new Dimension(FRAMEW, FRAMEH));
        
        header = new Header();
        queryInputPan = new QueryInputPanel();
        queryOutputPan = new QueryOutputPanel();
        
        queryInputPan.addListener(queryOutputPan);
        
        JPanel topPan = new JPanel();
        topPan.setLayout(new BoxLayout(topPan, BoxLayout.Y_AXIS));
        
        JPanel midPan = new JPanel();
        midPan.setLayout(new BoxLayout(midPan, BoxLayout.X_AXIS));
        
        queryInputPan.setAlignmentY(Component.CENTER_ALIGNMENT);
        queryOutputPan.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        midPan.add(queryInputPan);
        midPan.add(queryOutputPan);
        
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        midPan.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        topPan.add(header);
        topPan.add(midPan);
        
        this.add(topPan);
        
        //this.pack();
    }
    
    public void redraw(Component pan) {
        this.getContentPane().removeAll();
        this.add(pan);
        this.validate();
        this.getContentPane().repaint();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	System.setProperty("jdk.xml.entityExpansionLimit", "0");
    	Adapter.setXMLFileLocation("sample.xml");
    	EntityResolutionAdapter.initialize();   

    	SearchEngine se =	 new SearchEngine();
        se.setVisible(true);
    	/*java.util.List<String> x = new java.util.ArrayList<String>();
    	x.add("Relational");
    	x.add("relSort");
    	new QueryFactory("findByTitleTags",x,null);*/
    }
}
