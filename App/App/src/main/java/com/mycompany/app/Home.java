package com.mycompany.app;

public class Home extends javax.swing.JFrame {

    
    public Home() {
        initComponents();
        
    }
    
    public void setWelcome(String email){
        
        WelcomeLabel.setText("Benvenuto/a "+email);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sidebar = new javax.swing.JPanel();
        AccountLabel = new javax.swing.JLabel();
        CorsiLabel = new javax.swing.JLabel();
        CaricaLabel = new javax.swing.JLabel();
        PicturUser = new javax.swing.JLabel();
        WelcomeLabel = new javax.swing.JLabel();
        Topbar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Visualizza_impiegati = new javax.swing.JPanel();
        VisualizzaBTN = new javax.swing.JLabel();
        imgVisualizza = new javax.swing.JLabel();
        Aggiungi_impiegato = new javax.swing.JPanel();
        VisualizzaBTN1 = new javax.swing.JLabel();
        imgAdd = new javax.swing.JLabel();
        Aggiungi_formazione = new javax.swing.JPanel();
        VisualizzaBTN2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
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

        CorsiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CorsiLabel.setForeground(new java.awt.Color(255, 255, 255));
        CorsiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CorsiLabel.setText("Corsi di formazione");

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
                    .addComponent(AccountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(AccountLabel)
                .addGap(40, 40, 40)
                .addComponent(CorsiLabel)
                .addGap(40, 40, 40)
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

        Visualizza_impiegati.setBackground(new java.awt.Color(255, 255, 255));
        Visualizza_impiegati.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Visualizza_impiegatiMouseClicked(evt);
            }
        });

        VisualizzaBTN.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizzaBTN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VisualizzaBTN.setText("Visualizza Impiegati");

        imgVisualizza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgVisualizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/worker.png"))); // NOI18N

        javax.swing.GroupLayout Visualizza_impiegatiLayout = new javax.swing.GroupLayout(Visualizza_impiegati);
        Visualizza_impiegati.setLayout(Visualizza_impiegatiLayout);
        Visualizza_impiegatiLayout.setHorizontalGroup(
            Visualizza_impiegatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Visualizza_impiegatiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Visualizza_impiegatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisualizzaBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(imgVisualizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Visualizza_impiegatiLayout.setVerticalGroup(
            Visualizza_impiegatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Visualizza_impiegatiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgVisualizza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VisualizzaBTN)
                .addGap(19, 19, 19))
        );

        Aggiungi_impiegato.setBackground(new java.awt.Color(255, 255, 255));
        Aggiungi_impiegato.setPreferredSize(new java.awt.Dimension(154, 136));

        VisualizzaBTN1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizzaBTN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VisualizzaBTN1.setText("Aggiungi Impiegato");

        imgAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/add.png"))); // NOI18N

        javax.swing.GroupLayout Aggiungi_impiegatoLayout = new javax.swing.GroupLayout(Aggiungi_impiegato);
        Aggiungi_impiegato.setLayout(Aggiungi_impiegatoLayout);
        Aggiungi_impiegatoLayout.setHorizontalGroup(
            Aggiungi_impiegatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Aggiungi_impiegatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Aggiungi_impiegatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisualizzaBTN1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(imgAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Aggiungi_impiegatoLayout.setVerticalGroup(
            Aggiungi_impiegatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Aggiungi_impiegatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VisualizzaBTN1)
                .addGap(19, 19, 19))
        );

        Aggiungi_formazione.setBackground(new java.awt.Color(255, 255, 255));
        Aggiungi_formazione.setPreferredSize(new java.awt.Dimension(154, 136));

        VisualizzaBTN2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizzaBTN2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VisualizzaBTN2.setText("Aggiungi Formazione");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/formazione.png"))); // NOI18N

        javax.swing.GroupLayout Aggiungi_formazioneLayout = new javax.swing.GroupLayout(Aggiungi_formazione);
        Aggiungi_formazione.setLayout(Aggiungi_formazioneLayout);
        Aggiungi_formazioneLayout.setHorizontalGroup(
            Aggiungi_formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Aggiungi_formazioneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Aggiungi_formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VisualizzaBTN2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Aggiungi_formazioneLayout.setVerticalGroup(
            Aggiungi_formazioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Aggiungi_formazioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(VisualizzaBTN2)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(Visualizza_impiegati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Aggiungi_impiegato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Aggiungi_formazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(126, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Topbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Visualizza_impiegati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Aggiungi_impiegato, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(Aggiungi_formazione, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccountLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountLabelMouseClicked

        Account account =new Account();
        account.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_AccountLabelMouseClicked

    private void Visualizza_impiegatiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Visualizza_impiegatiMouseClicked
       
        Dipendenti dipendenti=new Dipendenti();
        dipendenti.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Visualizza_impiegatiMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountLabel;
    private javax.swing.JPanel Aggiungi_formazione;
    private javax.swing.JPanel Aggiungi_impiegato;
    private javax.swing.JLabel CaricaLabel;
    private javax.swing.JLabel CorsiLabel;
    private javax.swing.JLabel PicturUser;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel VisualizzaBTN;
    private javax.swing.JLabel VisualizzaBTN1;
    private javax.swing.JLabel VisualizzaBTN2;
    private javax.swing.JPanel Visualizza_impiegati;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel imgAdd;
    private javax.swing.JLabel imgVisualizza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
