
public class Triangulo{

    private int ladoA;
    private int ladoB;
    private int ladoC;

    public Triangulo(int ladoA, int ladoB, int ladoC){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public String queSoy(){

        if((ladoA == ladoC) || (ladoB == ladoC) || (ladoA == ladoB)) return "isoseles";
        if((ladoA == ladoB) && (ladoB == ladoC) && (ladoC == ladoA)) return "equilatero";
        else return "escaleno";
    }

}