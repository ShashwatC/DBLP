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
    
    private int currQType;
    
    public QueryInputPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(SearchEngine.FRAMEW/3, SearchEngine.FRAMEH));
       
        String[] queryList = {"Queries", "Query 1", "Query 2"};
        queryBox = new JComboBox(queryList);
        queryBox.setMaximumSize(queryBox.getPreferredSize());
        
        currQType = 0;
        reset();
                
        queryBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String qName = (String)cb.getSelectedItem();

                if (qName.equals("Query 1")) {
                    currQType = 1;
                    redraw(comp1List);
                }
                else if (qName.equals("Query 2")) {
                    currQType = 2;
                    redraw(comp2List);
                }
                else {
                    currQType = 0;
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

    private void redraw(Component[] panList) {
        this.removeAll();

        for (Component pan : panList) {
            this.add(pan);
        }

        this.validate();
        this.repaint();
    }
    
    private void reset() {
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
            
            invalidL.setAlignmentX(CENTER_ALIGNMENT);
            
            searchB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ArrayList<? extends Object> params = new ArrayList<Object>();
                    
                    switch(currQType) {
                        case 1: params = query1Pan.formContentsValid(); break;
                        case 2: params = query2Pan.formContentsValid(); break;
                        default: break;
                    }
                    
                    if (params != null) {
                        invalidL.setVisible(false);
                        ///< We pass it to the Model (Query, Parser, whatever)
                    }
                    else {
                        invalidL.setVisible(true);
                    }
                }
            });
            
            resetB.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    reset();
                    switch(currQType) {
                        case 0: redraw(comp0List); break;
                        case 1: redraw(comp1List); break;
                        case 2: redraw(comp2List); break;
                        default: break;
                    }
                }
            });
            
            midPan.add(searchB);
            midPan.add(resetB);
            
            this.add(invalidL);
            this.add(midPan);
        }
    }
}
