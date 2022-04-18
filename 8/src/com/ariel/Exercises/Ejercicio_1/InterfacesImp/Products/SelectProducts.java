package com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products;

import com.ariel.Exercises.Ejercicio_1.Db.ConnectDB;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Models.Products;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectProducts implements ISelect<Products> {

    private final ConnectDB con;
    private final String query;
    private static SelectProducts instance;

    private SelectProducts(){
        this.con = new ConnectDB();
        query = "SELECT * FROM `products` WHERE `deleted` = 'N' ";
    }

    public static SelectProducts getInstance(){
        if(instance == null){
            instance = new SelectProducts();
        }
        return instance;
    }

    @Override
    public List<Products> getElements() {
        con.createConnection();
        List<Products> products = new ArrayList<>();
        try{
            Statement stm = con.getCon().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                products.add(new Products(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getInt(6)
                ));
            }
            return products;
        }catch (Exception e){
            System.out.println("Something is wrong: ");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return super.toString()+ " Initialized";
    }
}
