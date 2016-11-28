package DBLP;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Query2Pan extends JPanel {
    JTextField nofPubF;

    public Query2Pan() {
        this.setLayout(new GridLayout(0, 2));

        PrettyLabel nofPubL = new PrettyLabel("No. of Publications");
        nofPubF = new JTextField();

        this.add(nofPubL);
        this.add(nofPubF);
    }
    
    public ArrayList<? extends Object> formContentsValid() {
        ArrayList<String> ret = new ArrayList<String>();
        
        String nofPubT = nofPubF.getText();
        ret.add(nofPubT);
        
        if (nofPubT.isEmpty())
            return null;
        else if (!nofPubT.chars().allMatch(Character::isDigit))
            return null;
        else
            return ret;
    }
}