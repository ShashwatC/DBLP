package DBLP;

import javax.swing.*;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class QTable extends JTable {
    QueryModel model;
    
    public QTable(QueryModel model) {
        super(model);
        this.model = model;
    }
    
    public QueryModel getQueryModel() {
        return model;
    }
}
