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
public class TableFieldModel extends AbstractTableModel {

    String[] colom = {"Field", "Value", "Action"};
    FieldModel fm = new FieldModel("", "", false);
    List<FieldModel> lfm = new ArrayList<FieldModel>();

    public TableFieldModel(List l_fm) {
        System.out.println("MODEL");
        lfm = l_fm;        
        if(lfm.isEmpty())
            lfm.add(lfm.size(), fm);
        else
            lfm = l_fm;
    }

    public int getRowCount() {
        return lfm.size();
    }

    public int getColumnCount() {
        return colom.length;
    }

    @Override
    public String getColumnName(int col) {
        return colom[col];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lfm.get(rowIndex).getField();
            case 1:
                return lfm.get(rowIndex).getValue();
            case 2:
                return lfm.get(rowIndex).getStatus();
        }
        return null;
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object val, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :lfm.get(rowIndex).setField(val.toString());
            break;
            case 1 : lfm.get(rowIndex).setValue(val.toString());
            break;
            case 2 : lfm.get(rowIndex).setStatus((Boolean)val);
            break;
        }
        
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void addRow() {
        lfm.add(getRowCount(), new FieldModel("", "", false));
        fireTableDataChanged();
    }

    public void removeRow() {
        if (getRowCount() != 0) {
            lfm.remove(getRowCount() - 1);
            fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(null, "Upps, row is zero!!");
        }
    }

    public List getList() {
        return lfm;
    }
}

