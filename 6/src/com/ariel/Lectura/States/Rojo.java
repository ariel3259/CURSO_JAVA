package com.ariel.Lectura.States;

import com.ariel.Lectura.States.Abstracts.EstadoSemaforo;

public class Rojo extends EstadoSemaforo {

    public Rojo(){
        setColor("rojo");
    }

    public void showColor(){
        super.showColor();
    }
}
