package com.bootcamp.ApiCrud.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class ArmChair {
    private String name;
    private String material;
    private String color;
}
