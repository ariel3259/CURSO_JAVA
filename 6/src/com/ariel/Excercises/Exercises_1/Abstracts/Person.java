package com.ariel.Excercises.Exercises_1.Abstracts;

public abstract class Person {
    private final String Name;
    private final String LastName;
    private final String Dni;
    private String civilState;

    public Person(String Name, String LastName, String Dni, String civilState){
        this.Name = Name;
        this.LastName = LastName;
        this.Dni = Dni;
        this.civilState = civilState;
    }

    public void setCivilState(String civilState){
        this.civilState = civilState;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Dni='" + Dni + '\'' +
                ", civilState='" + civilState + '\'' +
                ',';
    }
}
