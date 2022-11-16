package pro.sky.java.course2.homeworkspring.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homeworkspring.model.Employee;
import pro.sky.java.course2.homeworkspring.record.EmployeeRequest;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees () {
        return employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Введите Имя и Фамилию!");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDept(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }


    public double getSalarySum() {
        return employees.values().stream().mapToDouble(Employee::getSalary).sum();
    }

    public Employee getMinSalaryEmployee() {
        Employee e = null;
        for (Map.Entry<Integer, Employee> entry : this.employees.entrySet()) {
            if (entry.getValue().getSalary() < Double.MAX_VALUE) {
                e = entry.getValue();
            }
        }
        return e;
    }
    public Employee getMaxSalaryEmployee() {
        Employee e = null;
        for (Map.Entry<Integer, Employee> entry : this.employees.entrySet()) {
            if (entry.getValue().getSalary() > Double.MIN_VALUE) {
                e = entry.getValue();
            }
        }
        return e;
    }

    private double getArraySalary() {
        return (employees.values().stream().mapToDouble(Employee::getSalary).sum()) / employees.size();
    }

    public List<Employee> getMaxSalaryOfArrayEmployee() {
        Employee e = null;
        List<Employee> employees = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : this.employees.entrySet()) {
            if (entry.getValue().getSalary() > getArraySalary()) {
                e = entry.getValue();
                employees.add(e);
            }
        }
        return employees;
    }


}
