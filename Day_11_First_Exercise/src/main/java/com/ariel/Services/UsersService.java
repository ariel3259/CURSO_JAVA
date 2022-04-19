package com.ariel.Services;

import com.ariel.Db.ConnectionDB;
import com.ariel.Model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UsersService {
    private Connection con;

    public UsersService(){
        con = new ConnectionDB().getCon();
    }

    public List<Users> getUsers(){
        String query = "SELECT * FROM `users`";
        List<Users> users = new LinkedList<>();

        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                users.add(new Users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
            return users;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void saveUser(Users user){
        String query = "INSERT INTO `users`(`name`, `last_name`, `dni`) VALUE (?, ?, ?)";

        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getDni());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateUser(Users user){
        String query = "UPDATE `users` SET name = ?, last_name = ?, dni = ? WHERE `id` = ?";
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getDni());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(int id){
        String query = "DELETE FROM `users` WHERE `id` = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Users getUser(int id){
        String query = "SELECT * FROM `users` WHERE `id` = ?";
        try{
            Users user;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            user = new Users(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4));
/*
            while(rs.next()){
                user = new Users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));

            }*/
            return user;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
