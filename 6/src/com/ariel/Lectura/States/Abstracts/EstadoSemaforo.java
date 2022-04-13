package com.ariel.Lectura.States.Abstracts;

public abstract class EstadoSemaforo {

    public String color;

   // protected Semaforo semaforo;

    public EstadoSemaforo(){
    }

    public void setColor(String color){
        this.color = color;
    }

    public void showColor(){
        System.out.println("El color del semaforo es "+color);
    }

}
