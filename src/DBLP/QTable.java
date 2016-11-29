package DBLP;

import javax.swing.*;

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
