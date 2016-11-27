package DBLP;

import javax.swing.*;
import java.awt.*;

/** \class Header
 *  \brief Displays big-ass heading in window
 */
public class Header extends JPanel {
    public Header() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        PrettyLabel heading = new PrettyLabel("DBLP Query Engine", new Font("Arial", Font.BOLD, 35));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(heading);
    }    
}
