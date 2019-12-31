package com.example.springboot.aopexample.service;

import com.example.springboot.aopexample.model.Employee;
import com.example.springboot.aopexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            employeeRepository.delete(optionalEmployee.get());
        }else{
            throw new RuntimeException("Employee not found");
        }
    }
}
