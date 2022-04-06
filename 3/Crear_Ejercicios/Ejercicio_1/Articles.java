package Crear_Ejercicios.Ejercicio_1;

class Articles{
    private String name;
    private double price;
    private int stock;

    public Articles(String name, Double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "{\n"+"\tname: "+this.name+",\n"+"\tprice: "+this.price+",\n"+"\tstock: "+this.stock+",\n"+"}";
        
    }

}