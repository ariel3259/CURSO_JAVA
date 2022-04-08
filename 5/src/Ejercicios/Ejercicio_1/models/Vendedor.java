package Ejercicios.Ejercicio_1.models;

import Ejercicios.Ejercicio_1.abstracts.PersonalData;
import Ejercicios.Ejercicio_1.interfaces.ISalary;

import java.util.LinkedList;
import java.util.List;

public class Vendedor extends PersonalData implements ISalary {

    private int id;
    private final String phone;
    private final String tradingDistrict;
    private double salary;
    private final List<Cliente> clients;


    public Vendedor(String name, String lastName, String DNI, String address, String phone, String tradingDistrict){
        super(name, lastName, DNI, address);
        id = 0;
        this.phone = phone;
        this.tradingDistrict = tradingDistrict;
        clients = new LinkedList<>();
    }

    @Override
    public void IncrementSalaryPerYear() {
        this.salary += (this.salary * 10) / 100;
    }

    @Override
    public void Show(){
        System.out.println("Id: "+ id);
        super.Show();
        System.out.println("Number phone: "+ phone);
        System.out.println("Trading district: "+tradingDistrict);
    }

    public void ShowClients(){
        System.out.println("Clients: ");
        for(Cliente client: clients){
            System.out.println("############################################");
            client.Show();
            System.out.println("############################################");
        }
    }

    public void setId(int id){
        this.id = id;
    }

    private void AddClient(Cliente client){
        client.setId(clients.size()+1);
        clients.add(client);
    }

    private void DeleteClient(int id){
        this.clients.remove(id-1);
    }
}
