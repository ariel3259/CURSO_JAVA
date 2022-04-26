package com.bootcamp.ApiCrud.Services;

import com.bootcamp.ApiCrud.Entity.FurnitureEntity;
import com.bootcamp.ApiCrud.Repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    @Autowired
    private FurnitureRepository fr;

    public List<FurnitureEntity> readAllFurnitures(){
        return (List<FurnitureEntity>) fr.findAll();
    }

    public boolean createFurniture(FurnitureEntity furniture){
        if(fr.existsByCode(furniture.getCode())) return false;
        fr.save(furniture);
        return true;
    }

    public boolean updateFurniture(FurnitureEntity furniture){
         if(!fr.existsById(furniture.getId())) return false;
         fr.save(furniture);
         return true;
    }

    public boolean deleteFurniture(int id){
        if(!fr.existsById(id)) return false;
        fr.deleteById(id);
        return true;
    }
}
