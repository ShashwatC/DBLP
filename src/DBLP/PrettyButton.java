package DBLP;

import javax.swing.*;
import java.awt.*;

public class PrettyButton extends JButton {
    public PrettyButton(String txt, Color col) {
        super(txt);
        this.setBackground(col);
        this.setForeground(Color.WHITE);
        this.setFont(SearchEngine.PFONT);
    }
}
