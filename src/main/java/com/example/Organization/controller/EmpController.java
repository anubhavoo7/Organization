//package com.example.Organization.controller;
//
//
//import com.example.Organization.entity.Employees;
//import com.example.Organization.service.EmployeesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class EmpController {
//
//    @Autowired
//    private EmployeesService service;
//
//    @PostMapping("/addEmployees")
//    public Employees addEmp(@RequestBody Employees emp) {
//
//        return service.saveEmp(emp);
//    }
//
//    @PostMapping("/addEmployeess")
//    public List<Employees> addEmployeess(@RequestBody List<Employees> Employeess) {
//        return service.saveEmps(Employeess);
//    }
//
//    @GetMapping("/Employeess")
//    public List<Employees> findAllEmployeess() {
//        return service.getEmps();
//    }
//
//    @GetMapping("/EmployeesById/{id}")
//    public Employees findEmployeesById(@PathVariable int id) {
//        return service.getEmpById(id);
//    }
//
//    @PutMapping("/update")
//    public Employees updateEmployees(@RequestBody Employees Employees) {
//        return service.updateEmp(Employees);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployees(@PathVariable int id) {
//        return service.deleteEmp(id);
//    }
//    @PostMapping("/calculateSalary/{employeeId}")
//    public double calculateSalary(@PathVariable int employeeId, @RequestParam int leavesTaken) {
//        return service.calculateSalary(employeeId, leavesTaken);
//    }
//}