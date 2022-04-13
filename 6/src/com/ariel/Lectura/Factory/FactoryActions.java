package com.ariel.Lectura.Factory;

public abstract class FactoryActions {

    public void renderAcciones(){
        Acciones accion = accionesFactory();
        accion.render();
    }

    public abstract Acciones accionesFactory();
}
