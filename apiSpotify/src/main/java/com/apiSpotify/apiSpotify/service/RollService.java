package com.apiSpotify.apiSpotify.service;

import com.apiSpotify.apiSpotify.model.Roll;
import com.apiSpotify.apiSpotify.model.Usuario;
import com.apiSpotify.apiSpotify.repository.RollRepository;
import com.apiSpotify.apiSpotify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RollService {

    @Autowired
    private RollRepository rr;

    public List<Roll> getAllRolls(){
        return (List<Roll>) rr.findAll();
    }

    public Roll getOneRoll(String name) {
        return rr.findByName(name);
    }

    public boolean saveRoll(Roll roll) {
        if(rr.existsByName(roll.getName())) return false;
        rr.save(roll);
        return true;
    }


    public boolean deleteRoll(int id) {
        if(rr.existsById(id)) {
            rr.deleteById(id);
            return true;
        }
        return false;
    }

}