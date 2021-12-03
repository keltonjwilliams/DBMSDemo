/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package DBMSDemo;

import bo.MainSeq;
import dao.MainSeqHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author upadhyaya
 */
public class FormViewMainSeq extends javax.swing.JInternalFrame {
    
    private MainSeqHandler msh = new MainSeqHandler();
    
    private void refreshTableMainSeq(){
        populateMainSeq();
    }
    
    List<MainSeq> mainSeqs;
    
        private void populateMainSeq(){
        String keyword = txtCO.getText();
        mainSeqs = msh.loadMainSeq(keyword);
        String columns[] = new String[] {"MSID","Age","SpectralType"};
        DefaultTableModel tblModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        mainSeqs.forEach((constellation)->{
            //convert into a row and add
            tblModel.addRow(constellation.getRow());
        });
        tblMS.setModel(tblModel);
    }

    /**
     * Creates new form FormViewMainSeq
     */
    public FormViewMainSeq() {
        initComponents();
        populateMainSeq();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMS = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCO = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Main Sequence");

        tblMS.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMS);

        jLabel1.setText("Search");

        txtCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCOActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txtCO, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtCO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMSMouseClicked
        // if it is double clicked
        if(evt.getClickCount() == 2){
            //get the selected row
            MainSeq mainSeq = mainSeqs.get(tblMS.getSelectedRow());
            //show form
            FormUpdateMainSeq formUpdateMainSeqs = new FormUpdateMainSeq(null, true);
            formUpdateMainSeqs.setMainSeq(mainSeq);
            formUpdateMainSeqs.setVisible(true);

            if(formUpdateMainSeqs.getReturnStatus() == FormUpdateMainSeq.RET_OK){
                //refresh table
                refreshTableMainSeq();
            }
        }
    }//GEN-LAST:event_tblMSMouseClicked

    private void txtCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCOActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        populateMainSeq();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //get the selected row
        int selectedRow = tblMS.getSelectedRow();
        if(selectedRow != -1){
            //perform the delete
            String MSID = (String) tblMS.getValueAt(selectedRow, 0);
            int ret = JOptionPane.showConfirmDialog(this, String.format("Deleting MainSeq id %s", MSID));
            if (ret == JOptionPane.OK_OPTION){
                msh.deleteMainSeq(MSID);
                refreshTableMainSeq();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please select a row to delete!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTableMainSeq();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMS;
    private javax.swing.JTextField txtCO;
    // End of variables declaration//GEN-END:variables
}
