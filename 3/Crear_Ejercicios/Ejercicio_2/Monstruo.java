package Crear_Ejercicios.Ejercicio_2;

public abstract class Monstruo {
    protected int health;
    protected int speed;
    protected String attackType;
    protected int attackDamage;
    protected boolean alive;
    protected String name;

    public String getName(){
        return name;
    }

    public int getSpeed(){
        return speed;
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

    public int recieveDamage(String damageType, int damage){
        health-=damage;
        if(health<0){
            alive = false;
        }
        return damage;
    }


    public abstract void specialAbility(Heroe h);
}
