package lecura.SOLID.segundoPrincipio;

public class Vehiculo extends  PrincipioDos{

    /*
     Nunca sobrescribir el metodo original, solo se redefine el metodo
     que se va a usar pero nunca cambiar el comportamiento del metodo original
     */
    @Override
    void acelerar(){
        super.acelerar();
    }
}
