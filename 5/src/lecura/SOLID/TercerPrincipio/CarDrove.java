package lecura.SOLID.TercerPrincipio;

public class CarDrove {
    public static void main(String[] args) {
       String CarType = args[0];
       ICar car;
       if("PrincipioTres".equals(CarType)){
            car = new PrincipioTres();
           car.acelerar();
       }
       else if("CardElect".equals(CarType)){
            car = new CarElect();
            car.acelerar();

       }
       else{

       }

       car.acelerar();
    }
}
