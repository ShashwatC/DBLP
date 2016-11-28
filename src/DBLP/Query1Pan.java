package DBLP;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Query1Pan extends JPanel {
    JComboBox searchByBox;
    JPanel textFieldPan;
    JPanel radioButtonPan;

    JTextField nameTitleF;
    JTextField sinceYearF;
    JTextField customRange1F;
    JTextField customRange2F;

    JRadioButton sortYearB;
    JRadioButton sortRelB;
    
    public Query1Pan() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        textFieldPan = new JPanel();
        radioButtonPan = new JPanel();

        String[] searchByList = {"Search By", "Author name", "Title tags"};
        searchByBox = new JComboBox(searchByList);
        searchByBox.setMaximumSize(searchByBox.getPreferredSize());
        
        makeTextFieldPan();
        makeRadioButtonPan();

        this.add(searchByBox);
        this.add(textFieldPan);
        this.add(radioButtonPan);
    }

    private void makeTextFieldPan() {
        textFieldPan.setLayout(new GridLayout(0, 2));

        PrettyLabel nameTitleL = new PrettyLabel("Name/title tags");
        nameTitleF = new JTextField();

        PrettyLabel sinceYearL = new PrettyLabel("Since Year");
        sinceYearF = new JTextField("YYYY");

        PrettyLabel customRangeL = new PrettyLabel("Custom Range");
        customRange1F = new JTextField("YYYY");
        customRange2F = new JTextField("YYYY");
        JPanel customRangeF = new JPanel();
        customRangeF.add(customRange1F);
        customRangeF.add(new PrettyLabel("-"));
        customRangeF.add(customRange2F);

        textFieldPan.add(nameTitleL);
        textFieldPan.add(nameTitleF);
        textFieldPan.add(sinceYearL);
        textFieldPan.add(sinceYearF);
        textFieldPan.add(customRangeL);
        textFieldPan.add(customRangeF);
    }

    private void makeRadioButtonPan() {
        radioButtonPan.setLayout(new GridLayout(0, 1));

        sortYearB = new JRadioButton("Sort By Year");
        sortRelB = new JRadioButton("Sort By Relevance");
        ButtonGroup sortGroup = new ButtonGroup();

        sortGroup.add(sortYearB);
        sortGroup.add(sortRelB);

        radioButtonPan.add(sortYearB);
        radioButtonPan.add(sortRelB);
    }
    
    public ArrayList<? extends Object> formContentsValid() {
        
        String nameTitleT = nameTitleF.getText();
        String sinceYearT = sinceYearF.getText();
        String customRange1T = customRange1F.getText();
        String customRange2T = customRange2F.getText();
        
        boolean sortYearS = sortYearB.isSelected();
        boolean sortRelS = sortRelB.isSelected();
        
        ///< empty name/title not allowed
        if (nameTitleT.isEmpty())
            return null;
        ///< if both sinceYear and customRange exist, clash, not allowed
        else if (!sinceYearT.isEmpty() && 
                !(customRange1T.isEmpty() && customRange2T.isEmpty()))
            return null;
        ///< if no sinceYear and only one out of customRange is defined
        else if (sinceYearT.isEmpty() &&
                (customRange1T.isEmpty() ^ customRange2T.isEmpty()))
            return null;
        ///< all year empty not allowed (not sure?)
        else if (sinceYearT.isEmpty() && customRange1T.isEmpty() && customRange2T.isEmpty())
            return null;
        ///< one radio button must be selected
        else if (!sortYearS && !sortRelS)
            return null;
        
        ///< checking for numerical values; if not, invalid
        if (!sinceYearT.isEmpty() && !sinceYearT.chars().allMatch(Character::isDigit))
            return null;
        if (!customRange1T.isEmpty() && !customRange1T.chars().allMatch(Character::isDigit))
            return null;
        if (!customRange2T.isEmpty() && !customRange2T.chars().allMatch(Character::isDigit))
            return null;
                    
        ///< Return appropriate list of params for Model, Parser, whatever
        ///< Query type?
        ArrayList<Object> ret = new ArrayList<Object>();
        ret.add(nameTitleT);
        ret.add(sinceYearT);
        ret.add(customRange1T);
        ret.add(customRange2T);
        ret.add(sortYearS);
        ret.add(sortRelS);
        
        return ret;
    }
}