package Challenges_Exercises.Ejercicio_1.Abstracts;

import Challenges_Exercises.Ejercicio_1.Exceptions.DemasiadoRapidoException;

public abstract class Vehiculo {
    protected final String matricula;
    protected int velocidad;

    /**
     *
     * @param matricula String
     */
    public Vehiculo(String matricula){
        this.matricula = matricula;
        this.velocidad = 0;
    }

    /**
     *
     * @return int
     */
    public int getVelocidad(){
        return velocidad;
    }

    /**
     *
     * @param velocidad int
     */
    public void AumentarVelocidad(int velocidad) throws DemasiadoRapidoException {
        this.velocidad += velocidad;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return "{\n"+
                        "\tmatricula: "+ matricula+",\n"+
                        "\tvelolcidad: "+velocidad+"\n"+
                "}";
    }
}
