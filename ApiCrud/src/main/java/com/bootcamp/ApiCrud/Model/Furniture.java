package com.bootcamp.ApiCrud.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Furniture {
    private double top;
    private double width;
    private String name;
    private String material;
}
