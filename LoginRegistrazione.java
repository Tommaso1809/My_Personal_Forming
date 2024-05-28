package com.mycompany.app;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import com.mycompany.app.HomeDipendenti;


public class LoginRegistrazione extends javax.swing.JFrame {

    public static String ruolo;
    
    public static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    
    public LoginRegistrazione() {
        initComponents();
        setIconForm();
        setTitolare();
        ruolo=" ";
        
    }
    
    public void setIconForm(){

        ImageIcon icon = new ImageIcon(LoginRegistrazione.class.getResource("img/iconaForm.png"));
        setIconImage(icon.getImage());

    }
    
    public void Accedi() throws SQLException{
        
        //DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
        DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");

        
        String email=EmailCampoAccedi.getText();
        String password=passwordCampoAccedi.getText();

        try{
            
        

            if(email.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(LoginRegistrazione.this, "Compilare tutti i campi.");

            }
            
            
            else if(ruolo.equals("titolare")){
                        
                        Connection connection=database.getConnection();
                        String query="SELECT nome,email,password FROM utente WHERE email = ? AND password = ? AND ruolo = ?";

                        PreparedStatement pstmt = connection.prepareStatement(query);

                        pstmt.setString(1, email);
                        pstmt.setString(2,password);
                        pstmt.setString(3,"titolare");

                        ResultSet rs = pstmt.executeQuery();

                        if(rs.next()){

                            String nome=rs.getString("nome");
                            String emailR=rs.getString("email");


                            Session session=new Session();

                            session.setEmail(emailR);
                            session.setNome(nome);
                            session.setRuolo(ruolo);


                            Home home=new Home();

                            home.setVisible(true);
                            setVisible(false);


                        }
                        else{
                            
                            JOptionPane.showMessageDialog(LoginRegistrazione.this, "Non esiste un Utente 'Master' con queste credenziali.");  
                        }
            }else if((!ruolo.equals("titolare"))){
                Connection connection=database.getConnection();
                String query="SELECT nome,email,password FROM utente WHERE email = ? AND password = ? ";

                PreparedStatement pstmt = connection.prepareStatement(query);

                pstmt.setString(1, email);
                pstmt.setString(2,password);


                ResultSet rs = pstmt.executeQuery();

                if(rs.next()){

                    String nome=rs.getString("nome");
                    String emailR=rs.getString("email");


                    Session session=new Session();

                    session.setEmail(emailR);
                    session.setNome(nome);
                    session.setRuolo(ruolo);


                    HomeDipendenti homeDipendenti=new HomeDipendenti();

                    homeDipendenti.setVisible(true);
                    setVisible(false);
                }  
                else{

                    JOptionPane.showMessageDialog(LoginRegistrazione.this, "Utente Inesistente.");
;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            
            
        }
             
    }
    
     public void setTitolare(){
          titolareCheckRegistrazione.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                
                            if(titolareCheckRegistrazione.isSelected()){
                                
                                ruolo="titolare";
                            }
                            else{
                                ruolo="dipendente";
                            }
                         }
                
        });
          
