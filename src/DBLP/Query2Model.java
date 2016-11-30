package DBLP;

import java.util.ArrayList;

/** \class Query2Model
 *  \brief Table model format for Query 2
 */
/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class Query2Model extends QueryModel {
    private String[] columnNames = {
            "Author"
    };
    
    public Query2Model() {
        super(SearchEngine.NOFROWS, 1);
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    } 
    
    @Override
    public void refreshTable(ArrayList<? extends Object> objList, int start) {
        ArrayList<String> authList = (ArrayList<String>)objList;
        
        int end = (start + SearchEngine.NOFROWS <= authList.size() ? start + SearchEngine.NOFROWS : authList.size());
        
        for(int i = start; i < end; i++) {
            int row = i % SearchEngine.NOFROWS;
            String auth = authList.get(i);
            
            this.setValueAt(auth, row, 0);
        }
    }
}