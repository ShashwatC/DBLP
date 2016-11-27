package DBLP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** \class QueryInputPanel
 *  \brief Inputs various params for different kinds of queries
 */
public class QueryInputPanel extends JPanel {
    private JComboBox queryBox;
    private Query1Pan query1Pan;
    private Query2Pan query2Pan;

    public QueryInputPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
        query1Pan = new Query1Pan();
        query2Pan = new Query2Pan();
        
        String[] queryList = {"Queries", "Query 1", "Query 2"};
        queryBox = new JComboBox(queryList);
        
        queryBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        query1Pan.setAlignmentX(Component.CENTER_ALIGNMENT);
        query2Pan.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        queryBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String qName = (String)cb.getSelectedItem();

                if (qName.equals("Query 1")) {
                    Component[] compList = {queryBox, query1Pan};
                    redraw(compList);
                }
                else if (qName.equals("Query 2")) {
                    Component[] compList = {queryBox, query2Pan};
                    redraw(compList);
                }
                else {
                    Component[] compList = {queryBox};
                    redraw(compList);
                }
            }
        });
        
        this.add(Box.createRigidArea(
                new Dimension(SearchEngine.FRAMEW, SearchEngine.FRAMEH/6)));
        this.add(queryBox);
        this.add(Box.createRigidArea(
                new Dimension(SearchEngine.FRAMEW, SearchEngine.FRAMEH/6)));
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

        public Query1Pan() {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            //this.setLayout(new GridLayout(0, 1));
            
            textFieldPan = new JPanel();
            radioButtonPan = new JPanel();

            String[] searchByList = {"Search By", "Author name", "Title tags"};
            searchByBox = new JComboBox(searchByList);
            
            makeTextFieldPan();
            makeRadioButtonPan();

            searchByBox.setAlignmentX(Component.CENTER_ALIGNMENT);
            textFieldPan.setAlignmentX(Component.CENTER_ALIGNMENT);
            radioButtonPan.setAlignmentX(Component.CENTER_ALIGNMENT);
            
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

            JRadioButton sortYearB = new JRadioButton("Sort By Year");
            JRadioButton sortRelB = new JRadioButton("Sort By Relevance");
            ButtonGroup sortGroup = new ButtonGroup();

            //sortYearB.addActionListener(this);
            //sortRelB.addActionListener(this);

            sortGroup.add(sortYearB);
            sortGroup.add(sortRelB);

            radioButtonPan.add(sortYearB);
            radioButtonPan.add(sortRelB);
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
    }
}
