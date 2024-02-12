package com.example.springBootPractice.controller;


import com.example.springBootPractice.entity.Employee;
import com.example.springBootPractice.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;


    @PostMapping()
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee e){
        empService.addEmployee(e);
        return new ResponseEntity<>("Employee Added", HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = empService.getEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String name){
        Employee employee = empService.getEmployeeByName(name);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        Employee employee = empService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee e){
        return new ResponseEntity<>(empService.updateEmployee(e), HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<String> updateEmployeePartially(@RequestBody Employee e){
        return new ResponseEntity<>(empService.updateEmployeePartially(e),HttpStatus.OK);
    }

    @GetMapping("/dept-name/{name}")
    public List<Employee> findByDeptName(@PathVariable String name){
        return this.empService.findByDept(name);
    }


}
