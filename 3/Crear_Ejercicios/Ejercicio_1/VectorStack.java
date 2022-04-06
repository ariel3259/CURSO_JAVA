package Crear_Ejercicios.Ejercicio_1;

import java.util.EmptyStackException;
import java.util.Vector;
public class VectorStack<E> implements Pila<E>{
    Vector<E> vector;
    public VectorStack(){
        vector = new Vector<E>();
    }
    
    @Override
    public void push(E element) {
        vector.addElement(element);
    }
    @Override
    public E pop() {
        if(vector.size()>0){
            return vector.remove(vector.size()-1);
        }
        throw new EmptyStackException();
    }
    @Override
    public E peek() {
        try {
            return vector.lastElement();
        } catch (Exception e) {
            throw new EmptyStackException();
        }
    }
    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }
}