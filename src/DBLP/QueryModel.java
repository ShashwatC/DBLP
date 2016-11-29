package DBLP;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public abstract class QueryModel extends AbstractTableModel {
    private Object[][] data;
    
    public QueryModel(int nofRow, int nofCol) {
        data = new Object[nofRow][nofCol];
        for (int i = 0; i < nofRow; i++) {
            for (int j = 0; j < nofCol; j++) {
                data[i][j] = "";
                fireTableCellUpdated(i, j);
            }
        }
    }
    
    public int getRowCount() {
        return data.length;
    }
    
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    //public Class getColumnClass(int c) {
    //    return getValueAt(0, c).getClass();
    //}
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public abstract void refreshTable(ArrayList<? extends Object> objList, int start);
}
