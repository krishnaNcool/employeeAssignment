package com.employee.employee.crud.operation.service;

import com.employee.employee.crud.operation.entity.Employee;
import com.employee.employee.crud.operation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> sortByField(String fieldName){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, fieldName));

    }
}
