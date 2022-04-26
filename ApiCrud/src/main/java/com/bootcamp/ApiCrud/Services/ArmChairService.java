package com.bootcamp.ApiCrud.Services;

import com.bootcamp.ApiCrud.Entity.ArmChairEntity;
import com.bootcamp.ApiCrud.Repository.ArmChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmChairService {

    @Autowired
    private ArmChairRepository acr;

    public List<ArmChairEntity> getAllArmChairs(){
        return (List<ArmChairEntity>) acr.findAll();
    }

     public boolean saveArmChair(ArmChairEntity armChair){
        if(acr.existsByCode(armChair.getCode())) return false;
        acr.save(armChair);
        return true;
     }

     public boolean updateArmChair(ArmChairEntity armChair){
        if(!acr.existsById(armChair.getId())) return false;
        acr.save(armChair);
        return true;
     }

     public boolean deleteArmChair(int id){
        if(!acr.existsById(id)) return false;
        acr.deleteById(id);
        return true;
     }
}
