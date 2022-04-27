package com.bootcamp.Users;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bootcamp.Users.Model.Users;
import com.bootcamp.Users.Repository.UsersRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsersRepository ur;
	
	@Override
	public void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.httpBasic()
		.and()
		.cors()
		.and()
		.csrf()
		.disable();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder amb) throws Exception {
		amb.userDetailsService(username -> {
			Users user = ur.findByUsername(username);
			if(user == null) {
				throw new UsernameNotFoundException("User not found "+ username);
			}
			else {
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("user"));
			}
			
		});
	}

}
