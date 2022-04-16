package com.ariel.Exercises.Ejercicio_1.Program;

import com.ariel.Exercises.Ejercicio_1.Interfaces.IDelete;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IInsert;
import com.ariel.Exercises.Ejercicio_1.Interfaces.ISelect;
import com.ariel.Exercises.Ejercicio_1.Interfaces.IUpdate;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products.DeleteProduct;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products.InsertProduct;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products.SelectProducts;
import com.ariel.Exercises.Ejercicio_1.InterfacesImp.Products.UpdateProduct;
import com.ariel.Exercises.Ejercicio_1.Models.Products;

import java.util.List;
import java.util.Scanner;

public class ProgramProducts {

    private static ProgramProducts instance;

    private final Scanner sc;

    private ProgramProducts(){
        sc = new Scanner(System.in);
    }

    public static ProgramProducts getInstance(){
        if(instance == null){
            instance = new ProgramProducts();
        }
        return instance;
    }

    public void ShowProducts(){
        ISelect<Products> productsISelect = SelectProducts.getInstance();
        List<Products> products = productsISelect.getElements();
        if(products.isEmpty()){
            System.out.println("There is no products");
        }
        else{
            System.out.println("[");
            for (Products product: products){
                System.out.println("\t{");
                System.out.println("\t\tCode product: " + product.getCodeProduct() + ",");
                System.out.println("\t\tName product: " + product.getName() + ",");
                System.out.println("\t\tPrice: " + product.getPrice() + ",");
                System.out.println("\t\tStock: " + product.getStock() + ",");
                System.out.println("\t\tMin stock: " + product.getMinStock() + ",");
                System.out.println("\t},");
            }
            System.out.println("]");
        }
    }

    public void SaveProduct(){
        IInsert<Products> insertProduct = InsertProduct.getInstance();
        int stock, minStock, codeProduct;
        double price;
        String name;

        System.out.println("Name: ");
        name = sc.nextLine();

        System.out.println("Code product: ");
        codeProduct = sc.nextInt();

        System.out.println("Price: ");
        price = sc.nextDouble();

        System.out.println("Stock: ");
        stock = sc.nextInt();

        System.out.println("Min stock: ");
        minStock = sc.nextInt();

        insertProduct.insertElement(new Products(codeProduct, name, price, stock, minStock));

        System.out.println("Product saved");
    }

    public void UpdateProduct(){
        IUpdate<Products> insertProduct = UpdateProduct.getInstance();
        int stock, minStock, codeProduct, id;
        double price;
        String name;

        System.out.println("Id product: ");
        id = sc.nextInt();

        System.out.println("Name: ");
        name = sc.nextLine();

        System.out.println("Code product: ");
        codeProduct = sc.nextInt();

        System.out.println("Price: ");
        price = sc.nextDouble();

        System.out.println("Stock: ");
        stock = sc.nextInt();

        System.out.println("Min stock: ");
        minStock = sc.nextInt();

        insertProduct.updateElement(new Products(id, codeProduct, name, price, stock, minStock));

        System.out.println("Product modified");
    }

    public void DeleteProduct(){
        IDelete deleteProduct = DeleteProduct.getInstance();
        int id;

        System.out.println("Id product: ");
        id = sc.nextInt();

        deleteProduct.deleteElement(id);

        System.out.println("Deleted product");
    }

}
