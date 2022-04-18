package com.ariel.Exercises.Ejercicio_1.Models;

import java.sql.Date;

public class Invoicing {
    private int id;
    private int idClient;
    private int idTrader;
    private double totalPrice;
    private Date boughtDate;

    public Invoicing(int idClient, int idTrader){
        this.idClient = idClient;
        this.idTrader = idTrader;
    }

    public Invoicing(int id, int idClient, int idTrader, double totalPrice, Date boughtDate){
        this.id = id;
        this.idClient = idClient;
        this.idTrader = idTrader;
        this.totalPrice = totalPrice;
        this.boughtDate = boughtDate;
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

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }
}
