package DBLP;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/** \class SearchEngine
 *  \brief Overall GUI for application
 *  
 *  Contains Header, QueryInputPanel, QueryOutputPanel
 */

public class SearchEngine extends JFrame {
    
    static final Font PFONT = new Font("Arial", Font.PLAIN, 13);
    static final int FRAMEW = 800;
    static final int FRAMEH = 600;
    
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
    
    public static void main(String[] args) {
    	System.setProperty("jdk.xml.entityExpansionLimit", "0");
        
    	Adapter.setXMLFileLocation("sample.xml");
    	java.util.List<String> x = new java.util.ArrayList<String>();
    	x.add("Interactive Support for Non-Programmers: The Relational and Network Approaches.");
    	x.add("dateSort");
    	x.add("since");
    	ArrayList<Integer> y = new ArrayList<Integer>();
    	y.add(1972);
    	new QueryFactory("findByTitleTags",x,y);
    	x.set(2, "between");
    	y.add(1982);
    	x.set(0,new String("E. F. Codd") );
    	new QueryFactory("findByAuthor",x,y);
    	
    	/*
    	 * Format for QueryFactory
    	 * new QueryFacotry(arg0,arg1,arg2);
    	 * arg0 = what type of query you want
    	 * Options = "findByTitleTags", "findByAuthor", "moreThanK", "predict"
    	 * For "findByTitleTags" and "findByAuthor"
    	 * arg1 = Can range from 1 argument (title/name) to 4 argument (title/name + 3 out of 4 options)
    	 * first we need the title or author name
    	 * Next, what all options you want for displaying result
    	 * Options = "dateSort", "relSort", "between", "since" (note, dateSort and relSort can't be used simultaneously)
    	 * arg2 = 0,1 or 2 integers (integer ArrayList)
    	 * 1st integer, if present, is start year
    	 * 2nd integer, if present, is end year
    	 * For "moreThanK" 
    	 * arg1 = null
    	 * arg2 = (integer ArrayList) of size 1
    	 */
    	
    	new QueryFactory("findByAuthor",x);
    	
    	SearchEngine se = new SearchEngine();
        se.setVisible(true);
    }
}
