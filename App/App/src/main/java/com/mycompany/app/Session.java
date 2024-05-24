package com.mycompany.app;

public class Session {

    public static String email;
    public static String nome;

    public static String ruolo;
    public static Object id_corso;

    public static void setEmail(String email) {
        Session.email = email;
    }

    public static String getEmail() {
        return Session.email;
    }

    public static void setNome(String nome){
        Session.nome=nome;
    }

    public static String getNome(){
        return Session.nome;
    }
    
    public static void setIDCorso(Object id_corso) {
        Session.id_corso = id_corso;
    }
    
    public static Object getIDCorso(){
        return Session.id_corso;
    }

    public static void setRuolo(String ruolo) {
        Session.ruolo = ruolo;
    }
    
    public static String getRuolo(){
        return Session.ruolo;
    }

    
}
