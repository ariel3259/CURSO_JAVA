package com.ariel.CreateExercises.Exercise_One.MetodosDePago;

import com.ariel.CreateExercises.Exercise_One.Exceptions.NoEnoughMoneyException;
import com.ariel.CreateExercises.Exercise_One.interfaces.StrategyMetodoDePago;

public class Efectivo implements StrategyMetodoDePago {

    private double plataAPagar;
    private double plataPagada;
    private double plata;

    public Efectivo(double plataAPagar){
        this.plataAPagar = plataAPagar;
        plata = 750;
    }


    @Override
    public void pagar() {
        try{
            if(plata < plataAPagar ) throw new NoEnoughMoneyException();
            plataPagada += plata;
            plataAPagar -= plata;
        }
        catch (NoEnoughMoneyException e){
            System.out.println(e);
            System.exit(1);
        }
    }

    @Override
    public double reembolsar() {
        return plataPagada;
    }

    @Override
    public double getFondo() {
        return plata;
    }
}
