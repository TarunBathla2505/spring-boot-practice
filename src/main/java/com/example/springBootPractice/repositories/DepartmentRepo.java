package com.example.springBootPractice.repositories;

import com.example.springBootPractice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    public Department findByName(String name);
}
