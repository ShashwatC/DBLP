package DBLP;

import java.util.ArrayList;

/**
 * @author Shashwat Chaudhary 2015091
 * @author Radhika Ghosal 2015160
 */
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

    public Query1Model() {
        super(SearchEngine.NOFROWS, 8);
    }
    
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
        int bigEnd=0;
        if (end%20==0){
        	bigEnd = end;
        }
        else{
        	bigEnd = end + (20-(end%20));
        }
        
        for(int i = start; i < end; i++) {
            int row = i % 20;
            Publication pub = pubList.get(i);            
            this.setValueAt(i, row, 0);
            
            String nameStr = new String();
            if (pub.getAuthorNameList()==null){
            	nameStr = "";
            }
            else{
            for (String nam : pub.getAuthorNameList()) {
                nameStr += String.format("%s, ", nam);
            }}
            this.setValueAt(nameStr, row, 1);
            
            this.setValueAt(pub.getTitle(), row, 2);
            System.out.println(pub.getTitle()+" at S.No. "+i);
            this.setValueAt(pub.getNumPages(), row, 3);
            this.setValueAt(pub.getYear(), row, 4);
            this.setValueAt(pub.getVolume(), row, 5);
            this.setValueAt(pub.getJournalBook(), row, 6);
            this.setValueAt(pub.getUrl(), row, 7);
        }
        for (int i=end;i<bigEnd;i++){
        	int row = i%20;
        	this.setValueAt("", row, 0);
            this.setValueAt("", row, 1);            
            this.setValueAt("", row, 2);
            this.setValueAt("", row, 3);
            this.setValueAt("", row, 4);
            this.setValueAt("", row, 5);
            this.setValueAt("", row, 6);
            this.setValueAt("", row, 7);
        }
    }
}