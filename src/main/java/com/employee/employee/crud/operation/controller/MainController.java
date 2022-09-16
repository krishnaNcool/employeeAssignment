package com.employee.employee.crud.operation.controller;

import com.employee.employee.crud.operation.entity.Employee;
import com.employee.employee.crud.operation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MainController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employeeAdd")
    public Employee AddEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employeeDelete/{id}")
    public Optional<Employee> deleteEmployee(@PathVariable int id){
        Optional<Employee> employee= employeeRepository.findById(id);
        if(employee.isPresent()){
            employeeRepository.deleteById(id);
            return employee;
        }
        return null;
    }

    @PutMapping("/employeeUpdate/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeN){
    Employee employee=employeeRepository.findById(id)
            .orElseThrow(()-> new NoSuchElementException("not found"));
            employee.setFullName(employeeN.getFullName());
           employee.setLocation(employeeN.getLocation());
           employee.setDateOfBirth(employeeN.getDateOfBirth());
           Employee updatedEmployee= employeeRepository.save(employee);
           return ResponseEntity.ok(updatedEmployee);
       }


    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeRepository.findById(id);
    }


}
