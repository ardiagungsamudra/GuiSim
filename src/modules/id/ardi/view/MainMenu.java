/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainMenu.java
 *
 * Created on Aug 22, 2012, 11:53:30 AM
 */
package modules.id.ardi.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import modules.id.ardi.model.FieldModel;
import modules.id.ardi.model.TableMTIModel;
import modules.id.ardi.server.SimServer;

/**
 *
 * @author user
 */
public class MainMenu extends javax.swing.JFrame {

    /** Creates new form MainMenu */
    public MainMenu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLbl_IP = new javax.swing.JLabel();
        jLbl_Port = new javax.swing.JLabel();
        jLbl_TPDU = new javax.swing.JLabel();
        jTF_IP = new javax.swing.JTextField();
        jTF_Port = new javax.swing.JTextField();
        jTF_TPDU = new javax.swing.JTextField();
        jBStart = new javax.swing.JButton();
        jBStop = new javax.swing.JButton();
        jLbl_Header = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_MTI = new javax.swing.JTable();
        jB_AddMTI = new javax.swing.JButton();
        jB_DelMTI = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jM_File = new javax.swing.JMenu();
        jMI_Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLbl_IP.setText("Ip ");

        jLbl_Port.setText("Port ");

        jLbl_TPDU.setText("TPDU ");

        jTF_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_IPActionPerformed(evt);
            }
        });

        jBStart.setText("Start");
        jBStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStartActionPerformed(evt);
            }
        });

        jBStop.setText("Stop");
        jBStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStopActionPerformed(evt);
            }
        });

        jLbl_Header.setText("SIMULATOR ARDI");

        tm = new TableMTIModel();
        jTbl_MTI.setModel(tm);
        buttonRenderer = new ButtonRenderer();
        buttonEditor = new ButtonEditor(new JCheckBox());
        jTbl_MTI.getColumn("Fields").setCellRenderer(buttonRenderer);
        jTbl_MTI.getColumn("Fields").setCellEditor(
            buttonEditor);
        mIso = buttonEditor.getMap();
        jTbl_MTI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbl_MTIMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTbl_MTIMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTbl_MTI);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jB_AddMTI.setText("Add MTI");
        jB_AddMTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AddMTIActionPerformed(evt);
            }
        });

        jB_DelMTI.setText("Del MTI");
        jB_DelMTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DelMTIActionPerformed(evt);
            }
        });

        jM_File.setText("File");

        jMI_Exit.setText("Exit");
        jMI_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_ExitActionPerformed(evt);
            }
        });
        jM_File.add(jMI_Exit);

        jMenuBar1.add(jM_File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbl_Port)
                            .addComponent(jLbl_IP)
                            .addComponent(jLbl_TPDU))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTF_IP, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jTF_Port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(jTF_TPDU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBStop, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBStart, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jB_DelMTI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_AddMTI, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLbl_Header)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLbl_Header)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTF_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLbl_IP))
                    .addComponent(jBStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBStop)
                    .addComponent(jLbl_Port))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_TPDU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbl_TPDU))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jB_AddMTI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jB_DelMTI)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_IPActionPerformed

    private void jBStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStopActionPerformed
        // TODO add your handling code here:
        server.poweroff();

    }//GEN-LAST:event_jBStopActionPerformed

    private void jMI_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jMI_ExitActionPerformed

    private void jBStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStartActionPerformed
        // TODO add your handling code here:
        int port = Integer.parseInt(jTF_Port.getText());
        
        setISO(buttonEditor.getMap());  // It's time to fill up mIso variable
        
        /* Convert string to byte */
        byte[] tpdu = jTF_TPDU.getText().getBytes();
        for (int i = 0; i < tpdu.length; i++) {
            tpdu[i] -= 48; //get hexdecimal from string as bytes
        }
        server = new SimServer(port, tpdu, mIso);
    }//GEN-LAST:event_jBStartActionPerformed

    private void setISO(Map m1) {
        for(int i=0; i<tm.getRowCount(); i++){
            mIso.put(tm.getValueAt(i, 0).toString(), m1.get(i));
        }
    }

    private void jB_DelMTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DelMTIActionPerformed
        // TODO add your handling code here:        
        tm.removeRow();
        
    }//GEN-LAST:event_jB_DelMTIActionPerformed

    private void jB_AddMTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AddMTIActionPerformed
        // TODO add your handling code here:
        tm.addRow();
    }//GEN-LAST:event_jB_AddMTIActionPerformed

    private void jTbl_MTIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_MTIMouseClicked
        // TODO add your handling code here:        
}//GEN-LAST:event_jTbl_MTIMouseClicked

    private void jTbl_MTIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_MTIMousePressed
        // TODO add your handling code here:
        int row = jTbl_MTI.rowAtPoint(evt.getPoint());
        System.out.println("row " + row);
        buttonEditor.setKey(row);
    }//GEN-LAST:event_jTbl_MTIMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBStart;
    private javax.swing.JButton jBStop;
    private javax.swing.JButton jB_AddMTI;
    private javax.swing.JButton jB_DelMTI;
    private javax.swing.JLabel jLbl_Header;
    private javax.swing.JLabel jLbl_IP;
    private javax.swing.JLabel jLbl_Port;
    private javax.swing.JLabel jLbl_TPDU;
    private javax.swing.JMenuItem jMI_Exit;
    private javax.swing.JMenu jM_File;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_IP;
    private javax.swing.JTextField jTF_Port;
    private javax.swing.JTextField jTF_TPDU;
    TableMTIModel tm = null;
    private javax.swing.JTable jTbl_MTI;
    ButtonRenderer buttonRenderer = null;
    ButtonEditor buttonEditor = null;
    // End of variables declaration//GEN-END:variables
    private SimServer server = null;
    List<FieldModel> lh = new ArrayList<FieldModel>();
    Map mIso = new HashMap();
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

/**
 * @version 1.0 11/09/98
 */
class ButtonEditor extends DefaultCellEditor {

    Map m1 = new HashMap();
    int key;
    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TblField tbf = null;
                List<FieldModel> listFields = new ArrayList<FieldModel>();      //listfields that will use for transient memory

                if (m1.containsKey(key)) {
                    listFields = (List) m1.get(key);    //get list from key
                } else if (!m1.containsKey(key)) {
                    listFields.removeAll(listFields);   //remove list if key never exist
                }

                tbf = new TblField(listFields, null, true); //show dialog table field
                m1.put(key, tbf.getListField());
               
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            //
            //
            JOptionPane.showMessageDialog(button, label + ": Ouch!");
            // System.out.println(label + ": Ouch!");
        }
        isPushed = false;
        return new String(label);
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Map getMap() {
        return m1;
    }
}
