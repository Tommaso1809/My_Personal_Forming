
package com.mycompany.app;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dipendenti extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Dipendenti() {
        initComponents();
        setIconForm();
        setWelcome();
        showDipendenti();
    }

    public void setWelcome(){

        Session session=new Session();

        String nome=session.getNome();
        WelcomeLabel.setText("Benvenuto/a "+nome);

    }
    
    public void setIconForm(){

        ImageIcon icon = new ImageIcon(LoginRegistrazione.class.getResource("img/iconaForm.png"));
        setIconImage(icon.getImage());

    }
   
    public void showDipendenti(){
        // DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
        DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");

    
        try {
    
            Connection connection=database.getConnection();

            Session session=new Session();

            String email=session.getEmail();

            String query = "SELECT * FROM utente WHERE NOT email = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
    
            pstmt.setString(1, email);
    
            ResultSet rs = pstmt.executeQuery();
    
            
    
            while (rs.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = rs.getString("nome");
                rowData[1] = rs.getString("cognome");
                rowData[2] = rs.getString("email");
                rowData[3] = rs.getString("ruolo");
                //rowData[4] = "Scarica tutti gli attestati";
                DefaultTableModel model = (DefaultTableModel) Table.getModel();
                model.addRow(rowData);
            }
            
            Table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int row = Table.rowAtPoint(e.getPoint());
                        if (row >= 0 && row < Table.getRowCount()) {
                            String email  = (String) Table.getValueAt(row, 2);
                            
                            
                            /*Session sessione=new Session();
                            sessione.setIDCorso(id);*/
                            
                            VisualizzaCorsi corsi=new VisualizzaCorsi();
                            try {
                                corsi.downloadPDFFromDB(email);
                                
                                /*JOptionPane.showMessageDialog(VisualizzaCorsi.this, "ID: " + id + "\nNome Formazione: " + nomeFormazione +
                                "\nDurata Formazione: " + durataFormazione + "\nCategoria: " + categoria + "\nStato: " + stato);*/
                            } catch (SQLException ex) {
                                Logger.getLogger(Dipendenti.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Dipendenti.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });


    
        } catch (SQLException e) {
            System.out.println("Error executing SQL query");
            e.printStackTrace();
        }
    }
        
    
    public void downloadPDFFromDB() throws SQLException, FileNotFoundException, IOException{
        //DBHanderl database = new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
        DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");


        Connection connection = database.getConnection();
        String sql = "SELECT filename FROM attestato JOIN possiede ON possiede.ID=attestato.ID JOIN utente ON  utente.email=possiede.utente WHERE utente.email= ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        
        Session sessione=new Session();
        String email=sessione.getEmail();
        
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        
        String filename=email+" attestato";

       if (rs.next()) {
            byte[] fileData = rs.getBytes("filename");
            String userHome = System.getProperty("user.home");
            String downloadFolder = userHome + File.separator + "Downloads";
            File file = new File(downloadFolder, filename + ".pdf");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileData);
                fos.flush();
                fos.close();
                 JOptionPane.showMessageDialog(Dipendenti.this, "File Scaricato nella Cartella Download.");
                try (FileInputStream fis = new FileInputStream(file)) {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                     JOptionPane.showMessageDialog(Dipendenti.this, "Errore di Sistema.");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(Dipendenti.this, "Errore di Sistema.");
            }
        } else {
             JOptionPane.showMessageDialog(Dipendenti.this, "Nessun File Trovato.");
        }

        pstmt.close();
        connection.close();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        HomeLabel = new javax.swing.JLabel();
        CorsiLabel = new javax.swing.JLabel();
        CaricaLabel = new javax.swing.JLabel();
        PicturUser = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        Topbar = new javax.swing.JPanel();
        titleBar = new javax.swing.JLabel();
        Dipendenti = new javax.swing.JPanel();
        dipendentiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Dipendenti");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 200));

        Sidebar.setBackground(new java.awt.Color(8, 37, 186));

        HomeLabel.setBackground(new java.awt.Color(255, 255, 255));
        HomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        HomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeLabel.setText("Home Page");
        HomeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeLabelMouseClicked(evt);
            }
        });

        CorsiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CorsiLabel.setForeground(new java.awt.Color(255, 255, 255));
        CorsiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CorsiLabel.setText("Corsi di formazione");
        CorsiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CorsiLabelMouseClicked(evt);
            }
        });

        CaricaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CaricaLabel.setForeground(new java.awt.Color(255, 255, 255));
        CaricaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CaricaLabel.setText("Carica gli attestati");
        CaricaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaricaLabelMouseClicked(evt);
            }
        });

        PicturUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PicturUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/user.png"))); // NOI18N

        WelcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(HomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CorsiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(CaricaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PicturUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        SidebarLayout.setVerticalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(PicturUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WelcomeLabel)
                .addGap(40, 40, 40)
                .addComponent(HomeLabel)
                .addGap(40, 40, 40)
                .addComponent(CorsiLabel)
                .addGap(40, 40, 40)
                .addComponent(CaricaLabel)
                .addGap(200, 200, 200))
        );

        Topbar.setBackground(new java.awt.Color(255, 255, 255));

        titleBar.setFont(new java.awt.Font("Leelawadee UI", 1, 30)); // NOI18N
        titleBar.setForeground(new java.awt.Color(51, 102, 255));
        titleBar.setText("MY PERSONAL FORMING");

        javax.swing.GroupLayout TopbarLayout = new javax.swing.GroupLayout(Topbar);
        Topbar.setLayout(TopbarLayout);
        TopbarLayout.setHorizontalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                .addContainerGap())
        );
        TopbarLayout.setVerticalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleBar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Dipendenti.setBackground(new java.awt.Color(255, 255, 255));

        dipendentiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dipendentiLabel.setText("DIPENDENTI");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cognome", "E-mail", "Ruolo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setResizable(false);
            Table.getColumnModel().getColumn(1).setResizable(false);
            Table.getColumnModel().getColumn(2).setResizable(false);
            Table.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout DipendentiLayout = new javax.swing.GroupLayout(Dipendenti);
        Dipendenti.setLayout(DipendentiLayout);
        DipendentiLayout.setHorizontalGroup(
            DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DipendentiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dipendentiLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DipendentiLayout.setVerticalGroup(
            DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DipendentiLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(dipendentiLabel)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Dipendenti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(Dipendenti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelMouseClicked
        Home home =new Home();
        home.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_HomeLabelMouseClicked

    private void CaricaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaricaLabelMouseClicked
        
        CaricaAttestati carica;
        try {
            carica = new CaricaAttestati();
            carica.setVisible(true);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Dipendenti.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CaricaLabelMouseClicked

    private void CorsiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CorsiLabelMouseClicked
        
        VisualizzaCorsi corsi = new VisualizzaCorsi();
        corsi.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_CorsiLabelMouseClicked

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
            java.util.logging.Logger.getLogger(Dipendenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dipendenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dipendenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dipendenti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dipendenti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaricaLabel;
    private javax.swing.JLabel CorsiLabel;
    private javax.swing.JPanel Dipendenti;
    private javax.swing.JLabel HomeLabel;
    private javax.swing.JLabel PicturUser;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JTable Table;
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel dipendentiLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleBar;
    // End of variables declaration//GEN-END:variables
}
