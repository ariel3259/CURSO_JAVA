package com.bootcamp.clase_12_3.Models;

public class Person {
    private String name, lastName;
    private int id;

    public Person(int id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
