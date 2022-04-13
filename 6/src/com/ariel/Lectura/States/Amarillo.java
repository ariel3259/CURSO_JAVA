package com.ariel.Lectura.States;

import com.ariel.Lectura.States.Abstracts.EstadoSemaforo;

public class Amarillo extends EstadoSemaforo {

    public Amarillo(){
        setColor("Amarillo");
    }

    public void showColor(){
        super.showColor();
    }
}
