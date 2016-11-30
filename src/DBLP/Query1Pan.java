package DBLP;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/** \class Query1Pan
 *  \brief GUI input panel for Query 1
 */
/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
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
        sinceYearF = new JTextField();

        PrettyLabel customRangeL = new PrettyLabel("Custom Range");
        customRange1F = new JTextField();
        customRange2F = new JTextField();
        JPanel customRangeF = new JPanel();
        customRangeF.setLayout(new BoxLayout(customRangeF, BoxLayout.X_AXIS));
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
        
        String searchByT = (String)searchByBox.getSelectedItem();
        
        String nameTitleT = nameTitleF.getText();
        String sinceYearT = sinceYearF.getText();
        String customRange1T = customRange1F.getText();
        String customRange2T = customRange2F.getText();
        
        boolean sortYearS = sortYearB.isSelected();
        boolean sortRelS = sortRelB.isSelected();
        
        ///< search type must be selected
        if (searchByT.equals("Search By"))
            return null;
        ///< empty name/title not allowed
        else if (nameTitleT.isEmpty())
            return null;
        ///< if both sinceYear and customRange exist, clash, not allowed (?)
        //else if (!sinceYearT.isEmpty() && 
        //        !(customRange1T.isEmpty() && customRange2T.isEmpty()))
        //    return null;
        ///< if only one out of customRange is defined
        else if ((customRange1T.isEmpty() ^ customRange2T.isEmpty()))
            return null;
        ///< all year empty not allowed (not sure?)
        //else if (sinceYearT.isEmpty() && customRange1T.isEmpty() && customRange2T.isEmpty())
        //  return null;
        ///< one radio button must be selected (?)
        //else if (!sortYearS && !sortRelS)
        //    return null;
        
        ///< checking for numerical values; if not, invalid
        if (!sinceYearT.isEmpty() && !sinceYearT.chars().allMatch(Character::isDigit))
            return null;
        if (!customRange1T.isEmpty() && !customRange1T.chars().allMatch(Character::isDigit))
            return null;
        if (!customRange2T.isEmpty() && !customRange2T.chars().allMatch(Character::isDigit))
            return null;
                    
        ///< Return appropriate list of params for Model, Parser, whatever
        ///< Following API for QueryFactory:
        String arg0 = new String();
        ArrayList<String> arg1 = new ArrayList<String>();
        ArrayList<Integer> arg2 = new ArrayList<Integer>();
        
        if (searchByT.equals("Author name"))
            arg0 = "findByAuthor";
        else if (searchByT.equals("Title tags"))
            arg0 = "findByTitleTags";
        
        arg1.add(nameTitleT);
        
        if (sortYearS)
            arg1.add("dateSort");
        else if (sortRelS)
            arg1.add("relSort");
        
        int sinceY = 0;
        int customR1 = 0;
        int customR2 = 0;
        
        if (!sinceYearT.isEmpty()) {
            arg1.add("since");
            sinceY = Integer.parseInt(sinceYearT);
        }
        if (!customRange1T.isEmpty() && !customRange2T.isEmpty()) {
            arg1.add("between");
            customR1 = Integer.parseInt(customRange1T);
            customR2 = Integer.parseInt(customRange2T);
        }
        
        if (customR1 > customR2)
            return null;
        if (sinceY != 0 && customR1 == 0 && customR2 == 0)
            arg2.add(sinceY);
        else if (customR1 != 0 && customR2 != 0) {
            arg2.add(Math.max(sinceY, customR1));
            arg2.add(customR2);
        }
        else if (sinceY == 0 && customR1 == 0 && customR2 == 0) {
            arg2 = null;
        }
        
        for (String tmp : arg1)
            System.out.println(tmp);

        ArrayList<Object> ret = new ArrayList<Object>();
        ret.add(arg0);
        ret.add(arg1);
        ret.add(arg2);
        System.out.println("Arg0: "+arg0);
        System.out.println("Arg1:");
        if (arg1!=null){
        	for (String s: arg1){
        		System.out.println(s);
        	}
        }
        System.out.println("Arg2:");
        if (arg2!=null){
        	for (int i: arg2){
        		System.out.println(i);
        	}
        }
        
        return ret;
    }
}
