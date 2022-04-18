package com.ariel.Lectura.Observer;

public class Auto implements IObserver {
    private String patente;
    private String model;
    private String brand;

    public Auto(String patente, String model, String brand){
        this.patente = patente;
        this.model = model;
        this.brand = brand;
    }

    public void acelerar(){
        System.out.println("Estoy acelerando");
    }

    public void parar(){
        System.out.println("Estoy parado");
    }

    public void frenar(){
        System.out.println("Estoy frenando");
    }

    @Override
    public void update(String color) {
        if(color.equals("verde")){
            acelerar();
        }
    }
}
