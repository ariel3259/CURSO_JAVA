package com.ariel.Lectura.Observer;

public class Peaton implements IObserver{
    private String name;

    public void parar(){
        System.out.println("Estoy en la esquina");

    }

    public void caminar(){
        System.out.println("Estoy caminando");
    }

    public void correr(){
        System.out.println("Estoy corriendo");
    }

    @Override
    public void update(String color) {
        if(color.equals("verde")){
            parar();
        }
    }
}
