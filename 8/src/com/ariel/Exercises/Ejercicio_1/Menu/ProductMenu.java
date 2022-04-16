package com.ariel.Exercises.Ejercicio_1.Menu;

import com.ariel.Exercises.Ejercicio_1.Program.ProgramProducts;

import java.util.Scanner;

public class ProductMenu {
    private static ProductMenu instance;

    private ProductMenu(){
        Scanner sc = new Scanner(System.in);
        int opc;
        boolean flag = false;
        ProgramProducts programProducts = ProgramProducts.getInstance();
        while(!flag){
            System.out.println("##########################################################");
            System.out.println("1- Show products");
            System.out.println("2- Save product");
            System.out.println("3- Update product");
            System.out.println("4- Delete product");
            System.out.println("5- Go back to main menu");
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    programProducts.ShowProducts();
                    break;
                case 2:
                    programProducts.SaveProduct();
                    break;
                case 3:
                    programProducts.UpdateProduct();
                case 4:
                    programProducts.DeleteProduct();
                case 5:
                    flag = true;
                    break;
            }
        }
    }

    public static ProductMenu getInstance(){
        if(instance == null){
            instance = new ProductMenu();
        }
        return instance;
    }
}
