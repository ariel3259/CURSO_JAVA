package com.ariel.Model;

public class Users {
    private int id;
    private String name;
    private String lastName;
    private int dni;

    public Users(int id, String name, String lastName, int dni){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
