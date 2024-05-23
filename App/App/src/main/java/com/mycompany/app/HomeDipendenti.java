package com.mycompany.app;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class HomeDipendenti extends javax.swing.JFrame {

    

    public HomeDipendenti() {
        initComponents();
        setIconForm();
        setWelcome();
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

    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        AccountLabel = new javax.swing.JLabel();
        CaricaLabel = new javax.swing.JLabel();
        PicturUser = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        Topbar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        formazione = new javax.swing.JPanel();
        VisualizzaBTN = new javax.swing.JLabel();
        imgVisualizza = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(1032, 537));
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 200));

        Sidebar.setBackground(new java.awt.Color(8, 37, 186));

        AccountLabel.setBackground(new java.awt.Color(255, 255, 255));
        AccountLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AccountLabel.setForeground(new java.awt.Color(255, 255, 255));
        AccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccountLabel.setText("Account");
        AccountLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountLabelMouseClicked(evt);
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
        WelcomeLabel.setText("Benvenuto Tommaso");

        javax.swing.GroupLayout SidebarLayout = new javax.swing.GroupLayout(Sidebar);
        Sidebar.setLayout(SidebarLayout);
        SidebarLayout.setHorizontalGroup(
            SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidebarLayout.createSequentialGroup()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(AccountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(AccountLabel)
                .addGap(50, 50, 50)
                .addComponent(CaricaLabel)
                .addGap(200, 200, 200))
        );

        Topbar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("MY PERSONAL FORMING");

        javax.swing.GroupLayout TopbarLayout = new javax.swing.GroupLayout(Topbar);
        Topbar.setLayout(TopbarLayout);
        TopbarLayout.setHorizontalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TopbarLayout.setVerticalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(30, 30, 30))
        );

        formazione.setBackground(new java.awt.Color(255, 255, 255));
        formazione.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formazioneMouseClicked(evt);
            }
        });

        VisualizzaBTN.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizzaBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VisualizzaBTN.setText("Corsi di Formazione");
        VisualizzaBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VisualizzaBTNMouseClicked(evt);
            }
        });

        imgVisualizza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgVisualizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/worker.png"))); // NOI18N
        imgVisualizza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgVisualizzaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formazioneLayout = new javax.swing.GroupLayout(formazione);
        formazione.setLayout(formazioneLayout);
        formazioneLayout.setHorizontalGroup(
            formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formazioneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisualizzaBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addComponent(imgVisualizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formazioneLayout.setVerticalGroup(
            formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formazioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVisualizza, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VisualizzaBTN)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(formazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(formazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountLabelMouseClicked

       /*  String nome=getWelcome();
        String email=getEmail();*/

        Account account=new Account();
        //account.setWelcome(nome);
      //  account.setEmail(email);

        account.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_AccountLabelMouseClicked

    private void formazioneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formazioneMouseClicked
       
        Dipendenti dipendenti=new Dipendenti();
        dipendenti.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_formazioneMouseClicked

    private void CaricaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaricaLabelMouseClicked
       
        CaricaAttestati carica;
        try {
            carica = new CaricaAttestati();
            carica.setVisible(true);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Aggiungi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CaricaLabelMouseClicked

    private void imgVisualizzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgVisualizzaMouseClicked
        
        VisualizzaCorsiPersonali corsiPersonali=new VisualizzaCorsiPersonali();
        corsiPersonali.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_imgVisualizzaMouseClicked

    private void VisualizzaBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VisualizzaBTNMouseClicked
        VisualizzaCorsiPersonali corsiPersonali=new VisualizzaCorsiPersonali();
        corsiPersonali.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_VisualizzaBTNMouseClicked



    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeDipendenti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JLabel CaricaLabel;
    private javax.swing.JLabel PicturUser;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel VisualizzaBTN;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JPanel formazione;
    private javax.swing.JLabel imgVisualizza;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
