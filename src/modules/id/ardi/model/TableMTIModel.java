/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.id.ardi.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableMTIModel extends AbstractTableModel{
    String[] colom = {"MTI", "Fields"};
    List<Helper> l = new ArrayList<Helper>();
    Helper hl = new Helper();
    
    public TableMTIModel () {        
        l.add(hl);        
    }
    
    public int getRowCount() {
       return l.size();
    }

    public int getColumnCount() {
       return colom.length;
    }

    @Override
    public String getColumnName(int col) {
        return colom[col];
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return l.get(rowIndex).getMTI();
        else
            return l.get(rowIndex).getButton();
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        switch(col) {
            case 0 : l.get(row).setMTI(value.toString()); break;
            default: break;
        }
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
       return true;
    }

    public void addRow() {
        l.add(getRowCount(), new Helper());
        fireTableDataChanged();
    }

    public void removeRow() {
        if(getRowCount() != 0) {
            l.remove(getRowCount() - 1);
            fireTableDataChanged();
        } else JOptionPane.showMessageDialog(null, "Upps, row is zero!!");
    }

    public List getList(){
        return l;
    }
}