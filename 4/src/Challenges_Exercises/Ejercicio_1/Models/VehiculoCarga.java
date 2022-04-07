package Challenges_Exercises.Ejercicio_1.Models;

import Challenges_Exercises.Ejercicio_1.Abstracts.Vehiculo;
import Challenges_Exercises.Ejercicio_1.Exceptions.DemasiadoRapidoException;

public class VehiculoCarga extends Vehiculo {

    //Remolque remolque = ???
    private Remolque remolque;

    public VehiculoCarga(String matricula){
        super(matricula);
        remolque = null;
    }

    public void ponRemolque(Remolque remolque){
        this.remolque = remolque;
    }

    public void quitarRemolque(){
        remolque = null;
    }

    @Override
    public void AumentarVelocidad(int velocidad) throws DemasiadoRapidoException {
        if((remolque != null) && (this.velocidad + velocidad > 100)) throw new DemasiadoRapidoException();
        super.AumentarVelocidad(velocidad);
    }

    @Override
    public String toString() {
        if(remolque == null){
            return super.toString();
        }
        return "VehiculoCarga{" +
                "remolque=" + remolque +
                ";matricula="+ matricula+
                ";velocidad="+ velocidad+
                '}';
    }
}
