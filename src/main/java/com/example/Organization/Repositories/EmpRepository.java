package com.example.Organization.Repositories;
import com.example.Organization.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employees, Integer> {

}
