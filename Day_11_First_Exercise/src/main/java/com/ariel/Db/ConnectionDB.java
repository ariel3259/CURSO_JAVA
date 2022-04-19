package com.ariel.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private final String url;
    private final String userName;
    private final String password;
    private Connection con;

    public ConnectionDB(){
        url = "jdbc:mysql://localhost:3306/api_rest";
        userName = "root";
        password = "1234";
        createConnection();
    }

    private void createConnection(){
        try {
            con = DriverManager.getConnection(url, userName, password);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getCon(){
        return con;
    }
}
