package com.tech.employeemanger.service;

import com.tech.employeemanger.entity.Employee;
import com.tech.employeemanger.exception.UserNotFoundException;
import com.tech.employeemanger.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Integer id){
        return employeeRepository.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
    }

    public void deleteEmployee(Integer id){
         employeeRepository.deleteEmployeeById(id);
    }
}
