package Crear_Ejercicios.Ejercicio_1;

//E tipo de dato generico

public interface Pila<E> {
    public void push(E element); // Agrega un elemento al final
    public E pop(); // Devuelve el último elemento que se ingreso y lo elimina
    public E peek(); // Devuelve el elemento que esta arriba de la pila sin sacarlo
    public boolean isEmpty(); 
}