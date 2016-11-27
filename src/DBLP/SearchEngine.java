package DBLP;

import javax.swing.*;
import java.awt.*;

/** \class SearchEngine
 *  \brief Overall GUI for application
 *  
 *  Contains Header, QueryInputPanel, QueryOutputPanel
 */

public class SearchEngine extends JFrame {
    
    static final Font PFONT = new Font("Arial", Font.PLAIN, 13);
    private static final int frameW = 800;
    private static final int frameH = 600;
    
    public SearchEngine() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(frameW, frameH);
        
        //this.add(new Header());
        this.add(new QueryInputPanel());
        //this.add(new QueryOutputPanel());
    }
    
    public void redraw(Component pan) {
        this.getContentPane().removeAll();
        this.add(pan);
        this.validate();
        this.getContentPane().repaint();
    }
    
    public static void main(String[] args) {
        SearchEngine se = new SearchEngine();
        se.setVisible(true);
    }
}
