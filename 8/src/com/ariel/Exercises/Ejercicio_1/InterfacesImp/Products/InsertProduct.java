package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Models.Products;

import java.sql.PreparedStatement;

public class InsertProduct implements IInsert<Products> {

    private final ConnectDB con;
    private final String query;
    private static InsertProduct instance;

    private InsertProduct(){
        con = new ConnectDB();
        query = "INSERT INTO `products`(`product_code`, `name`, `price`, `stock`, `min_stock`, `deleted`) VALUE (?, ?, ?, ?, ?, 'N')";
    }

    public static InsertProduct getInstance(){
        if(instance == null){
            instance = new InsertProduct();
        }
        return instance;
    }

    @Override
    public void insertElement(Products element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getCodeProduct());
            ps.setString(2, element.getName());
            ps.setDouble(3, element.getPrice());
            ps.setInt(4, element.getStock());
            ps.setInt(5, element.getMinStock());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
