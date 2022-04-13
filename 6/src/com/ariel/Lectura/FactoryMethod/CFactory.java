package com.ariel.Lectura.FactoryMethod;

public class CFactory {

    public A create(int tipo){
        switch(tipo){
            case 1:
                return new A1();
            case 2:
                return new A2();
            default :
                return new Anothing();
        }
    }
}
