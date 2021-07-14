package com.example.SpringBootFullStackThymeleaf.controller;

import com.example.SpringBootFullStackThymeleaf.model.Employee;
import com.example.SpringBootFullStackThymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        // create model attribute to bind from data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return  "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";

    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable ( value = "id") long id, Model model){

            // get employees from the service

        Employee employee = employeeService.getEmployeeById(id);

            // set employee as a model attribute

            model.addAttribute("employee", employee);
            return  "update_employee";
    }
}
