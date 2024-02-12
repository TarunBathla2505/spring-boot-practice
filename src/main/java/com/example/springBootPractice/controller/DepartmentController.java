package com.example.springBootPractice.controller;

import com.example.springBootPractice.entity.Department;
import com.example.springBootPractice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/all")
    public List<Department> getALlDepartment(){
        return this.departmentService.getAllDepartments();
    }

    @PostMapping("/add")
    public String addDepartment(@RequestBody  Department d){
        return this.departmentService.addDepartment(d);
    }
}
