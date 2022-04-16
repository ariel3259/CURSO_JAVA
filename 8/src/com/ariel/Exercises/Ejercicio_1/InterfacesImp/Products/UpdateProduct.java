package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.Models.Products;

import java.sql.PreparedStatement;

public class UpdateProduct implements IUpdate<Products> {

    private final ConnectDB con;
    private final String query;
    private static UpdateProduct instance;

    private UpdateProduct(){
        con = new ConnectDB();
        query = "UPDATE `products` SET `code_product` = ?, `name` = ?, `price` = ?, `stock` = ?, `min_stock` = ? WHERE `id` = ?";
    }

    public static UpdateProduct getInstance(){
        if(instance == null){
            instance = new UpdateProduct();
        }
        return instance;
    }

    @Override
    public void updateElement(Products element) {
        con.createConnection();
        try{
            PreparedStatement ps = con.getCon().prepareStatement(query);
            ps.setInt(1, element.getCodeProduct());
            ps.setString(2, element.getName());
            ps.setDouble(3, element.getPrice());
            ps.setInt(4, element.getStock());
            ps.setInt(5, element.getMinStock());
            ps.setInt(6, element.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
