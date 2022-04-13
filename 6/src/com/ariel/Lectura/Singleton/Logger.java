package com.ariel.Lectura.Singleton;

//Singleton pattern
//Pros
//Se usa una misma instancia de este objeto para todas las demas clases
//Gestiona mejor la memoria
//Contras:
//Como es una misma instancia, otras clases pueden modificar el valor de esta misma
public class Logger {

    private static Logger log;
    private String value;
    private Logger(){

    }

    public static Logger getInstance(){
        if(log == null){
            log = new Logger();
        }
        return log;
    }

    public void setValue(String msg){
        value = msg;
    }

    public void ShowValue(){
        System.out.println(value);
    }
}
