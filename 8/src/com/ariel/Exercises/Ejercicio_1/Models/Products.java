package com.ariel.Exercises.Ejercicio_1.Models;

public class Products {
    private int id;
    private int codeProduct;
    private String name;
    private double price;
    private int stock;
    private int minStock;

    public Products(int codeProduct, String name, double price, int stock, int minStock){
        this.codeProduct = codeProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
    }

    public Products(int id ,int codeProduct, String name, double price, int stock, int minStock){
        this.id = id;
        this.codeProduct = codeProduct;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }
}
