package com.example.SpringBootFullStackThymeleaf.controller;

import com.example.SpringBootFullStackThymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of Employees like a method handler for home page (index.html) to display the list of employees
    @GetMapping
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
}
