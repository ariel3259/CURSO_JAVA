package com.bootcamp.ApiStore.Services;

import com.bootcamp.ApiStore.Model.Users;
import com.bootcamp.ApiStore.Repositories.UsersRepository;
import com.bootcamp.ApiStore.Requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService{

    @Autowired
    private UsersRepository ur;

    @Autowired
    private PasswordEncoder bcrypt;

    public boolean Register(Users users){
        if(ur.existsByEmail(users.getEmail())){
            return false;
        }
        String passwordHashed = bcrypt.encode(users.getPassword());
        users.setPassword(passwordHashed);
        ur.save(users);
        return true;
    }

    public boolean Auth(LoginRequest loginRequest){
        if(!ur.existsByEmail(loginRequest.getEmail())){
            return false;
        }
        Users userToValidate = ur.findUserByEmail(loginRequest.getEmail()).get();
        boolean validation = bcrypt.matches(loginRequest.getPassword(), userToValidate.getPassword());
        return validation;
    }

}
