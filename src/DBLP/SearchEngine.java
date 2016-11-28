package DBLP;

import javax.swing.*;
import java.awt.*;
import java.io.File;

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
        
        header = new Header();
        queryInputPan = new QueryInputPanel();
        queryOutputPan = new QueryOutputPanel();
        
        JPanel topPan = new JPanel();
        topPan.setLayout(new GridLayout(0, 1));
        JPanel midPan = new JPanel();
        midPan.setLayout(new GridLayout(0, 2));
        
        midPan.add(queryInputPan);
        midPan.add(queryOutputPan);
        
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
        //SearchEngine se = new SearchEngine();
        //se.setVisible(true);
    	   
    	XMLParser x = XMLParser.getInstance();
    	x.parseFile(new File("sample.xml"));
    }
}
