package com.ariel.Lectura.States;

import com.ariel.Lectura.States.Abstracts.EstadoSemaforo;

public class Verde extends EstadoSemaforo {

    public Verde(){
        setColor("verde");
    }

    public void showColor(){
        super.showColor();
    }
}
