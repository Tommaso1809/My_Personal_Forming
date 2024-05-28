package com.mycompany.app;

import org.apache.commons.io.FileUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CaricaAttestati extends javax.swing.JFrame {

    public static  String nome_formazione;
    
    public CaricaAttestati() throws SQLException {
        initComponents();
        setIconForm();
        setWelcome();
        getFile();
        setComboBox();
        
    }

    public void setIconForm(){

        ImageIcon icon = new ImageIcon(LoginRegistrazione.class.getResource("img/iconaForm.png"));
        setIconImage(icon.getImage());

    }
    
    public void setComboBox() throws SQLException{
        
            Session sessione=new Session();
            String email=sessione.getEmail();
          
           // DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
           DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");


            Connection connection = database.getConnection();

            String sql="SELECT nome_formazione \n" +
                "FROM corso\n" +
                "JOIN assegnato \n" +
                "ON assegnato.ID=corso.ID\n" +
                "JOIN utente\n" +
                "ON utente.email=assegnato.utente\n" +
                "WHERE utente.email= ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();

      
            // Populate the JComboBox with the data from the database
            while (rs.next()) {
                dropDownAttestati.addItem(rs.getString("nome_formazione"));
            }
        
    }
    
    public void setWelcome(){

        Session session=new Session();

        String nome=session.getNome();
        WelcomeLabel.setText("Benvenuto/a "+nome);

    }

    public void getFile(){
        
        FileChooserAttestati.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileChooserAttestati.setFileFilter(new FileNameExtensionFilter("PDF Files","pdf"));
        
        FileChooserAttestati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
                    File file = FileChooserAttestati.getSelectedFile();
                    
                    try {
                        insertPDFIntoDB(file);
                        
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(CaricaAttestati.this, "Si è verficato un errore.");

                        
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(CaricaAttestati.this, "Si è verficato un errore.");

                    }
  
                }
            }
        });
        
    }   
    
    private void insertPDFIntoDB(File file) throws SQLException, IOException {

        //DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
        DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");


        Connection connection = database.getConnection();
        String sql = "INSERT INTO attestato (nome_formazione, data_formazione, filename) VALUES (?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        
        
        
        dropDownAttestati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 nome_formazione = (String) dropDownAttestati.getSelectedItem();
            }
        });
        
        //System.out.println(nome_formazione);
        String data_formazione=dataFormazioneField.getText();


        if(nome_formazione.isBlank() || data_formazione.isBlank()){

            
            byte[] fileData = FileUtils.readFileToByteArray(file);
            pstmt.setString(1, nome_formazione);
            pstmt.setString(2, data_formazione);
            pstmt.setBytes(3, fileData);
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                
                String query = "INSERT INTO possiede (ID,Utente) VALUES (?,?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                
                Session session=new Session();
                String email=session.getEmail();
                
                stmt.setInt(1, id);
                stmt.setString(2, email);
            
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(CaricaAttestati.this, "Attestato Caricato.");
                
                stmt.close();  
            }

        }
        else{

            JOptionPane.showMessageDialog(CaricaAttestati.this, "Compilare tutti i campi.");


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
        FileChooserAttestati = new javax.swing.JFileChooser();
        dataFormazioneLabel = new javax.swing.JLabel();
        dataFormazioneField = new javax.swing.JTextField();
        nomeFormazioneLabel1 = new javax.swing.JLabel();
        dropDownAttestati = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Carica Attestati");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(1044, 600));
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

        PicturUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PicturUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/user.png"))); // NOI18N

        WelcomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        WelcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WelcomeLabel.setText("Benvenuto Tommaso");

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
                .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
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
        dipendentiLabel.setText("CARICA ATTESTATI");

        FileChooserAttestati.setCurrentDirectory(null);
        FileChooserAttestati.setDialogTitle("Carica Attestati");
        FileChooserAttestati.setBorder(null);
        FileChooserAttestati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserAttestatiActionPerformed(evt);
            }
        });

        dataFormazioneLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dataFormazioneLabel.setText("Data Formazione");

        dataFormazioneField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nomeFormazioneLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nomeFormazioneLabel1.setText("Nome Formazione");

        dropDownAttestati.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dropDownAttestati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownAttestatiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DipendentiLayout = new javax.swing.GroupLayout(Dipendenti);
        Dipendenti.setLayout(DipendentiLayout);
        DipendentiLayout.setHorizontalGroup(
            DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DipendentiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FileChooserAttestati, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dipendentiLabel)
                    .addGroup(DipendentiLayout.createSequentialGroup()
                        .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DipendentiLayout.createSequentialGroup()
                                .addComponent(nomeFormazioneLabel1)
                                .addGap(154, 154, 154))
                            .addGroup(DipendentiLayout.createSequentialGroup()
                                .addComponent(dropDownAttestati, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(130, 130, 130)))
                        .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataFormazioneLabel)
                            .addComponent(dataFormazioneField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        DipendentiLayout.setVerticalGroup(
            DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DipendentiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(dipendentiLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataFormazioneLabel)
                    .addComponent(nomeFormazioneLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DipendentiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataFormazioneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropDownAttestati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(FileChooserAttestati, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
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
                    .addComponent(Dipendenti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        
        Session sessione=new Session();
        String ruolo=sessione.getRuolo();

        

        if(ruolo.equals("titolare")){
            Home home = new Home();
            home.setVisible(true);
            setVisible(false);
        }
        else if(!ruolo.equals("titolare")){

            HomeDipendenti home=new HomeDipendenti();
            home.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_HomeLabelMouseClicked

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void FileChooserAttestatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserAttestatiActionPerformed
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_FileChooserAttestatiActionPerformed

    private void dropDownAttestatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownAttestatiActionPerformed
       
       
        CaricaAttestati.nome_formazione = (String) dropDownAttestati.getSelectedItem();
      
        
    }//GEN-LAST:event_dropDownAttestatiActionPerformed

    private void CorsiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CorsiLabelMouseClicked
        
        Session sessione=new Session();
        String ruolo=sessione.getRuolo();

        if(ruolo.equals("titolare")){
            VisualizzaCorsi corsi = new VisualizzaCorsi();
            corsi.setVisible(true);
            setVisible(false);
        }
        else if(!ruolo.equals("titolare")){

            VisualizzaCorsiPersonali corsi=new VisualizzaCorsiPersonali();
            corsi.setVisible(true);
            setVisible(false);
        }
        
        
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
            java.util.logging.Logger.getLogger(Aggiungi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aggiungi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aggiungi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aggiungi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CaricaAttestati().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CaricaAttestati.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaricaLabel;
    private javax.swing.JLabel CorsiLabel;
    private javax.swing.JPanel Dipendenti;
    private javax.swing.JFileChooser FileChooserAttestati;
    private javax.swing.JLabel HomeLabel;
    private javax.swing.JLabel PicturUser;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JTextField dataFormazioneField;
    private javax.swing.JLabel dataFormazioneLabel;
    private javax.swing.JLabel dipendentiLabel;
    private javax.swing.JComboBox<String> dropDownAttestati;
    private javax.swing.JLabel nomeFormazioneLabel1;
    private javax.swing.JLabel titleBar;
    // End of variables declaration//GEN-END:variables
}
