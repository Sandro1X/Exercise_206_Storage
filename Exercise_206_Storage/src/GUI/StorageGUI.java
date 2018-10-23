package GUI;

import BL.TableModel;
import BL.TableRenderer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StorageGUI extends javax.swing.JFrame {
    private TableModel model = new TableModel();
    private TableRenderer renderer = new TableRenderer();
    private File f = new File("src\\data.bin");
    
    public StorageGUI() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        table.setModel(model);
        table.setDefaultRenderer(Object.class, renderer);
        
        try{
            model.load(f);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Load error!");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miRemove = new javax.swing.JMenuItem();
        miEdit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miBuy = new javax.swing.JMenuItem();
        miSell = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jMenu1.setText("Management");

        miAdd.setText("Add New Article");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jMenu1.add(miAdd);

        miRemove.setText("Remove Selected Article");
        miRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemoveActionPerformed(evt);
            }
        });
        jMenu1.add(miRemove);

        miEdit.setText("Edit Selected Article");
        miEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEditActionPerformed(evt);
            }
        });
        jMenu1.add(miEdit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Buy / Sell");

        miBuy.setText("Buy Selected Article");
        miBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBuyActionPerformed(evt);
            }
        });
        jMenu2.add(miBuy);

        miSell.setText("Sell Selected Article");
        miSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSellActionPerformed(evt);
            }
        });
        jMenu2.add(miSell);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        StorageDlg dlg = new StorageDlg(this,true);
        dlg.setVisible(true);
        
        if(dlg.isOk()){
            model.add(dlg.getA());
        }
    }//GEN-LAST:event_miAddActionPerformed

    private void miRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemoveActionPerformed
        model.delete(table.getSelectedRow());
    }//GEN-LAST:event_miRemoveActionPerformed

    private void miEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEditActionPerformed
        StorageDlg dlg = new StorageDlg(this,true);
        dlg.edit(model.getArticles().get(table.getSelectedRow()));
        dlg.setVisible(true);
        model.change(table.getSelectedRow(), dlg.getA());
        model.fireTableDataChanged();
    }//GEN-LAST:event_miEditActionPerformed

    private void miBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBuyActionPerformed
        try {
            model.getArticles().get(table.getSelectedRow()).buy();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_miBuyActionPerformed

    private void miSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSellActionPerformed
        try {
            model.getArticles().get(table.getSelectedRow()).sell();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        model.fireTableDataChanged();
    }//GEN-LAST:event_miSellActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            model.safe(f);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Safe error!");
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StorageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StorageGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StorageGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miBuy;
    private javax.swing.JMenuItem miEdit;
    private javax.swing.JMenuItem miRemove;
    private javax.swing.JMenuItem miSell;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
