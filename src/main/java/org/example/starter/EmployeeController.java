package org.example.starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/search")
    public String sayHelloWorld(String name){
        return "Hey there: "+ name+ " Welcome to the App";
    }

}
