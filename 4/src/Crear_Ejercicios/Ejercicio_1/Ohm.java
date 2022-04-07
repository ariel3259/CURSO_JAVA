package Crear_Ejercicios.Ejercicio_1;

public class Ohm {

    public Ohm(){ }

    public double obtenerPotencia(double resistencia, double intensidad){
        return resistencia * Math.pow(intensidad, 2);
    }

    public double obtenerIntentcidad(double potencia, double voltios){
        return potencia / voltios;
    }

    public double obtenerResistencia(double voltios, double potencia){
        return Math.pow(voltios, 2) / potencia;
    }

    public double obtenerTension(double potencia, double voltios){
        return Math.sqrt(potencia * voltios);
    }

}
