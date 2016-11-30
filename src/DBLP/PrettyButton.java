package DBLP;

import javax.swing.*;
import java.awt.*;

/** \class PrettyButton
 *  \brief Well, it's a prettier button...
 */
/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class PrettyButton extends JButton {
    public PrettyButton(String txt, Color col) {
        super(txt);
        this.setBackground(col);
        this.setForeground(Color.WHITE);
        this.setFont(SearchEngine.PFONT);
    }
}
