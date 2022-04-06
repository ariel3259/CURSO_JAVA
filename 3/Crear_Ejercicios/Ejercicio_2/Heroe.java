package Crear_Ejercicios.Ejercicio_2;

import java.util.List;

public class Heroe{
    private int health;
    private int speed;
    private String attackType;
    private int attackDamage;
    private boolean alive;
    private int status;
    private String statusName;

    public Heroe(){
        health = 50;
        speed = 10;
        attackType = "Fisico";
        attackDamage = 6;
        alive = true;
    }
    public void inflictStatus(String string, int turns) {
        statusName = string;
        status = turns;
    }

    public void passTurn(){
        if(status>0){
            status--;
        }
    }

    public int getSpeed(){
        return speed;
    }

    public String getStatus(){
        return statusName;
    }

    public String getAttackType() {
        return attackType;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive(){
        return alive;
    }

    public int getDamage(){
        return attackDamage;
    }

    public void recieveDamage(String damageType, int damage){
        health-=damage;
        if(health<0){
            alive = false;
        }
    }

}
