package com.ariel.Exercises.Ejercicio_1.Models;

public class Invoicing {
    private int id;
    private int idClient;
    private int idTrader;
    private double totalPrice;

    public Invoicing(int idClient, int idTrader){
        this.idClient = idClient;
        this.idTrader = idTrader;
    }

    public Invoicing(int id, int idClient, int idTrader, double totalPrice){
        this.id = id;
        this.idClient = idClient;
        this.idTrader = idTrader;
        this.totalPrice = totalPrice;
    }

    public Invoicing(int id, int idClient, int idTrader){
        this.id = id;
        this.idClient = idClient;
        this.idTrader = idTrader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdTrader() {
        return idTrader;
    }

    public void setIdTrader(int idTrader) {
        this.idTrader = idTrader;
    }
}
