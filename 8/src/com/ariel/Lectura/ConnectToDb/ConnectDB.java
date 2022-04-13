package com.ariel.Lectura.ConnectToDb;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {

    private final String url = "jdbc:mysql://localhost:3306/facultad_db";
    private final String user = "root";
    private final String password = "1234";
    private Connection con;

    public void connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            System.out.println("Connected to database");
        }catch(Exception e){
            System.out.println("There's an error: ");
            System.out.println(e.getMessage());
        }
    }

    public Connection getCon(){
        return con;
    }

}
