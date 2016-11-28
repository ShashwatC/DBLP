package DBLP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/** \class QueryInputPanel
 *  \brief Inputs various params for different kinds of queries
 */
public class QueryInputPanel extends JPanel {
    private JComboBox queryBox;
    private Query1Pan query1Pan;
    private Query2Pan query2Pan;
    private SearchResetPan searchResetPan;
    private Component[] comp0List;
    private Component[] comp1List;
    private Component[] comp2List;
    
    public QueryInputPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH));
       
        String[] queryList = {"Queries", "Query 1", "Query 2"};
        queryBox = new JComboBox(queryList);
        queryBox.setMaximumSize(queryBox.getPreferredSize());
        
        query1Pan = new Query1Pan();
        query2Pan = new Query2Pan();
        searchResetPan = new SearchResetPan();
        comp0List = new Component[5];
        comp1List = new Component[5];
        comp2List = new Component[5];
        
        ///< For Query 1
        Component[] comp1List = {
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/6)),
                queryBox, query1Pan, searchResetPan,
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/3))
        };
        System.arraycopy(comp1List, 0, this.comp1List, 0, comp1List.length);
        
        ///< For Query 2
        Component[] comp2List = {
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/6)),
                queryBox, query2Pan, searchResetPan,
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/3))
        };
        System.arraycopy(comp2List, 0, this.comp2List, 0, comp2List.length);
        
        ///< For empty query
        Component[] comp0List = {
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW, SearchEngine.FRAMEH/6)),
                queryBox,
                Box.createRigidArea(
                        new Dimension(SearchEngine.FRAMEW, SearchEngine.FRAMEH/3))
        };
        System.arraycopy(comp0List, 0, this.comp0List, 0, comp0List.length);
        
        queryBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String qName = (String)cb.getSelectedItem();

                if (qName.equals("Query 1")) {
                    redraw(comp1List);
                }
                else if (qName.equals("Query 2")) {
                    redraw(comp2List);
                }
                else {
                    redraw(comp0List);
                }
            }
        });
        
        this.add(Box.createRigidArea(
                new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/6)));
        this.add(queryBox);
        this.add(Box.createRigidArea(
                new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH/3)));
    }

    public void redraw(Component[] panList) {
        this.removeAll();

        for (Component pan : panList) {
            this.add(pan);
        }

        this.validate();
        this.repaint();
    }

    private class Query1Pan extends JPanel {
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
            JTextField nameTitleF = new JTextField();

            PrettyLabel sinceYearL = new PrettyLabel("Since Year");
            JTextField sinceYearF = new JTextField("YYYY");

            PrettyLabel customRangeL = new PrettyLabel("Custom Range");
            JTextField customRange1F = new JTextField("YYYY");
            JTextField customRange2F = new JTextField("YYYY");
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

            //sortYearB.addActionListener(this);
            //sortRelB.addActionListener(this);

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
            
            return null;
        }
    }

    private class Query2Pan extends JPanel {
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
            else
                return ret;
        }
    }
    
    private class SearchResetPan extends JPanel {
        PrettyLabel invalidL;
        PrettyButton searchB;
        PrettyButton resetB;
        
        public SearchResetPan() {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
            JPanel midPan = new JPanel();
            midPan.setLayout(new BoxLayout(midPan, BoxLayout.X_AXIS));
            
            invalidL = new PrettyLabel("Parameters are invalid. Try again.", Color.RED);
            invalidL.setVisible(false);
            
            searchB = new PrettyButton("Search", Color.BLACK);
            resetB = new PrettyButton("Reset", Color.RED);
            
            midPan.add(searchB);
            midPan.add(resetB);
            
            this.add(invalidL);
            this.add(midPan);
        }
    }
}
