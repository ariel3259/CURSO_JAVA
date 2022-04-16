package com.ariel.Exercises.Ejercicio_1.Models;

public class InvoicingProducts {
    private int id;
    private int idInvoicing;
    private int idProduct;
    private int length;

    public InvoicingProducts(int idInvoicing, int idProduct, int length){
        this.idInvoicing = idInvoicing;
        this.idProduct = idProduct;
        this.length = length;
    }

    public InvoicingProducts(int id, int idInvoicing, int idProduct, int length){
        this.id = id;
        this.idInvoicing = idInvoicing;
        this.idProduct = idProduct;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInvoicing() {
        return idInvoicing;
    }

    public void setIdInvoicing(int idInvoicing) {
        this.idInvoicing = idInvoicing;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
