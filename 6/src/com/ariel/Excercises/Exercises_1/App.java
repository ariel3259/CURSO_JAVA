package com.ariel.Excercises.Exercises_1;

import com.ariel.Excercises.Exercises_1.Abstracts.Person;
import com.ariel.Excercises.Exercises_1.People.Employee;
import com.ariel.Excercises.Exercises_1.People.PersonalService;
import com.ariel.Excercises.Exercises_1.People.Student;
import com.ariel.Excercises.Exercises_1.People.Teacher;

public class App {

    public static void main(String[] args) {

        //Students
        Person student1 = new Student("Carlos", "Rodrigues", "44.323.111",  "java");
        Person student2 = new Student("Rodrigo", "Selman", "22.111.421",  "php");
        Student student3 = new Student("Luis", "Santillan", "33.222.352", "java");

        student3.MatriculacionAUnCurso("mysql");

        System.out.println("Students: ");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println("#####################################################################################");

        //Employees
        Person employee1 = new Employee("Pepe", "Barrinton", "22.364.122", "casado", 15, 2017);
        Person employee2 = new Employee("Carlos", "Winchester", "11.222.354", "soltero", 30, 2019);
        Employee employee3 = new Employee("Gaspar", "Garcia", "22.325.423", "viudo", 8, 2012);

        employee3.setCivilState("casado");
        employee3.setOfficeNumber(20);

        System.out.println("Employees: ");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println("#####################################################################################");

        //Teachers
        Person teacher1 = new Teacher("George", "Bluth", "11.222.344", "soltero", "java");
        Person teacher2 = new Teacher("Janet", "Weaver", "34.555.324", "soltera", "php");
        Teacher teacher3 = new Teacher("Tracey", "Ramos", "11.344.543", "soltero", "mysql");

        teacher3.changeDepartment("javascript");

        System.out.println("Teachers: ");
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(teacher3);
        System.out.println("#####################################################################################");


        //PersonalService
        Person personalService1 = new PersonalService("Ema", "Wong", "22.444.112", "soltera", "bathrooms");
        Person personalService2 = new PersonalService("Charles", "Morris", "33.111.343", "soltero", "Halls");
        PersonalService personalService3 = new PersonalService("Eve", "Holt", "33.443.121", "soltera", "dining room");

        personalService3.setAssignedDistrict("classrooms");

        System.out.println("Personal Service: ");
        System.out.println(personalService1);
        System.out.println(personalService2);
        System.out.println(personalService3);
    }

}
