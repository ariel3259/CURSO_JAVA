package com.ariel.Lectura.States;

import com.ariel.Lectura.States.Abstracts.EstadoSemaforo;

public class Semaforo {
    private EstadoSemaforo estadoSemaforo;

    public Semaforo(){
        estadoSemaforo = new Verde();
    }

    public void cambiarEstado(EstadoSemaforo estadoSemaforo){
        this.estadoSemaforo = estadoSemaforo;
    }

    public void ShowLight(){
        this.estadoSemaforo.showColor();
    }
}
