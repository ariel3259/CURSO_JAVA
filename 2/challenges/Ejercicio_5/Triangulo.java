package challenges.Ejercicio_5;

public class Triangulo implements Figura {

    private int ladoA;
    private int ladoB;
    private int ladoC;
    private int altura;

    public Triangulo(int ladoA, int ladoB, int ladoC, int altura){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.altura = altura;
    }


    @Override
    public double getArea(){
        return (c*altura)/2;
    }

    @Override
    public int getPerimetetro() {
        return ladoA + ladoB + ladoC;
    }

}