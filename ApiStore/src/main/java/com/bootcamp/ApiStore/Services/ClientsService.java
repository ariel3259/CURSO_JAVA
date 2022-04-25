package com.bootcamp.ApiStore.Services;

import com.bootcamp.ApiStore.Model.Clients;
import com.bootcamp.ApiStore.Repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository cr;

    public List<Clients> getClients(){
        return (List<Clients>) cr.findAll();
    }

    public boolean saveClient(Clients client){
        if(cr.existsByDni(client.getDni())) return false;
        cr.save(client);
        return true;
    }

    public boolean modifyClient(Clients client){
        if(!cr.existsById(client.getId()) || cr.existsByDni(client.getDni())) return false;
        cr.save(client);
        return true;
    }

    public boolean deleteClient(int id){
        if(!cr.existsById(id)) return false;
        cr.deleteById(id);
        return true;
    }
}
