package com.bootcamp.ApiEcommerce.Ports;

import org.springframework.http.ResponseEntity;

public interface IPortGet <T>{
    public ResponseEntity<T> getElement();
}
