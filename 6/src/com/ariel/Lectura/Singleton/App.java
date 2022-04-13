package com.ariel.Lectura.Singleton;

public class App {

    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.setValue("Hola");
        log2.setValue("Hola 2");
        log1.ShowValue();
    }
}
