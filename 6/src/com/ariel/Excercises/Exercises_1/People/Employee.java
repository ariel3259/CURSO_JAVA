package com.ariel.Excercises.Exercises_1.People;

import com.ariel.Excercises.Exercises_1.Abstracts.Person;

public class Employee extends Person {

    private int OfficeNumber;
    private final int YearOfIncorporation;

    public Employee(String Name, String LastName, String Dni, String civilState, int OfficeNumber, int YearOfIncorporation){
        super(Name, LastName, Dni, civilState);
        this.OfficeNumber = OfficeNumber;
        this.YearOfIncorporation = YearOfIncorporation;
    }

    public void setOfficeNumber(int OfficeNumber){
        this.OfficeNumber = OfficeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" +
                "OfficeNumber=" + OfficeNumber +
                ", YearOfIncorporation=" + YearOfIncorporation +
                '}'+
                '}';
    }
}
