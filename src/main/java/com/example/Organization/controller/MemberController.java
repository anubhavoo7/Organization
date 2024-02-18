//package com.example.Organization.controller;
//
//
//import com.example.Organization.entity.Members;
//import com.example.Organization.service.MembersService;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class MemberController {
//
//    @Autowired
//    private MembersService service;
//
//    @PostMapping("/addMember")
//    public Members addEmp(@RequestBody Members emp) {
//        return service.saveMember(emp);
//    }
//
//    @PostMapping("/addAllMembers")
//    public List<Members> addEmployeess(@RequestBody List<Members> member) {
//        return service.InitializeMembers(member);
//    }
//
//    @GetMapping("/GetAllMembers")
//    public List<Members> findAllEmployeess() {
//        return service.getAllMembers();
//    }
//
//    @GetMapping("/MemberById/{id}")
//    public Members findMemberById(@PathVariable int id) {
//        return service.getMemberById(id);
//    }
//
//    @PutMapping("/updateMember")
//    public Members updateMember(@RequestBody Members mem) {
//        return service.updateMember(mem);
//    }
//
//    @DeleteMapping("/deleteMember/{id}")
//    public String deleteEmploy(@PathVariable int id) {
//        return service.deleteMember( id);
//    }
//
//}
//
