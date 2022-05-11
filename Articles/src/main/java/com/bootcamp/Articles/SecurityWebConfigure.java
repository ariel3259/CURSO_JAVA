package com.bootcamp.Articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bootcamp.Articles.JwtUtils.JwtEntryPoint;
import com.bootcamp.Articles.JwtUtils.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityWebConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtEntryPoint entryPoint;
	
	@Autowired
	private UserDetailsService deailsService;
	
	@Autowired
	private JwtFilter filter;
	
	@Autowired
	private PasswordEncoder bcrypt;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(this.deailsService).passwordEncoder(this.bcrypt);
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws
		Exception {
	     	return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
			.authorizeHttpRequests().antMatchers("/login").permitAll()
			.and()
			.authorizeHttpRequests().antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(entryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
}
