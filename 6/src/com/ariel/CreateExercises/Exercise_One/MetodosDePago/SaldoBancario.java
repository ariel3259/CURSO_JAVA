package com.ariel.CreateExercises.Exercise_One.MetodosDePago;

public final class SaldoBancario {
    private double fondoDebito;
    private double fondoCredito;
    private static SaldoBancario instance;

    private SaldoBancario(){
        fondoCredito = 750;
        fondoDebito = 750;
    }

    public static SaldoBancario getInstance(){
        if(instance == null){
            instance = new SaldoBancario();
        }
        return instance;
    }

    public double getFondoCredito() {
        return fondoCredito;
    }

    public void setFondoCredito(double fondoCredito) {
        this.fondoCredito = fondoCredito;
    }

    public double getFondoDebito() {
        return fondoDebito;
    }

    public void setFondoDebito(double fondoDebito) {
        this.fondoDebito = fondoDebito;
    }
}
