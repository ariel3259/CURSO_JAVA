package com.ariel.Lectura.ConnectToDb.Models;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String phone;
    private int dni;
    private String typeOfUser;

    public Person( String name, String lastName, String phone, int dni, String typeOfUser){
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.dni = dni;
        this.typeOfUser = typeOfUser;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
