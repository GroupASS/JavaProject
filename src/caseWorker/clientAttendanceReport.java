/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseWorker;

import Login.DBConnection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Connor Aitken
 */
public class clientAttendanceReport extends javax.swing.JFrame {
Connection conn = new DBConnection().connect();
    /**
     * Creates new form reports
     */
    public clientAttendanceReport() {
        initComponents();
        Show_Usage_In_Jtable();
    }
   
    // get a list of user from the mysql database
    
    public ArrayList<User> getUserList(){
       ArrayList<User> usersList = new ArrayList<User>();
       // set up the query 
       String query = "SELECT * FROM clientusage WHERE firstname='"+userTextField.getText()+"' AND lastname='"+passTextField.getText()+"'";
       //"+userTextField.getText()+"' AND lastname='"+passTextField.getText()+"'";//WHERE 'firstname'= 'Connor' AND 'lastname'= 'Aitken'";
       //String query = "SELECT * FROM 'clientusage' WHERE 'firstname' = '"+userTextField.getText()+"' AND 'lastname' = '"+passTextField.getText()+"'";
       Statement st;
       ResultSet rs;
       
       // execute the query
       try{
           st = conn.createStatement();
           rs = st.executeQuery(query);
           User user;
           
        // add user objects to the ArrayList
        while(rs.next()) {
        user = new User(rs.getString("firstname"), rs.getString("lastname"), rs.getString("date"));
        usersList.add(user);
         
        } // end of while loop 
       
       } catch (Exception e) {
         
       
       }// end of try catch block
      return usersList;
    }
    
    public void Show_Usage_In_Jtable() {
     // objects like jLists, jSpinner (Dropbox), jTable use a model for their information
     ArrayList<User> list = getUserList();
     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
     Object[] row = new Object[4];
     
     for(int i = 0; i < list.size(); i++) {// note no list.length() but size()
         row[0] = list.get(i).getFirstName();
         row[1] = list.get(i).getLastName();
         row[2] = list.get(i).getDate();
         model.addRow(row);
     } // end of for
    } // end of Show_User_In_Jtable()
    
    public void delete_data_in_table() {
    DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
    model2.setRowCount(0);
    }
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        studentLabel = new javax.swing.JLabel();
        lnLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        noOfSignInTextField = new javax.swing.JTextField();
        lastSignInTextField = new javax.swing.JTextField();
        lastnameTextField = new javax.swing.JTextField();
        firstnameTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JTextField();
        fnLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();
        studentLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        studentLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentLabel.setText("Student Name:");

        lnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lnLabel.setForeground(new java.awt.Color(255, 255, 255));
        lnLabel.setText("Last Name:");

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Last Signed In:");

        userLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("No of Sign Ins:");

        noOfSignInTextField.setMinimumSize(new java.awt.Dimension(125, 30));
        noOfSignInTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        lastSignInTextField.setMinimumSize(new java.awt.Dimension(125, 30));
        lastSignInTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        lastnameTextField.setMinimumSize(new java.awt.Dimension(125, 30));
        lastnameTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        firstnameTextField.setMinimumSize(new java.awt.Dimension(125, 30));
        firstnameTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        userTextField.setText("First Name");
        userTextField.setMinimumSize(new java.awt.Dimension(125, 25));
        userTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        passTextField.setText("Last Name");
        passTextField.setMinimumSize(new java.awt.Dimension(125, 25));
        passTextField.setPreferredSize(new java.awt.Dimension(125, 30));

        fnLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fnLabel.setForeground(new java.awt.Color(255, 255, 255));
        fnLabel.setText("First Name:");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        exitButton1.setText("Exit");
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });

        studentLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        studentLabel1.setForeground(new java.awt.Color(255, 255, 255));
        studentLabel1.setText("Client Attendance");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(studentLabel)
                                .addGap(18, 18, 18)
                                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lnLabel)
                                    .addComponent(emailLabel)
                                    .addComponent(userLabel)
                                    .addComponent(fnLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(firstnameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lastnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(noOfSignInTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lastSignInTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(421, 421, 421)
                                .addComponent(searchButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(studentLabel1)
                        .addGap(404, 404, 404))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton)
                            .addComponent(exitButton1))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(studentLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentLabel)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fnLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lnLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(lastSignInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel)
                            .addComponent(noOfSignInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(exitButton1)
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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        
        String query = "SELECT * FROM clientusage WHERE firstname=? AND lastname=? ORDER BY date DESC";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userTextField.getText());
            ps.setString(2, passTextField.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String FN = rs.getString("firstname");
                firstnameTextField.setText(FN);
                String LN = rs.getString("lastname");
                lastnameTextField.setText(LN);
                String LastSign = rs.getString("date");
                lastSignInTextField.setText(LastSign);
                String User = rs.getString("username");
                noOfSignInTextField.setText(User);

                delete_data_in_table();
            }
            else {
                JOptionPane.showMessageDialog(null, "Student Names Invalid");
            }
        }
        catch (Exception e){}
        
        
        delete_data_in_table();
        
        Show_Usage_In_Jtable();
        
        int rowNO = jTable1.getRowCount();
        noOfSignInTextField.setText(String.valueOf(rowNO));
        
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed
        String delete = "TRUNCATE TABLE temp";
        try {
            PreparedStatement psDel = conn.prepareStatement(delete);
            psDel.executeUpdate();
        } catch (Exception e){}

        System.exit(0);
    }//GEN-LAST:event_exitButton1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        contentsCaseWorker frame = new contentsCaseWorker();
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
            java.util.logging.Logger.getLogger(clientAttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientAttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientAttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientAttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientAttendanceReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton exitButton1;
    private javax.swing.JTextField firstnameTextField;
    private javax.swing.JLabel fnLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField lastSignInTextField;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JLabel lnLabel;
    private javax.swing.JTextField noOfSignInTextField;
    private javax.swing.JTextField passTextField;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel studentLabel1;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
