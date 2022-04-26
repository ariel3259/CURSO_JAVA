package com.bootcamp.ApiStore.Services;

import com.bootcamp.ApiStore.Model.Users;
import com.bootcamp.ApiStore.Repositories.UsersRepository;
import com.bootcamp.ApiStore.Requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository ur;

    @Autowired
    private PasswordEncoder bcrypt;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(!ur.existsByEmail(email)) throw new UsernameNotFoundException("El email no existe");
        Users user = ur.findUserByEmail(email).get();
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public Users save(LoginRequest loginRequest){
        Users newUser = new Users();
        newUser.setEmail(loginRequest.getEmail());
        newUser.setPassword(loginRequest.getPassword());
        return newUser;
    }
}
