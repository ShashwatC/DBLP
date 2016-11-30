package DBLP;

import javax.swing.*;
import java.awt.*;

/** \class PrettyLabel
 *  \brief Well, it's a prettier label...
 */
/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class PrettyLabel extends JLabel {

    public PrettyLabel(String txt, Font font) {
        super(txt);
        this.setFont(font);
        this.setForeground(Color.DARK_GRAY);
    }

    public PrettyLabel(String txt) {
            super(txt);
            this.setFont(SearchEngine.PFONT);
            this.setForeground(Color.DARK_GRAY);
    }
    
    public PrettyLabel(String txt, Color col) {
        super(txt);
        this.setFont(SearchEngine.PFONT);
        this.setForeground(col);
    }
}
