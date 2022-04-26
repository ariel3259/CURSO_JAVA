package com.bootcamp.ApiStore.Services;

import com.bootcamp.ApiStore.Model.Users;
import com.bootcamp.ApiStore.Repositories.UsersRepository;
import com.bootcamp.ApiStore.Utils.JwtRequest;
import com.bootcamp.ApiStore.Utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService{

    @Autowired
    private UsersRepository ur;

    @Autowired
    private PasswordEncoder bcrypt;

    @Autowired
    private AuthenticationManager at;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public boolean Register(Users users){
        if(ur.existsByEmail(users.getEmail())){
            return false;
        }
        String passwordHashed = bcrypt.encode(users.getPassword());
        users.setPassword(passwordHashed);
        ur.save(users);
        return true;
    }

    public String Auth(JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    private void authenticate(String email, String password) throws Exception{
        try{
            at.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }catch (DisabledException d){
            throw new Exception("USER_DISABLED", d);
        }
        catch (BadCredentialsException bce){
            throw new Exception("INVALID_CREDENTIALS", bce);
        }
    }

}
