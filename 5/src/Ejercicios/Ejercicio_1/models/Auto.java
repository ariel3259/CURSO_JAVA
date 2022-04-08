package Ejercicios.Ejercicio_1.models;

public class Auto {
    private final String enrollment;
    private final String branch;
    private final String model;

    public Auto(String enrollment, String branch, String model){
        this.enrollment = enrollment;
        this.branch = branch;
        this.model = model;
    }

    public void ShowCar(){
        System.out.println("Enrollment: "+ enrollment);
        System.out.println("Branch: "+ branch);
        System.out.println("Model: "+ model);
    }
}
