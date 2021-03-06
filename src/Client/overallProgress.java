/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Login.DBConnection;
import caseWorker.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Connor Aitken
 */
public class overallProgress extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    /**
     * Creates new form overallProgress
     */
    public overallProgress() {
        initComponents();
        idTextField.setVisible(false);
        userTextField.setVisible(false);
        passTextField.setVisible(false);
        
        String sql = "Select * From temp";
                    try {
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            String User = rs.getString("username");
                            userTextField.setText(User);
                            String Pass = rs.getString("password");
                            passTextField.setText(Pass);
                            JOptionPane.showMessageDialog(null, "done1");
                            }
                    }
                    catch (Exception e){}
                    
        String sql2 = "Select * From userclient Where username=? And password=?";
                    try {
                        PreparedStatement ps2 = conn.prepareStatement(sql2);
                        ps2.setString(1, userTextField.getText());
                        ps2.setString(2, passTextField.getText());
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            String ID = rs2.getString("id");
                            idTextField.setText(ID);
                            
                            JOptionPane.showMessageDialog(null, "done2");
                            }
                    }
                    catch (Exception e){}
                    
                    Show_Usage_In_Jtable();
    }
    
    // get a list of user from the mysql database
    
    public ArrayList<clientUnits> getUserList(){
       ArrayList<clientUnits> usersList = new ArrayList<clientUnits>();
       // set up the query 
       String query = "SELECT * FROM clientunitdata WHERE clientID='"+idTextField.getText()+"'";
       Statement st;
       ResultSet rs;
       
       // execute the query
       try{
           st = conn.createStatement();
           rs = st.executeQuery(query);
           clientUnits user;
           
        // add user objects to the ArrayList
        while(rs.next()) {
        user = new clientUnits(rs.getString("units"), rs.getString("date"), rs.getString("result"), rs.getString("note"));
        usersList.add(user);
         
        } // end of while loop 
       
       } catch (Exception e) {
         
       
       }// end of try catch block
      return usersList;
    }
    
    public void Show_Usage_In_Jtable() {
     // objects like jLists, jSpinner (Dropbox), jTable use a model for their information
     ArrayList<clientUnits> list = getUserList();
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     Object[] row = new Object[4];
     
     for(int i = 0; i < list.size(); i++) {// note no list.length() but size()
         row[0] = list.get(i).getUnits();
         row[1] = list.get(i).getDate();
         row[2] = list.get(i).getResult();
         row[3] = list.get(i).getNotes();
         
         model.addRow(row);
     } // end of for
    } // end of Show_User_In_Jtable()
    
    public void executeSQlQuery(String query, String message){
     Statement st;
     
     try{
         st = conn.createStatement();
         
         if((st.executeUpdate(query))==1){
             
                 // refreah jtable data
                 DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                 model.setRowCount(0);
                 Show_Usage_In_Jtable();
                 // dialogbox to show message
                 JOptionPane.showMessageDialog(null, "Data " + message + "Sucessful");
             } else {    
                 JOptionPane.showMessageDialog(null, "Data Not " + message);
             } // end of if 
         
     } catch (Exception ex) {
        
     }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        userTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Course Progress");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Units Complete", "Date", "Result", "Note"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        userTextField.setText("jTextField1");

        passTextField.setText("jTextField1");

        idTextField.setText("jTextField1");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(413, 413, 413))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(exitButton))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7)
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(18, 18, 18)
                        .addComponent(exitButton)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        String delete = "TRUNCATE TABLE temp";
        try {
            PreparedStatement psDel = conn.prepareStatement(delete);
            psDel.executeUpdate();
        } catch (Exception e){}

        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        contentsClient frame = new contentsClient();
        frame.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(overallProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(overallProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(overallProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(overallProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new overallProgress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField passTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
