package Ejercicios.Ejercicio_1.abstracts;

public abstract class PersonalData {
    private final String name;
    private final String lastName;
    private final String DNI;
    private final String address;

    public PersonalData(String name, String lastName, String DNI, String address){
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.address = address;
    }

    public void Show(){
        System.out.println("Name: "+ name);
        System.out.println("Last name: "+ lastName);
        System.out.println("DNI: "+ DNI);
        System.out.println("Address: "+ address);
    }
}
