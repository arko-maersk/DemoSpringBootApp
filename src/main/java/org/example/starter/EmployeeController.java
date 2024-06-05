package org.example.starter;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class EmployeeController {
    HashMap<Integer, Employee> employeeMap=new HashMap<>();


    @GetMapping("/search/{name}")
    public String sayHelloWorld(@PathVariable("name") String name){
        System.out.println("Welcome "+name);
        return "Hey there: "+ name+ " Welcome to the App";
    }
    @PostMapping("/createEmployee")
    public void createEmp(@RequestBody Employee employee){
        this.employeeMap.put(employee.getId(),employee);
    }

    @GetMapping("/getEmployee")
    public HashMap<Integer,Employee> viewEmp(){
        return this.employeeMap;
    }

    @PutMapping("/employee/id/{id}")
    public Employee updateEmp( @RequestBody Employee employee){
        this.employeeMap.put(employee.getId(),employee);
        return employeeMap.get(employee.getId());
    }

}
