package com.bootcamp.ApiReservas;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class AEntryPoint extends BasicAuthenticationEntryPoint{
    @Override
    public void commence (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
        throws IOException, ServerException{
        response.addHeader("WWW-Authenticate", "Basic realm="+ getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer=response.getWriter();
        writer.println("Alert! Status 401 - " + authEx.getMessage());
    }
    @Override
    public void afterPropertiesSet(){
        setRealmName("POCfwhibbit");
        super.afterPropertiesSet();
    }
}
