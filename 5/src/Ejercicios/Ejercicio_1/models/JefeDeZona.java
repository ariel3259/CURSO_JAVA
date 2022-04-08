package Ejercicios.Ejercicio_1.models;

import Ejercicios.Ejercicio_1.abstracts.PersonalData;
import Ejercicios.Ejercicio_1.interfaces.ISalary;
import java.util.LinkedList;
import java.util.List;

public class JefeDeZona extends PersonalData implements ISalary {

    private final String office;
    private final String stand;
    private Secretario secretary;
    private Auto car;
    private final List<Vendedor> traiders;
    private double salary;

    public JefeDeZona(String name, String lastName, String DNI, String address, Secretario secretary, Auto car, String stand, String office){
        super(name, lastName, DNI, address);
        traiders = new LinkedList<>();
        this.stand = stand;
        this.secretary = secretary;
        this.car = car;
        this.office = office;
    }

    @Override
    public void Show(){
        super.Show();
        System.out.println("Office: "+ office);
        System.out.println();
        System.out.println("Stand: "+ stand);
        System.out.println("Secretary: ");
        this.secretary.Show();
    }

    public void ChangeSecretary(Secretario secretary){
        this.secretary = secretary;
    }

    public void AddTraider(Vendedor traider){
        traider.setId(traiders.size() + 1);
        traiders.add(traider);
    }

    public void RemoveTraider(int id){
        traiders.remove(id - 1);
    }

    public void ChangeCar(Auto car){
        this.car = car;
    }

    @Override
    public void IncrementSalaryPerYear() {
        salary += (salary * 20) / 100;
    }
}
