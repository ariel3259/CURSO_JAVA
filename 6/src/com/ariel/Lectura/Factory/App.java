package com.ariel.Lectura.Factory;

public class App {
    public static void main(String[] args) {
        FactoryActions carActions = new EjeCar();
        FactoryActions vehicleActions = new EjeVehiculo();
        carActions.renderAcciones();
        vehicleActions.renderAcciones();
    }
}
