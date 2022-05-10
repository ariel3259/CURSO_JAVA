package com.apiSpotify.apiSpotify.service;

import com.apiSpotify.apiSpotify.model.Usuario;
import com.apiSpotify.apiSpotify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public List<Usuario> getAllUsers(){
        return (List<Usuario>) ur.findAll();
    }

    public Usuario getOneUser(String username) {
        return ur.findByUsername(username);
    }

    public boolean saveUser(Usuario user) {
        if(ur.existsByUsername(user.getUsername())) return false;
        ur.save(user);
        return true;
    }


    public boolean deleteUser(int id) {
        if(ur.existsById(id)) {
            ur.deleteById(id);
            return true;
        }
        return false;
    }

}

