package com.bootcamp.clase_12_3.Models;


public class Animales {
    private String nombre;
    private int edad;
    private String herida;
    private String raza;
    private int id;

    public Animales(int id,String nombre, int edad, String herida, String raza){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.herida = herida;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getEdad() {
        return edad;
    }

    public String getHerida() {
        return herida;
    }

    public String getRaza() {
        return raza;
    }

    public int getId() {
        return id;
    }
}
