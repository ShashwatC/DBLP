package DBLP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public abstract class QueryModel extends AbstractTableModel {
    private Object[][] data = {};
    
    /*Object[][] data = {
    {new Integer(0), "Yo Yo Honey Singh", "High Heels",
        new Integer(2), new Integer(2006), new Integer(1), "idk", "www.blah.com"},
    {new Integer(1), "lelelel Honey Singh", "moo Heels",
            new Integer(5), new Integer(2003), new Integer(4), "idk", "www.blah.com"},
    };*/
    
    public int getRowCount() {
        return data.length;
    }
    
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public abstract void refreshTable(ArrayList<? extends Object> objList, int start);
}
