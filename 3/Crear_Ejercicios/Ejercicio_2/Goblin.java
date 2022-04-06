package Crear_Ejercicios.Ejercicio_2;

public class Goblin extends Monstruo{

    public Goblin(){
        health = 10;
        speed = 5;
        attackDamage = 1;
        attackType = "Fisico";
        alive = true;
        name = "Goblin";
    }

    @Override
    public void specialAbility(Heroe h) {
        h.inflictStatus("poison", 3);
    }

}
