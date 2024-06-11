package org.example.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class EmployeeController {
    HashMap<Integer, Employee> employeeMap=new HashMap<>();


   private static Logger log=LoggerFactory.getLogger(EmployeeController.class);

   @GetMapping("/logTest")
   public String logTest(){
       log.error("This is an error log");
       log.warn("This is an error log");
       log.info("This is an error log");
       log.debug("This is an error log");
       log.trace("This is an error log");
       return "Testing";
   }

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
