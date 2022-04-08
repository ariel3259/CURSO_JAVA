package Ejercicios.Ejercicio_1.models;

import Ejercicios.Ejercicio_1.abstracts.PersonalData;
import Ejercicios.Ejercicio_1.interfaces.ISalary;

public class Secretario extends PersonalData implements ISalary {

    private final String office;
    private final String faxNumber;
    private double salary;

    public Secretario(String name, String lastName, String DNI, String address, String office, String faxNumber , double salary){
        super(name, lastName, DNI, address);
        this.office = office;
        this.faxNumber = faxNumber;
        this.salary = salary;
    }

    @Override
    public void IncrementSalaryPerYear() {
        this.salary += (this.salary * 5) / 100;
    }


    @Override
    public void Show(){
        super.Show();
        System.out.println("Office: "+office);
        System.out.println("Fax number: "+faxNumber);
        System.out.println("Salary: "+ salary);
    }

}
