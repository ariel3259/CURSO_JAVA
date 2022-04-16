package com.ariel.Exercises.Ejercicio_1.Models;

import java.sql.Date;

public class Traider {
    private int id;
    private String name;
    private String lastName;
    private int dni;
    private String address;
    private Double salary;
    private Date yearOfBorn;

    public Traider(int id, String name, String lastName, int dni, String address, Double salary, Date yearOfBorn){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.salary = salary;
        this.yearOfBorn = yearOfBorn;
    }

    public Traider( String name, String lastName, int dni, String address, Double salary, Date yearOfBorn){
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.address = address;
        this.salary = salary;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(Date yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }
}
