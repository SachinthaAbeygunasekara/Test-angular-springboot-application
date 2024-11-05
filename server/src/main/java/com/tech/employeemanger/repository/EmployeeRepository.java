package com.tech.employeemanger.repository;

import com.tech.employeemanger.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    void deleteEmployeeById(Integer id);

    Optional<Employee> findEmployeeById(Integer id);
}
