package com.mycompany.app;

import java.sql.*;


public class LoginRegistrazione extends javax.swing.JFrame {

    
    public LoginRegistrazione() {
        initComponents();
        showAccount();
        
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

    public void showAccount() {

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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Account");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 200));

        jPanel1.setPreferredSize(new java.awt.Dimension(460, 549));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 460, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginRegistrazione().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
