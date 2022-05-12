package com.bootcamp.Articles.JwtUtils;

import java.io.IOException;
import java.lang.System.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUserDetailService detailService;
	
	@Autowired 
	private TokenManager manager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;
		if(tokenHeader != null  && tokenHeader.startsWith("Bearer ")) {
			token = tokenHeader.substring(7);
			try {
				username = manager.getUsernameFromToken(token);
			} catch(IllegalArgumentException e) {
				logger.warn("Invalid token" + e);
			}
			catch(ExpiredJwtException e) {
				logger.warn("token has expired" + e);
			}catch(SignatureException e) {
				logger.warn("Invalid username or password" + e);
			}
		}
		else System.out.println("Bearer token not found ");
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetail = detailService.loadUserByUsername(username);
			if(manager.validateToken(token, userDetail)){
	            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	            userDetail, null,
	            userDetail.getAuthorities());
	            authenticationToken.setDetails(new
	            WebAuthenticationDetailsSource().buildDetails(request));
	            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	         }
		}
		filterChain.doFilter(request, response);
	}

}
