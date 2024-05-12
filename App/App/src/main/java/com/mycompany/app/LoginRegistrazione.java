package com.mycompany.app;

import java.sql.*;
import java.awt.event.*;


public class LoginRegistrazione extends javax.swing.JFrame {

    
    public LoginRegistrazione() {
        initComponents();
        //showAccount();
        
    }
    
    private Connection connectDB(){
        
        try{
            String url="jdbc:mysql://localhost:3306/my_personal_forming";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);
            
            return connection;
            
            
            
        }catch(SQLException s){
            s.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException c){
            c.printStackTrace();
            return null;
        }
    }

    public Bool insertRegistrazione(){

        Connection connection=connectDB();

        try{

            String nome=NomeCampoRegistrazione.getText();
            String cognome=cognomeCampoRegistrazione.getText();
            String email=emailCampoRegistrazione1.getText();
            String password=passwordCampoRegistrazione.getText();

            titolareCheckRegistrazione.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(titolareCheckRegistrazione.isSelected()){
                        String ruolo="titolare";
                    }
                    else{
                        String ruolo="";
                    }
                }
            });

            //String sql="INSERT INTO utente "


        }catch(SQLException e){
            e.printStackTrace();

            return null;
        }
    }

    /*public void showAccount() {

        Connection connection = connectDB();
    
        String email = "t@gmail.com";
        String campo = "email";
        try {
    
            String query = "SELECT * FROM utente WHERE " + campo + " = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
    
            pstmt.setString(1, email);
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
    
                nomeCampo.setText(rs.getString("nome"));
                cognomeCampo.setText(rs.getString("cognome"));
                emailCampo.setText(rs.getString("email"));
                telefonoCampo.setText(rs.getString("telefono"));
                ddnCampo.setText(rs.getString("data_nascita"));
                


            } else {
                System.out.println("No account found with email: " + email);
            }
    
        } catch (SQLException e) {
            System.out.println("Error executing SQL query");
            e.printStackTrace();
        }
    }
*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Registrazion_Panel = new javax.swing.JPanel();
        NomeCampoRegistrazione = new javax.swing.JTextField();
        NomeLabel = new javax.swing.JLabel();
        RegTitle = new javax.swing.JLabel();
        cognomeCampoRegistrazione = new javax.swing.JTextField();
        cognomeLabel = new javax.swing.JLabel();
        emailLabelRegistazione = new javax.swing.JLabel();
        passwordLabelRegistazione = new javax.swing.JLabel();
        emailCampoRegistrazione1 = new javax.swing.JTextField();
        passwordCampoRegistrazione = new javax.swing.JPasswordField();
        titolareCheckRegistrazione = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        Accedi_Panel = new javax.swing.JPanel();
        AccediLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        EmailCampoAccedi = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordCampoAccedi = new javax.swing.JPasswordField();
        accediButton = new javax.swing.JButton();
        titolareCheck1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Accesso");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 200));

        Registrazion_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Registrazion_Panel.setPreferredSize(new java.awt.Dimension(460, 549));

        NomeCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NomeCampoRegistrazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCampoRegistrazioneActionPerformed(evt);
            }
        });

        NomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NomeLabel.setText("Nome ");

        RegTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RegTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegTitle.setText("REGISTRAZIONE");
        RegTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cognomeCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cognomeCampoRegistrazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cognomeCampoRegistrazioneActionPerformed(evt);
            }
        });

        cognomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cognomeLabel.setText("Cognome");

        emailLabelRegistazione.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabelRegistazione.setText("E-mail");

        passwordLabelRegistazione.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordLabelRegistazione.setText("Password");

        emailCampoRegistrazione1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailCampoRegistrazione1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailCampoRegistrazione1ActionPerformed(evt);
            }
        });

        passwordCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        titolareCheckRegistrazione.setText("Sei un titolare?");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Registrazione");
        jButton1.setBorder(null);

        javax.swing.GroupLayout Registrazion_PanelLayout = new javax.swing.GroupLayout(Registrazion_Panel);
        Registrazion_Panel.setLayout(Registrazion_PanelLayout);
        Registrazion_PanelLayout.setHorizontalGroup(
            Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrazion_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addGroup(Registrazion_PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titolareCheckRegistrazione)
                            .addComponent(NomeLabel)
                            .addComponent(NomeCampoRegistrazione)
                            .addComponent(cognomeCampoRegistrazione, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(cognomeLabel)
                            .addComponent(emailLabelRegistazione)
                            .addComponent(passwordLabelRegistazione)
                            .addComponent(emailCampoRegistrazione1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(passwordCampoRegistrazione)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Registrazion_PanelLayout.setVerticalGroup(
            Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrazion_PanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(RegTitle)
                .addGap(40, 40, 40)
                .addComponent(NomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomeCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cognomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cognomeCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(emailLabelRegistazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailCampoRegistrazione1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(passwordLabelRegistazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(titolareCheckRegistrazione)
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        Accedi_Panel.setBackground(new java.awt.Color(8, 37, 186));
        Accedi_Panel.setPreferredSize(new java.awt.Dimension(460, 348));

        AccediLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AccediLabel.setForeground(new java.awt.Color(255, 255, 255));
        AccediLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccediLabel.setText("ACCEDI");
        AccediLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("E-mail");

        EmailCampoAccedi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmailCampoAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailCampoAccediActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        passwordCampoAccedi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        accediButton.setBackground(new java.awt.Color(8, 37, 186));
        accediButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        accediButton.setForeground(new java.awt.Color(255, 255, 255));
        accediButton.setText("Accedi");
        accediButton.setBorder(null);
        accediButton.setBorderPainted(false);
        accediButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accediButtonMouseClicked(evt);
            }
        });

        titolareCheck1.setForeground(new java.awt.Color(255, 255, 255));
        titolareCheck1.setText("Sei un titolare?");

        javax.swing.GroupLayout Accedi_PanelLayout = new javax.swing.GroupLayout(Accedi_Panel);
        Accedi_Panel.setLayout(Accedi_PanelLayout);
        Accedi_PanelLayout.setHorizontalGroup(
            Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Accedi_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AccediLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                .addGap(0, 96, Short.MAX_VALUE)
                .addGroup(Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titolareCheck1)
                    .addGroup(Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordLabel)
                        .addComponent(emailLabel)
                        .addComponent(EmailCampoAccedi, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addComponent(passwordCampoAccedi)
                        .addComponent(accediButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(84, 84, 84))
        );
        Accedi_PanelLayout.setVerticalGroup(
            Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Accedi_PanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(AccediLabel)
                .addGap(40, 40, 40)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(titolareCheck1)
                .addGap(20, 20, 20)
                .addComponent(accediButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Registrazion_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Accedi_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Registrazion_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Accedi_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeCampoRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCampoRegistrazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCampoRegistrazioneActionPerformed

    private void EmailCampoAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailCampoAccediActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailCampoAccediActionPerformed

    private void accediButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accediButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_accediButtonMouseClicked

    private void cognomeCampoRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognomeCampoRegistrazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognomeCampoRegistrazioneActionPerformed

    private void emailCampoRegistrazione1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailCampoRegistrazione1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailCampoRegistrazione1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegistrazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccediLabel;
    private javax.swing.JPanel Accedi_Panel;
    private javax.swing.JTextField EmailCampoAccedi;
    private javax.swing.JTextField NomeCampoRegistrazione;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JLabel RegTitle;
    private javax.swing.JPanel Registrazion_Panel;
    private javax.swing.JButton accediButton;
    private javax.swing.JTextField cognomeCampoRegistrazione;
    private javax.swing.JLabel cognomeLabel;
    private javax.swing.JTextField emailCampoRegistrazione1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabelRegistazione;
    private javax.swing.JButton jButton1;
    private javax.swing.JPasswordField passwordCampoAccedi;
    private javax.swing.JPasswordField passwordCampoRegistrazione;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabelRegistazione;
    private javax.swing.JCheckBox titolareCheck1;
    private javax.swing.JCheckBox titolareCheckRegistrazione;
    // End of variables declaration//GEN-END:variables
}
