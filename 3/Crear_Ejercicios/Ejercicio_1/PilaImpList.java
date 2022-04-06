package Crear_Ejercicios.Ejercicio_1;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class PilaImpList<E> implements Pila<E>{

    private List<E> list;

    public PilaImpList(){
        this.list = new LinkedList<E>();
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() throws EmptyStackException {
        if(list.size() > 0){
            E elementToRemove = list.get(list.size()-1);
            list.remove(list.size()-1);
            return elementToRemove;
        }
        throw new EmptyStackException();
    }

    @Override
    public E peek() throws EmptyStackException {
        if(list.size() > 0){
            E element = list.get(list.size()-1);
            return element;
        }
        throw new EmptyStackException();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}