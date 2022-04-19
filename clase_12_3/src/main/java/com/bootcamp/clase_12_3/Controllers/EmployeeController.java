package com.bootcamp.clase_12_3.Controllers;

import com.bootcamp.clase_12_3.Models.Employee;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    Employee[] employees = {
            new Employee(1, "George", "Bluth", "atencion telefonica", Date.valueOf("1977-4-15")),
            new Employee(2, "Janet", "Weaver", "veterinria", Date.valueOf("1975-8-5")),
            new Employee(3, "Emma", "Whong", "veterinaria", Date.valueOf("1980-8-16")),
            new Employee(4, "Eve", "Holt", "asistente", Date.valueOf("1976-9-22"))
    };

    @PostMapping("/save_employee/{date}")
    public Employee saveEmployee(@RequestBody Employee employee,@PathVariable(name = "date") String date){
        employee.setFechaDeNacimiento(Date.valueOf(date));
        employee.setId(employees.length + 1);
        return employee;
    }

    @GetMapping("/get_all_employees")
    public Employee[] getAllEmployees(){
        return employees;
    }

    @GetMapping("/get_one_employee/{id}")
    public Employee getOneEmployee(@PathVariable(name = "id") int id){
        if(((id -1) > (employees.length - 1)) || ((id - 1) < 0)){
            return new Employee(0, null, null, null, null);
        }
        return employees[id-1];
    }
}
