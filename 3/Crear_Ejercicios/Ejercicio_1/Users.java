package Crear_Ejercicios.Ejercicio_1;

public class Users{

    private String name;
    private String lastName;
    private String email; 
    private String password;

    public Users(String name, String lastName, String email, String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString(){
        return "{\n"+"\tname: "+this.name+",\n"+"\tlastName: "+this.lastName+",\n"+"\temail: "+this.email+",\n"+"\tpassword: "+this.password+",\n"+"}";
        
    }

}