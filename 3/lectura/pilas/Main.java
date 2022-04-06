package lectura.pilas;

public class Main{

    public static void main(String[] args) {
        int length = 4;
        Pilas pila = new Pilas(length);
        if(!pila.isFilled()){
            pila.push("Esto ");
            pila.push("Es");
            pila.push("Pila");
        }
        System.out.println(pila.view());
        while(!pila.isEmpty()){
            System.out.println(pila.pop());
        }
    }
}