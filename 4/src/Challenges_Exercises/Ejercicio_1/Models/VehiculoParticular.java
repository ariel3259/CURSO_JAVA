package Challenges_Exercises.Ejercicio_1.Models;

import Challenges_Exercises.Ejercicio_1.Abstracts.Vehiculo;

public class VehiculoParticular extends Vehiculo {

    private final int numeroDePuertas;

    /**
     *
     * @param matricula String
     * @param numeroDePuertas int
     */
    public VehiculoParticular(String matricula, int numeroDePuertas){
        super(matricula);
        this.numeroDePuertas = numeroDePuertas;
    }

    public int mostrarPuertas(){
        return this.numeroDePuertas;

    }

    /**
     *
     * @return int
     */
    public int getNumeroDePuertas(){
        return this.numeroDePuertas;
    }
}
