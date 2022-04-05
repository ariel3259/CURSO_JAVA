package challenges.Ejercicio_1;

class  Calculadora{
    private float numero1;
    private float numero2;
    
    public Calculadora(float numero1, float numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public float Suma(){
        return this.numero1 + this.numero2;
    }

    public float Resta(){
        return this.numero1 - this.numero2;
    }

    public float Multiplicar(){
        return this.numero1 * this.numero2;
    }

    public double Dividir(){
        return this.numero1 / this.numero2;
    }


}