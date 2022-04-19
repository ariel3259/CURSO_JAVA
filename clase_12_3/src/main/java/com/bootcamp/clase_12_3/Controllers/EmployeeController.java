package com.bootcamp.clase_12_3.Controllers;

import com.bootcamp.clase_12_3.Models.Employee;
import com.bootcamp.clase_12_3.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save_employee/{date}")
    public Employee saveEmployee(@RequestBody Employee employee,@PathVariable(name = "date") String date){
       return employeeService.saveEmployee(employee, date);
    }

    @GetMapping("/get_all_employees")
    public Employee[] getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/get_one_employee/{id}")
    public Employee getOneEmployee(@PathVariable(name = "id") int id){
       return employeeService.getEmployee(id);
    }
}
