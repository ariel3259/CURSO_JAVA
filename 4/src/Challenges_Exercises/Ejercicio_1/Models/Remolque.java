package Challenges_Exercises.Ejercicio_1.Models;

public class Remolque {

    private final double peso;

    public Remolque(double peso){
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Remolque{" +
                "peso=" + peso +
                '}';
    }
}
