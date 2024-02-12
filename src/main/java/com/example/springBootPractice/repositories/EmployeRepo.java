package com.example.springBootPractice.repositories;

import com.example.springBootPractice.entity.Department;
import com.example.springBootPractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeRepo extends JpaRepository<Employee,Integer> {

    public Employee findByEmpname(String empname);
    public boolean existsByEmpname(String empname);

    public List<Employee> findByDept(Department dept);

}