        titolareCheckAccedi.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                
                            if(titolareCheckAccedi.isSelected()){
                                
                                ruolo="titolare";
                            }
                            else{
                                ruolo="dipendente";
                            }
                         }
                
        });
     }
    
    
   
    public void insertRegistrazione(){

        try{
      //      DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
             DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");


                String nome=NomeCampoRegistrazione.getText();
                String cognome=cognomeCampoRegistrazione.getText();
                String data_nascita=ddnCampoRegistrazione.getText();
                String telefono=telefonoCampoRegistrazione.getText();
                String email=emailCampoRegistrazione1.getText();
                String password=passwordCampoRegistrazione.getText();
                

                if(nome.isEmpty() || cognome.isEmpty() || data_nascita.isEmpty() 
                    || telefono.isEmpty() || email.isEmpty() || password.isEmpty()){

                        JOptionPane.showMessageDialog(LoginRegistrazione.this, "Compilare tutti i campi.");

                }
                else if(ruolo.equals("titolare")){

                        Connection connection=database.getConnection();
                        String query="INSERT INTO utente (email,password,nome,cognome,telefono,data_nascita,ruolo) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement pstmt=connection.prepareStatement(query);
                        
                        pstmt.setString(1, email);
                        pstmt.setString(2, password);
                        pstmt.setString(3, nome);
                        pstmt.setString(4, cognome);
                        pstmt.setString(5,telefono);
                        pstmt.setString(6,data_nascita);
                        pstmt.setString(7, ruolo);

                        pstmt.executeUpdate();

                    
                        Session sessione=new Session();
                        sessione.setEmail(email);
                        sessione.setNome(nome);
                        sessione.setRuolo(ruolo);

                        Home home=new Home();
                        home.setVisible(true);
                        setVisible(false);
                        
                       
                }
                else if(!ruolo.equals("titolare")){

                        Connection connection=database.getConnection();
                        String query="INSERT INTO utente (email,password,nome,cognome,telefono,data_nascita,ruolo) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement pstmt=connection.prepareStatement(query);
                        
                        pstmt.setString(1, email);
                        pstmt.setString(2, password);
                        pstmt.setString(3, nome);
                        pstmt.setString(4, cognome);
                        pstmt.setString(5,telefono);
                        pstmt.setString(6,data_nascita);
                        pstmt.setString(7, ruolo);

                        pstmt.executeUpdate();

                        
                        Session sessione=new Session();
                        sessione.setEmail(email);
                        sessione.setNome(nome);
                        sessione.setRuolo(ruolo);


                        HomeDipendenti home=new HomeDipendenti();
                        home.setVisible(true);
                        setVisible(false);
                        }
                        
                

            }catch(SQLException e){
                JOptionPane.showMessageDialog(LoginRegistrazione.this, "Si è verificato un errore.");

            }
    }

    public Boolean verifyAccount(String email) {

        
        //DBHanderl database=new DBHanderl("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7708180","sql7708180","JM9YdWtS9J");
        DBHanderl database=new DBHanderl("jdbc:mysql://localhost:3306/my_personal_forming","root","");


        String campo = "email";
        try {
    
            Connection connection=database.getConnection();
            String query = "SELECT * FROM utente WHERE " + campo + " = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
    
            pstmt.setString(1, email);
    
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
    
               return true;
                
            }
            else{
                return false;
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
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
        ddnCampoRegistrazione = new javax.swing.JTextField();
        ddnLabel = new javax.swing.JLabel();
        telefonoCampoRegistrazione = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        Accedi_Panel = new javax.swing.JPanel();
        AccediLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        EmailCampoAccedi = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordCampoAccedi = new javax.swing.JPasswordField();
        accediButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        titolareCheckAccedi = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Personal Forming - Accesso");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusTraversalPolicyProvider(true);
        setLocation(new java.awt.Point(100, 100));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1044, 600));

        Registrazion_Panel.setBackground(new java.awt.Color(255, 255, 255));
        Registrazion_Panel.setPreferredSize(new java.awt.Dimension(460, 549));

        NomeCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NomeCampoRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        NomeCampoRegistrazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCampoRegistrazioneActionPerformed(evt);
            }
        });

        NomeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NomeLabel.setText("Nome ");

        RegTitle.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        RegTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegTitle.setText("REGISTRAZIONE");
        RegTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cognomeCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cognomeCampoRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        emailCampoRegistrazione1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        emailCampoRegistrazione1.setMinimumSize(new java.awt.Dimension(64, 16));
        emailCampoRegistrazione1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailCampoRegistrazione1ActionPerformed(evt);
            }
        });

        passwordCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordCampoRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        passwordCampoRegistrazione.setMinimumSize(new java.awt.Dimension(64, 23));
        passwordCampoRegistrazione.setPreferredSize(new java.awt.Dimension(64, 23));
        passwordCampoRegistrazione.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCampoRegistrazioneActionPerformed(evt);
            }
        });

        titolareCheckRegistrazione.setBackground(new java.awt.Color(255, 255, 255));
        titolareCheckRegistrazione.setText("Sei un titolare?");
        titolareCheckRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jButton1.setText("Registrati");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ddnCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ddnCampoRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ddnLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ddnLabel.setText("Data di Nascita");

        telefonoCampoRegistrazione.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefonoCampoRegistrazione.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        telefonoLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        telefonoLabel.setText("Telefono");

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
                        .addGroup(Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddnLabel)
                            .addGroup(Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(titolareCheckRegistrazione)
                                .addComponent(NomeLabel)
                                .addComponent(cognomeCampoRegistrazione, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(cognomeLabel)
                                .addComponent(emailLabelRegistazione)
                                .addComponent(passwordLabelRegistazione)
                                .addComponent(emailCampoRegistrazione1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(passwordCampoRegistrazione, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ddnCampoRegistrazione)
                                .addComponent(telefonoCampoRegistrazione)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Registrazion_PanelLayout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41))
                                .addComponent(NomeCampoRegistrazione))
                            .addComponent(telefonoLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Registrazion_PanelLayout.setVerticalGroup(
            Registrazion_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Registrazion_PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RegTitle)
                .addGap(46, 46, 46)
                .addComponent(NomeLabel)
                .addGap(14, 14, 14)
                .addComponent(NomeCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cognomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cognomeCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(ddnLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ddnCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(telefonoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefonoCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(emailLabelRegistazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailCampoRegistrazione1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(passwordLabelRegistazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordCampoRegistrazione, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titolareCheckRegistrazione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Accedi_Panel.setBackground(new java.awt.Color(8, 37, 186));
        Accedi_Panel.setPreferredSize(new java.awt.Dimension(460, 348));

        AccediLabel.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        AccediLabel.setForeground(new java.awt.Color(255, 255, 255));
        AccediLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AccediLabel.setText("ACCEDI");
        AccediLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("E-mail");

        EmailCampoAccedi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EmailCampoAccedi.setBorder(null);
        EmailCampoAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailCampoAccediActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        passwordCampoAccedi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordCampoAccedi.setBorder(null);
        passwordCampoAccedi.setMinimumSize(new java.awt.Dimension(64, 22));
        passwordCampoAccedi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCampoAccediActionPerformed(evt);
            }
        });

        accediButton.setBackground(new java.awt.Color(0, 0, 255));
        accediButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        accediButton.setForeground(new java.awt.Color(255, 255, 255));
        accediButton.setText("Accedi");
        accediButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        accediButton.setBorderPainted(false);
        accediButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accediButtonMouseClicked(evt);
            }
        });
        accediButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accediButtonActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/app/img/userLogin.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        titolareCheckAccedi.setBackground(new java.awt.Color(8, 37, 186));
        titolareCheckAccedi.setForeground(new java.awt.Color(255, 255, 255));
        titolareCheckAccedi.setText("Sei un titolare?");
        titolareCheckAccedi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout Accedi_PanelLayout = new javax.swing.GroupLayout(Accedi_Panel);
        Accedi_Panel.setLayout(Accedi_PanelLayout);
        Accedi_PanelLayout.setHorizontalGroup(
            Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addGroup(Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                                .addComponent(accediButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                                .addComponent(AccediLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Accedi_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titolareCheckAccedi)
                    .addComponent(EmailCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel)
                    .addComponent(emailLabel))
                .addGap(84, 84, 84))
        );
        Accedi_PanelLayout.setVerticalGroup(
            Accedi_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Accedi_PanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(AccediLabel)
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordCampoAccedi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(titolareCheckAccedi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accediButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Registrazion_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Accedi_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Accedi_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .addComponent(Registrazion_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NomeCampoRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCampoRegistrazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCampoRegistrazioneActionPerformed

    private void cognomeCampoRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cognomeCampoRegistrazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cognomeCampoRegistrazioneActionPerformed

    private void emailCampoRegistrazione1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailCampoRegistrazione1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailCampoRegistrazione1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        insertRegistrazione();
    }//GEN-LAST:event_jButton1MouseClicked

    private void passwordCampoRegistrazioneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCampoRegistrazioneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordCampoRegistrazioneActionPerformed

    private void accediButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accediButtonActionPerformed
        
    }//GEN-LAST:event_accediButtonActionPerformed

    private void accediButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accediButtonMouseClicked
        try {
            Accedi();
        } catch (SQLException ex) {
            Logger.getLogger(LoginRegistrazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_accediButtonMouseClicked

    private void passwordCampoAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCampoAccediActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordCampoAccediActionPerformed

    private void EmailCampoAccediActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailCampoAccediActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailCampoAccediActionPerformed

    
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
    private javax.swing.JTextField ddnCampoRegistrazione;
    private javax.swing.JLabel ddnLabel;
    private javax.swing.JTextField emailCampoRegistrazione1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabelRegistazione;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordCampoAccedi;
    private javax.swing.JPasswordField passwordCampoRegistrazione;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabelRegistazione;
    private javax.swing.JTextField telefonoCampoRegistrazione;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JCheckBox titolareCheckAccedi;
    private javax.swing.JCheckBox titolareCheckRegistrazione;
    // End of variables declaration//GEN-END:variables
}
