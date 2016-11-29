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
        String nofPubT = nofPubF.getText();
        
        if (nofPubT.isEmpty())
            return null;
        else if (!nofPubT.chars().allMatch(Character::isDigit))
            return null;
        else {
            String arg0 = new String("moreThanK");
            ArrayList<String> arg1 = null;
            ArrayList<Integer> arg2 = new ArrayList<Integer>();
            arg2.add(Integer.parseInt(nofPubT));
            
            ArrayList<Object> ret = new ArrayList<Object>();
            ret.add(arg0);
            ret.add(arg1);
            ret.add(arg2);
            
            return ret;
        }
    }
}