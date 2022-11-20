package pro.sky.java.course2.homeworkspring.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.homeworkspring.model.Employee;
import pro.sky.java.course2.homeworkspring.record.EmployeeRequest;
import pro.sky.java.course2.homeworkspring.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employee/salary/sum")
    public double getSalarySum() {
        return this.employeeService.getSalarySum();
    }
    @GetMapping("/employee/salary/min")
    public Employee getMinSalaryEmployee() {
        return this.employeeService.getMinSalaryEmployee();
    }
    @GetMapping("/employee/salary/max")
    public Employee getMaxSalaryEmployee() {
        return this.employeeService.getMaxSalaryEmployee();
    }
    @GetMapping("/employee/high-salary")
    public List<Employee> getMaxSalaryOfArrayEmployee() {
        return this.employeeService.getMaxSalaryOfArrayEmployee();
    }

    @GetMapping
    public String showHelloWorld() {
        return "Hello World";
    }

}
