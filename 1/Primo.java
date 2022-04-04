public class Primo{

    private int numero;

    public Primo(int numero){
        this.numero = numero;
    }

    public boolean soyPrimo(){
        int divisor = 2;

        boolean primo = this.numero == 1 ? false : true;
        
        while(primo && divisor <= Math.sqrt(numero)){

            if(numero%divisor == 0) primo = false;
            divisor++;
        }

        return primo;

    }
}