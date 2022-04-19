package com.bootcamp.clase_12_3.Models;

import java.sql.Date;

public class Employee {
    private String name, apellido, cargo;
    private int id;
    private Date fechaDeNacimiento;

    public Employee(int id,String name, String apellido, String cargo, Date fechaDeNacimiento){
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.cargo = cargo;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getcargo() {
        return cargo;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento){
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
