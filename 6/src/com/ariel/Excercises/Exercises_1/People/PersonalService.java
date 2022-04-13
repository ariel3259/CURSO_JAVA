package com.ariel.Excercises.Exercises_1.People;

import com.ariel.Excercises.Exercises_1.Abstracts.Person;

public class PersonalService extends Person {

    private String assignedDistrict;

    public  PersonalService(String Name, String LastName, String Dni, String civilState, String assignedDistrict){
        super(Name, LastName, Dni, civilState);
        this.assignedDistrict = assignedDistrict;
    }

    public void setAssignedDistrict(String assignedDistrict){
        this.assignedDistrict = assignedDistrict;
    }

    @Override
    public String toString() {
        return super.toString() + " PersonalService{" +
                "assignedDistrict='" + assignedDistrict + '\'' +
                '}'+
                '}';
    }
}
