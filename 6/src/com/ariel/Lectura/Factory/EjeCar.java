package com.ariel.Lectura.Factory;

public class EjeCar extends FactoryActions{
    @Override
    public Acciones accionesFactory() {
        return new CarActions();
    }
}
