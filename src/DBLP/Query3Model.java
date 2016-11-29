package DBLP;

import java.util.ArrayList;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
public class Query3Model extends QueryModel {
    private String[] columnNames = {
            "Predicted Value"
    };
    
    public Query3Model() {
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
        ArrayList<Integer> predList = (ArrayList<Integer>)objList;
        
        int end = (start + SearchEngine.NOFROWS <= predList.size() ? start + SearchEngine.NOFROWS : predList.size());
        
        for(int i = start; i < end; i++) {
            int row = i % SearchEngine.NOFROWS;
            int pred = predList.get(i);
            
            this.setValueAt(pred, row, 0);
        }
    }
}