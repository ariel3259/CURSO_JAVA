package com.ariel.Exercises.Ejercicio_1.Models;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private String address;
    private int dni;
    private String yearOfBorn;


    public Client(int id,String name, String lastName, String address, int dni, String yearOfBorn ){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.yearOfBorn = yearOfBorn;
    }

    public Client(String name, String lastName, String address, int dni, String yearOfBorn ){
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dni = dni;
        this.yearOfBorn = yearOfBorn;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(String yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }
}
