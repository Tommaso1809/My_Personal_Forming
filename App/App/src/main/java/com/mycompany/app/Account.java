package com.mycompany.app;

import java.sql.*;

import javax.swing.ImageIcon;


public class Account extends javax.swing.JFrame {
    
    public Account() {
       
        initComponents();
        setIconForm();
        setWelcome();
        showAccount();
        
    }

    public void setIconForm(){

        ImageIcon icon = new ImageIcon(LoginRegistrazione.class.getResource("img/iconaForm.png"));
        setIconImage(icon.getImage());

    }

    public void setWelcome(){

        Session session=new Session();

        String nome=session.getNome();
        WelcomeLabel.setText("Benvenuto/a "+nome);

    }

    public void showAccount() {
    
    
        DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");

    
        try {
    
            Connection connection=database.getConnection();

            Session session=new Session();

            String email=session.getEmail();

            String query = "SELECT * FROM utente WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
    
            pstmt.setString(1, email);
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
    
                nomeCampo.setText(rs.getString("nome"));
                cognomeCampo.setText(rs.getString("cognome"));
                emailCampo.setText(rs.getString("email"));
                telefonoCampo.setText("+39 "+rs.getString("telefono"));
                ddnCampo.setText(rs.getString("data_nascita"));
                


            } else {
                
            }
    
        } catch (SQLException e) {
            System.out.println("Error executing SQL query");
            e.printStackTrace();
        }
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
        Dati = new javax.swing.JPanel();
        datiAnagrafici = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        nomeCampo = new javax.swing.JLabel();
        cognomeLabel = new javax.swing.JLabel();
        cognomeCampo = new javax.swing.JLabel();
        ddnLabel = new javax.swing.JLabel();
        ddnCampo = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        telefonoCampo = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailCampo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Account");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(1044, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1044, 960));

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
                .addComponent(titleBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TopbarLayout.setVerticalGroup(
            TopbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopbarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleBar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Dati.setBackground(new java.awt.Color(255, 255, 255));

        datiAnagrafici.setBackground(new java.awt.Color(255, 255, 255));
        datiAnagrafici.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        datiAnagrafici.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        datiAnagrafici.setText("DATI ANAGRAFICI");

        nomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        nomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeLabel.setText("Nome");

        cognomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        cognomeLabel.setText("Cognome");
        cognomeLabel.setPreferredSize(new java.awt.Dimension(37, 18));

        ddnLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ddnLabel.setText("Data di Nascita");

        telefonoLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        telefonoLabel.setText("Telefono");

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        emailLabel.setText("E-mail");

        javax.swing.GroupLayout DatiLayout = new javax.swing.GroupLayout(Dati);
        Dati.setLayout(DatiLayout);
        DatiLayout.setHorizontalGroup(
            DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datiAnagrafici)
                    .addGroup(DatiLayout.createSequentialGroup()
                        .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nomeCampo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(nomeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(telefonoLabel)
                            .addComponent(telefonoCampo))
                        .addGap(95, 95, 95)
                        .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailCampo)
                            .addGroup(DatiLayout.createSequentialGroup()
                                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cognomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cognomeCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(95, 95, 95)
                                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ddnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ddnCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        DatiLayout.setVerticalGroup(
            DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatiLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(datiAnagrafici, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(cognomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddnLabel))
                .addGap(10, 10, 10)
                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCampo)
                    .addComponent(cognomeCampo)
                    .addComponent(ddnCampo))
                .addGap(35, 35, 35)
                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoCampo)
                    .addComponent(emailCampo))
                .addContainerGap(681, Short.MAX_VALUE))
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
                    .addComponent(Dati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addComponent(Dati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeLabelMouseClicked
       Session sessione=new Session();
       String ruolo=sessione.getRuolo();

       if(ruolo.equals("titolare")){

        Home home=new Home();
        home.setVisible(true);
        setVisible(false);
       }
       else{
        HomeDipendenti home=new HomeDipendenti();
        home.setVisible(true);
        setVisible(false);
       }
       
    }//GEN-LAST:event_HomeLabelMouseClicked

    private void CorsiLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CorsiLabelMouseClicked
        
        Session sessione=new Session();
        String ruolo=sessione.getRuolo();

        if(ruolo.equals("titolare")){
            VisualizzaCorsi corsi = new VisualizzaCorsi();
            corsi.setVisible(true);
            setVisible(false);
        } 
        else{
            VisualizzaCorsiPersonali corsi = new VisualizzaCorsiPersonali();
            corsi.setVisible(true);
            setVisible(false);
        }    
    }//GEN-LAST:event_CorsiLabelMouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CaricaLabel;
    private javax.swing.JLabel CorsiLabel;
    private javax.swing.JPanel Dati;
    private javax.swing.JLabel HomeLabel;
    private javax.swing.JLabel PicturUser;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel Topbar;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JLabel cognomeCampo;
    private javax.swing.JLabel cognomeLabel;
    private javax.swing.JLabel datiAnagrafici;
    private javax.swing.JLabel ddnCampo;
    private javax.swing.JLabel ddnLabel;
    private javax.swing.JLabel emailCampo;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel nomeCampo;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JLabel telefonoCampo;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JLabel titleBar;
    // End of variables declaration//GEN-END:variables
}
