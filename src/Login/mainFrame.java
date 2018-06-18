package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Login.DBConnection;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import Login.Welcome_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Login.createACC;
import caseWorker.contentsCaseWorker;
import java.awt.Image;
import javax.swing.ImageIcon;
        
/**
 *
 * @author Connor
 */
public class mainFrame extends javax.swing.JFrame {
    Connection conn = new DBConnection().connect();
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        setLocationRelativeTo(this);
        
        lastnameTextField.setVisible(false);
        firstnameTextField.setVisible(false);
        jLabel1.setBounds(20,30,50,50);
        
        jLabel1.setIcon(new ImageIcon ("../generic-user-purple.png"));

        
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
        welcomeLabel1 = new javax.swing.JLabel();
        welcomeLabel2 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        createAccButton = new javax.swing.JButton();
        SignInButton = new javax.swing.JButton();
        PasswordField1 = new javax.swing.JPasswordField();
        exitButton = new javax.swing.JButton();
        firstnameTextField = new javax.swing.JTextField();
        lastnameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(640, 480));

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        welcomeLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        welcomeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel1.setText("Welcome If You Have An Account Please Sign In Otherwise");
        welcomeLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        welcomeLabel2.setBackground(new java.awt.Color(0, 0, 0));
        welcomeLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        welcomeLabel2.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel2.setText("Please Create An Account");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username:");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password:");

        createAccButton.setText("Create Account");
        createAccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccButtonActionPerformed(evt);
            }
        });

        SignInButton.setText("Sign In");
        SignInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usernameLabel)
                                .addComponent(passwordLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(createAccButton)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(PasswordField1))
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(SignInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 72, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(firstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomeLabel2)
                .addGap(354, 354, 354))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(welcomeLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(PasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignInButton)
                    .addComponent(createAccButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(exitButton)
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
        String delete = "DELETE * FROM temp";
        try {
        PreparedStatement psDel = conn.prepareStatement(delete);
        psDel.executeQuery();
        } catch (Exception e){}
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void SignInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInButtonActionPerformed
        
        String sql = "Select * From userclient Where username=? And password=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usernameTextField.getText());
            ps.setString(2, PasswordField1.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String FN = rs.getString("firstname");
                firstnameTextField.setText(FN);
                String LN = rs.getString("lastname");
                lastnameTextField.setText(LN);
                
                String INSERT_RECORD = "INSERT INTO clientusage(date, firstname, lastname) VALUES(?, ?, ?)";
                    try {
                        PreparedStatement pstmt = conn.prepareStatement(INSERT_RECORD);
                        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
                        pstmt.setDate(1, sqlDate);
                        pstmt.setString(2, firstnameTextField.getText());
                        pstmt.setString(3, lastnameTextField.getText());

                        pstmt.executeUpdate();
                    }
                    catch (Exception e){}
                
                this.dispose();
                Welcome_1 Info = new Welcome_1();
                Info.setVisible(true);
            }
            else {

                String query = "Select * From usercaseworker Where username=? And password=?";
                try {
                    PreparedStatement ps2 = conn.prepareStatement(query);
                    ps2.setString(1, usernameTextField.getText());
                    ps2.setString(2, PasswordField1.getText());
                    ResultSet rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        this.dispose();
                        Welcome_2 Frame = new Welcome_2();
                        Frame.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Username & Password Invalid");
                    }
                }
                catch (Exception e){}
            }
        }
        catch (Exception e){}
        
         String sqlquery = "INSERT INTO temp(username, password) VALUES(?, ?)";
                    try {
                        PreparedStatement pst = conn.prepareStatement(sqlquery);
                        pst.setString(1, usernameTextField.getText());
                        pst.setString(2, PasswordField1.getText());

                        pst.executeUpdate();
                    }
                    catch (Exception e){}
        

    }//GEN-LAST:event_SignInButtonActionPerformed

    private void createAccButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccButtonActionPerformed
        // TODO add your handling code here:
        
        createACC frame = new createACC();
        frame.setVisible(true);
        setVisible(false);
        dispose();
        
        
    }//GEN-LAST:event_createAccButtonActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField1;
    private javax.swing.JButton SignInButton;
    private javax.swing.JButton createAccButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField firstnameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JLabel welcomeLabel1;
    private javax.swing.JLabel welcomeLabel2;
    // End of variables declaration//GEN-END:variables

    private void systemExit()
    {
        WindowEvent winCloseing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    }
}
