package DBLP;

import javax.swing.*;
import java.awt.*;

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
}
