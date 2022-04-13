package com.ariel.Excercises.Exercises_1.People;

import com.ariel.Excercises.Exercises_1.Abstracts.Person;

public class Teacher  extends Person {
    private String Department;

    public Teacher(String Name, String LastName, String Dni, String civilState, String Department){
        super(Name, LastName, Dni, civilState);
        this.Department = Department;
    }

    public void changeDepartment(String Department){
        this.Department = Department;
    }

    @Override
    public String toString() {
        return super.toString() + " Teacher{" +
                "Department='" + Department + '\'' +
                '}'+
                '}';
    }
}
