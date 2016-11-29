package DBLP;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Query3Pan extends JPanel {
    JTextField yearF;
    ArrayList<JTextField> authF;
    
    public Query3Pan() {
        this.setLayout(new GridLayout(0, 1));
        
        authF = new ArrayList<JTextField>();
        
        PrettyLabel yearL = new PrettyLabel("Year");
        yearF = new JTextField(10);
        
        PrettyLabel authL = new PrettyLabel("Authors");
        
        this.add(yearL);
        this.add(yearF);
        this.add(authL);
        for (int i = 0; i < 5; i++) {
            authF.add(new JTextField());
            this.add(authF.get(i));
        }
    }
    
    public ArrayList<? extends Object> formContentsValid() {
        String yearT = yearF.getText();
        ArrayList<String> authT = new ArrayList<String>();
        
        if (yearT.isEmpty())
            return null;
        else if (!yearT.chars().allMatch(Character::isDigit))
            return null;
        
        for (JTextField auth : authF) {
            if (auth.getText().isEmpty())
                return null;
            else
                authT.add(auth.getText());
        }
        
        ArrayList<Object> ret = new ArrayList<Object>();
        ret.add(authT);
        ret.add(Integer.parseInt(yearT));        
        return ret;
    }
}
