package DBLP;

import java.util.ArrayList;

public class Query2Model extends QueryModel {
    private String[] columnNames = {
            "Author"
    };
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    } 
    
    @Override
    public void refreshTable(ArrayList<? extends Object> objList, int start) {
        ArrayList<Author> authList = (ArrayList<Author>)objList;
        
        int end = (start + 20 <= authList.size() ? start + 20 : authList.size());
        
        for(int i = start; i < end; i++) {
            int row = i % 20;
            Author auth = authList.get(i);
            
            this.setValueAt(auth.getPrimaryName(), row, 0);
        }
    }
}