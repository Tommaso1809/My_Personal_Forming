package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHanderl {
    
    public String url;
    public String username;
    public String password;


    public DBHanderl(String url,String username,String password){
        this.url=url;
        this.username=username;
        this.password=password;        
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    

}
