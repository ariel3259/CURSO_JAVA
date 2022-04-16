package com.ariel.Lectura.Observer;

public interface Observed {

    //Añadir un observador
    public void attach(IObserver observer);

    //Eliminar un observador
    public void dettach(IObserver observer);

    //Notificar a un observador
    public void ping();
}
