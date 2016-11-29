package DBLP;

import java.util.ArrayList;

public class Query1Model extends QueryModel {
    private String[] columnNames = {"S.no",
            "Authors",
            "Title",
            "Pages",
            "Year",
            "Volume",
            "Journal/Booktitle",
            "url"
    };

    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public void refreshTable(ArrayList<? extends Object> objList, int start) {
        ArrayList<Publication> pubList = (ArrayList<Publication>)objList;
        
        int end = (start + 20 <= pubList.size() ? start + 20 : pubList.size());
        
        for(int i = start; i < end; i++) {
            int row = i % 20;
            Publication pub = pubList.get(i);
            
            this.setValueAt(i, row, 0);
            
            String nameStr = new String();
            for (String nam : pub.getAuthorNameList()) {
                nameStr += String.format("%s, ", nam);
            }
            this.setValueAt(nameStr, row, 1);
            
            this.setValueAt(pub.getTitle(), row, 2);
            this.setValueAt(pub.getNumPages(), row, 3);
            this.setValueAt(pub.getYear(), row, 4);
            this.setValueAt(pub.getVolume(), row, 5);
            this.setValueAt(pub.getJournalBook(), row, 6);
            this.setValueAt(pub.getUrl(), row, 7);
        }
    }
}