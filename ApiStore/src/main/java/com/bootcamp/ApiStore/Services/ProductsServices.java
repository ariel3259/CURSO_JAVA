package com.bootcamp.ApiStore.Services;

import com.bootcamp.ApiStore.Model.Products;
import com.bootcamp.ApiStore.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServices {

    @Autowired
    private ProductsRepository pr;

    public List<Products> getProducts(){
        return (List<Products>) pr.findAll();
    }

    public boolean saveProduct(Products product){
        if(pr.existsByCode(product.getCode())) return false;
        pr.save(product);
        return true;
    }

    public boolean modifyProduct(Products product){
        if(!pr.existsById(product.getId()) || pr.existsByCode(product.getCode())) return false;
        pr.save(product);
        return true;
    }

    public boolean deleteProduct(int id){
        if(!pr.existsById(id)) return false;
        pr.deleteById(id);
        return true;
    }
}
