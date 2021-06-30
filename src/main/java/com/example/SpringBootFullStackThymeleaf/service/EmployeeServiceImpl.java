package com.example.SpringBootFullStackThymeleaf.service;

import com.example.SpringBootFullStackThymeleaf.model.Employee;
import com.example.SpringBootFullStackThymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
            return  employeeRepository.findAll();
    }
}
