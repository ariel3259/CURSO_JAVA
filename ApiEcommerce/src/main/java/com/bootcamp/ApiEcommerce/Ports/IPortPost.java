package com.bootcamp.ApiEcommerce.Ports;

import org.springframework.http.ResponseEntity;

public interface IPortPost <T, S>{
    public ResponseEntity<S> postElement(T element);
}
