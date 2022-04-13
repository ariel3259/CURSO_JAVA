package com.ariel.CreateExercises.Exercise_One.MetodosDePago;

import com.ariel.CreateExercises.Exercise_One.Exceptions.NoEnoughMoneyException;
import com.ariel.CreateExercises.Exercise_One.interfaces.StrategyMetodoDePago;

public class Creditos implements StrategyMetodoDePago {

    private double plataAPagar;
    private double plataPagada;
    public SaldoBancario saldoBancario;

    public Creditos(double plataAPagar){
        this.plataAPagar = plataAPagar;
        saldoBancario = SaldoBancario.getInstance();
    }

    @Override
    public void pagar() {
        try{
            if(saldoBancario.getFondoCredito() < plataAPagar ) throw new NoEnoughMoneyException();
            plataPagada += saldoBancario.getFondoCredito();
            saldoBancario.setFondoCredito(saldoBancario.getFondoCredito() - plataAPagar);
            plataAPagar -= saldoBancario.getFondoCredito();
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
        return saldoBancario.getFondoCredito();
    }
}
