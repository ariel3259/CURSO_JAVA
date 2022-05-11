package com.bootcamp.Articles.JwtUtils.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Articles.JwtUtils.JwtUserDetailService;
import com.bootcamp.Articles.JwtUtils.TokenManager;
import com.bootcamp.Articles.JwtUtils.Model.JwtResponse;
import com.bootcamp.Articles.JwtUtils.Model.JwtUsers;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtUserDetailService detailService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenManager tokenManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> Auth(@RequestBody JwtUsers user) throws Exception{
		try {
			authManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}catch(DisabledException e) {
			throw new Exception("DISABLED_USER", e);
		}
		catch(BadCredentialsException e) {
			throw new Exception("BAD_CREDENTIALS", e);
		}
		final UserDetails userDetail = detailService.loadUserByUsername(user.getUsername());
		final String jwtToken = tokenManager.generateToken(userDetail);
		return ResponseEntity.status(200).body(new JwtResponse(jwtToken));
	}
}
