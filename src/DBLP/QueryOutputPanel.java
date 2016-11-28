package DBLP;

import javax.swing.*;
import java.awt.*;

/** \class QueryOutputPanel
 *  \brief Outputs search results in tabular form.
 */
public class QueryOutputPanel extends JPanel {
    public QueryOutputPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.setMaximumSize(new Dimension((SearchEngine.FRAMEW*2)/3, SearchEngine.FRAMEH));
        
        String[] columnNames = {"S.no",
                "Authors",
                "Title",
                "Pages",
                "Year",
                "Volume",
                "Journal/Booktitle",
                "url"
        };
        
        Object[][] data = {
                {new Integer(0), "Yo Yo Honey Singh", "High Heels",
                    new Integer(2), new Integer(2006), new Integer(1), "idk", "www.blah.com"},
                {new Integer(1), "lelelel Honey Singh", "moo Heels",
                        new Integer(5), new Integer(2003), new Integer(4), "idk", "www.blah.com"},
        };
        
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension((SearchEngine.FRAMEW*2)/3, SearchEngine.FRAMEH));
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(scrollPane);
    }
}
