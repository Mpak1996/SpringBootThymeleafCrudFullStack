package com.example.SpringBootFullStackThymeleaf.repository;

import com.example.SpringBootFullStackThymeleaf.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
