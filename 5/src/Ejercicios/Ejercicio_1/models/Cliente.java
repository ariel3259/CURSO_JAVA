package Ejercicios.Ejercicio_1.models;

import Ejercicios.Ejercicio_1.abstracts.PersonalData;

public class Cliente extends PersonalData {

    private int id;

    private Cliente(String name, String lastName, String DNI, String address){
        super(name, lastName, DNI, address);
        this.id = 0;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public void Show(){
        System.out.println("Id: "+id);
        super.Show();
    }

}
