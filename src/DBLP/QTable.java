package DBLP;

import javax.swing.*;

/** \class QTable
 *  \brief A subclass of JTable to create tables for specific QueryModels
 */
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
