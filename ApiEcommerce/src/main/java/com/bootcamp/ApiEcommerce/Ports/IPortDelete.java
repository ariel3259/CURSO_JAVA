package com.bootcamp.ApiEcommerce.Ports;

import org.springframework.http.ResponseEntity;

public interface IPortDelete<T, S>{
     public ResponseEntity<S> deleteElement(T id);
}
