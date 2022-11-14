package pro.sky.java.course2.homeworkspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homeworkspring.service.EmployeeService;

@RestController
public class EmployeeController {

    @GetMapping
    public String showHelloWorld() {
        return "Hello World";
    }

}
