package com.ariel.Lectura.Factory;

public class EjeVehiculo extends FactoryActions{
    @Override
    public Acciones accionesFactory() {
        return new VehiculoAcciones();
    }
}
