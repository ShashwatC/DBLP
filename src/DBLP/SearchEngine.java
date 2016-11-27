package DBLP;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** \class SearchEngine
 *  \brief Overall GUI for application
 *  
 *  Contains Header, QueryInputPanel, QueryOutputPanel
 */

public class SearchEngine extends JFrame {
    
    private final Font pFont = new Font("Arial", Font.PLAIN, 13);
    private final int frameW = 800;
    private final int frameH = 600;
    
    public SearchEngine() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(frameW, frameH);
        this.add(new Header());
        this.add(new QueryInputPanel());
        this.add(new QueryOutputPanel());
    }
    
    public void redraw(Component pan) {
        this.getContentPane().removeAll();
        this.add(pan);
        this.validate();
        this.getContentPane().repaint();
    }

    /** \class Header
     *  \brief Displays big-ass heading in window
     */
    public class Header extends JPanel {
        
    }
    
    /** \class QueryInputPanel
     *  \brief Inputs various params for different kinds of queries
     */
    public class QueryInputPanel extends JPanel {
        
    }
    
    /** \class QueryOutputPanel
     *  \brief Outputs search results in tabular form.
     */
    public class QueryOutputPanel extends JPanel {
        
    }
}
