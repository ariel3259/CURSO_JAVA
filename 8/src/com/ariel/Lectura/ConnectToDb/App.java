package com.ariel.Lectura.ConnectToDb;


import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        ConnectDB connectDB = new ConnectDB();
        connectDB.connection();
        try{
            String query = "select * from personal_data";
            Statement stm = connectDB.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);
            System.out.println("[");
            while(rs.next()){
                System.out.println("\t{");
                System.out.println("\t\tId: " + rs.getInt(1) + ",");
                System.out.println("\t\tName: " + rs.getString(2) + ",");
                System.out.println("\t\tLast name: " + rs.getString(3) + ",");
                System.out.println("\t\tPhone: " + rs.getString(4) + ",");
                System.out.println("\t\tdni: " + rs.getInt(5) + ",");
                System.out.println("\t\tTypeOfUser: " + rs.getString(6));
                System.out.println("\t},");
            }
            System.out.println("]");
        }catch (Exception e){
            System.out.println("Fallo al hacer la peticion: ");
            System.out.println(e.getMessage());
        }
    }
}
