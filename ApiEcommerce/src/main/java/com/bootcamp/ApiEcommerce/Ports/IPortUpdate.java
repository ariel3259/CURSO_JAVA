package com.bootcamp.ApiEcommerce.Ports;

import org.springframework.http.ResponseEntity;

public interface IPortUpdate<T, S, I>{
    public ResponseEntity<S> updateElement(T element, I id);
}
