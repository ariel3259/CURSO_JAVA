package com.ariel.CreateExercises.Exercise_One;

import com.ariel.CreateExercises.Exercise_One.interfaces.StrategyMetodoDePago;

public class Caja {

    private StrategyMetodoDePago metodoDePago;

    public Caja(StrategyMetodoDePago metodoDePago){
        this.metodoDePago = metodoDePago;
    }

    public void pagar(){
        this.metodoDePago.pagar();
    }

    public double rembolso(){
        return this.metodoDePago.reembolsar();
    }
}
