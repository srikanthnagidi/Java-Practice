package com.example.springboot.aopexample.controller;

import com.example.springboot.aopexample.model.Employee;
import com.example.springboot.aopexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid  @RequestBody Employee employee){
        Employee employee1 = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
