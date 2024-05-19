package com.mycompany.app;

public class Session {

    public static String email;
    public static String nome;


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

    
}
