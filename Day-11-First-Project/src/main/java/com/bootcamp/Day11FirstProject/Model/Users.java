package com.bootcamp.Day11FirstProject.Model;

import io.swagger.annotations.ApiModelProperty;

public class Users {
    private Integer id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String lastName;
    @ApiModelProperty(required = true)
    private Integer dni;

    public Users() {
    	
    }
    
    public Users(String name, String lastName, Integer dni){
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public Users(int id, String name, String lastName, int dni){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }
}
