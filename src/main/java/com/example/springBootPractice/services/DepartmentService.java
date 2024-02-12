package com.example.springBootPractice.services;

import com.example.springBootPractice.entity.Department;
import com.example.springBootPractice.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    public String addDepartment(Department d){
        departmentRepo.save(d);
        return "department added successfully";
    }
    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }
    public Department findByName(String name){
        return departmentRepo.findByName(name);
    }
}
