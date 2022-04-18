package com.ariel.Lectura.Observer;

import java.util.ArrayList;

public class Semaforo implements IObserved {

    private ArrayList<IObserver> observers;
    private String color;

    public Semaforo(){
        color = "verde";
        observers = new ArrayList<>();
    }

    public void cambiarColor(String color){
        this.color = color;
    }

    @Override
    public void attach(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void dettach(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void ping() {
        for(IObserver observer: observers){
            observer.update(color);
        }
    }
}
