
package challenges.Ejercicio_5;

public class Cuadrado implements Figura{

    private int ladoA;
    private int ladoB;
    private int ladoC;
    private int ladoD;

    public Cuadrado(int ladoA, int ladoB, int ladoC, int ladoD){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.ladoD = ladoD;
    }

    @Override
    public int getPerimetetro() {
     
        return ladoA + ladoB + ladoC + ladoD;
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return ladoA * ladoA;
    }

}