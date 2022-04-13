package com.ariel.Exercises.Ejercicio_1.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private Connection con;
    private final String url;
    private final String userName;
    private final String password;

    public ConnectDB(){
        url = "jdbc:mysql://localhost:3306/tienda_db";
        userName = "root";
        password = "1234";
    }


    public void createConnection(){
        try{
            con = DriverManager.getConnection(url, userName, password);
        }catch (Exception e){
            System.out.println("Something is wrong because: ");
            System.out.println(e.getMessage());
        }
    }

    public Connection getCon(){
        return con;
    }
}
