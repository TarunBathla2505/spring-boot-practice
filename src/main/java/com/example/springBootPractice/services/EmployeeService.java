package com.example.springBootPractice.services;

import com.example.springBootPractice.entity.Department;
import com.example.springBootPractice.entity.Employee;
import com.example.springBootPractice.exception.EmployeeNameNotFoundException;
import com.example.springBootPractice.exception.EmployeeNotFoundException;
import com.example.springBootPractice.repositories.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeRepo empRepo;

    @Autowired
    DepartmentService departmentService;

    public String addEmployee(Employee e){
         empRepo.save(e);
         return "Employee Added Successfully....";
    }
    public List<Employee> getEmployee(){
        List<Employee> employees = empRepo.findAll();
        return employees;
    }

    public Employee getEmployee(int id){
        return empRepo.findById(id).get();
    }

    public Employee getEmployeeByName(String name){
        if(!empRepo.existsByEmpname(name)){
            throw new EmployeeNameNotFoundException("employee not found with name : "+name);
        }
        return empRepo.findByEmpname(name);
    }




    public List<Employee> findByDept(String dname){
        return this.empRepo.findByDept(this.departmentService.findByName(dname));
    }
    public String updateEmployee(Employee e){
        if(! empRepo.existsById(e.getId())){
            throw new EmployeeNotFoundException("no employee exists with id "+e.getId());
        }
        Employee curr = empRepo.findById(e.getId()).get();
        curr.setDept(e.getDept());
        curr.setEmpname(e.getEmpname());
        curr.setSalary(e.getSalary());
        empRepo.save(curr);
        return "employee updated";
    }
    public String updateEmployeePartially(Employee e){
        if(!empRepo.existsById(e.getId())){
            return "employee not found";
        }
        Employee curr = empRepo.findById(e.getId()).get();
        if(e.getDept()!=null) curr.setDept(e.getDept());
        if(e.getEmpname()!=null) curr.setEmpname(e.getEmpname());
        if(e.getSalary()!=0)curr.setSalary(e.getSalary());

        empRepo.save(curr);
        return "employee updated";
    }
}
