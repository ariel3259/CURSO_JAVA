package com.ariel.Excercises.Exercises_1.People;

import com.ariel.Excercises.Exercises_1.Abstracts.Person;

public class Student extends Person {

    private String course;

    public Student(String Name, String LastName, String Dni, String course){
        super(Name, LastName, Dni, "soltero");
        this.course = course;
    }

    public void MatriculacionAUnCurso(String course){
        this.course = course;
    }

    @Override
    public String toString() {
        return super.toString() + " Student{" +
                "course='" + course + '\'' +
                '}'+
                '}';
    }
}
