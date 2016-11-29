package DBLP;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/** \class QueryOutputPanel
 *  \brief Outputs search results in tabular form.
 */
public class QueryOutputPanel extends JPanel {
    PrettyLabel nofResL;
    QTable table;
    PrettyButton nextB;
    ArrayList<? extends Object> queryData;
    
    int qType;
    int pos;
    int nofRes;
    
    public QueryOutputPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.setMaximumSize(new Dimension((SearchEngine.FRAMEW*2)/3, SearchEngine.FRAMEH));
        
        queryData = new ArrayList<Object>();
        pos = 0;
        qType = 1;
        nofRes = 0;
        
        nofResL = new PrettyLabel(String.format("No. of results returned: %d", nofRes));
        nofResL.setAlignmentX(LEFT_ALIGNMENT);
        
        nextB = new PrettyButton("Next", Color.RED);
        nextB.setAlignmentX(RIGHT_ALIGNMENT);
        nextB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pos < queryData.size() && qType != 0) {
                    table.getQueryModel().refreshTable(queryData, pos);
                    pos += 20;
                }
            }
        });
        
        reset();
    }
    
    private void reset() {
        QTable query1Table = new QTable(new Query1Model());
        QTable query2Table = new QTable(new Query2Model());
       
        nofResL.setText(String.format("No. of results returned: %d", nofRes));
        
        switch(qType) {
            case 1: table = query1Table; break;
            case 2: table = query2Table; break;
            default: break;
        }
        
        table.setPreferredScrollableViewportSize(new Dimension((SearchEngine.FRAMEW*2)/3, SearchEngine.FRAMEH));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        this.add(nofResL);
        this.add(scrollPane);
        this.add(nextB);
    }
    
    public void setQueryData(int qType, ArrayList<Object> queryData) {
        this.queryData = queryData;
        this.pos = 0;
        this.qType = qType;
        this.nofRes = queryData.size();
        
        reset();
    }
}
