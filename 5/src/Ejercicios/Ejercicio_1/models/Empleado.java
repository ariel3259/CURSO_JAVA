package Ejercicios.Ejercicio_1.models;

import Ejercicios.Ejercicio_1.abstracts.PersonalData;

public class Empleado extends PersonalData {
    private final String phone;
    private final int yearsOfAntiquity;
    private Empleado supervisor;
    private int salary;

    public Empleado(String name, String lastName, String DNI, String address, String phone, int salary, int yearsOfAntiquity){
        super(name, lastName, DNI, address);
        this.phone = phone;
        this.salary = salary;
        this.yearsOfAntiquity = yearsOfAntiquity;
        supervisor = null;
    }

    @Override
    public void Show(){
        super.Show();
        System.out.println("Phone: "+ phone);
        System.out.println("Years of antiquity: "+ (yearsOfAntiquity > 0 ? yearsOfAntiquity : "none" ));
        System.out.println("Salary: "+ salary);
        System.out.println("Supervisor: "+ (supervisor != null ? supervisor : "none"));
    }

    private void ChangeSupervisor(Empleado supervisor){
        this.supervisor = supervisor;
    }

    private void IncrementSalary(int salary){
        this.salary +=salary;
    }


}
