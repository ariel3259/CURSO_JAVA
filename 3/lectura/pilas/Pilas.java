package lectura.pilas;

import java.util.EmptyStackException;

public class Pilas{

    private int size;
    private String[] array;
    private int top = -1;

    public Pilas(int size)throws EmptyStackException{
        if(size == 0) throw new EmptyStackException();
        this.size = size;
        array = new String[size];
    }

    public void push(String value) {
        array[++top] = value;
    }

    public String pop(){
        return array[top--];
    }

    public boolean isEmpty(){
        return  top < 0;
    }

    public String view(){
        return array[top];
    }

    public boolean isFilled(){
        return top == (size - 1);
    }
}