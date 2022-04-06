package Crear_Ejercicios.Ejercicio_2;

public class Minotauro extends Monstruo{

    public Minotauro(){
        health = 15;
        speed = 5;
        attackDamage = 2;
        attackType = "Fisico";
        alive = true;
        name = "Minotauro";
    }

    @Override
    public void specialAbility(Heroe h) {
        h.inflictStatus("Fear", 3);
        
    }

    @Override
    public int recieveDamage(String damageType, int damage) {
        if(damageType == "Fisico"){
            damage/=2;
        }
        health-=damage;
        if(health<0){
            alive = false;
        }
        return damage;
    }
}
