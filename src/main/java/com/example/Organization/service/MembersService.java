//package com.example.Organization.service;
//
//import com.example.Organization.Repositories.MemberRepository;
//import com.example.Organization.entity.Members;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MembersService {
//    @Autowired
//    private MemberRepository repository;
//
//    public Members saveMember(Members emp) {
//        return repository.save(emp);
//    }
//
//    public List<Members> InitializeMembers(List<Members> emps) {
//        return repository.saveAll(emps);
//    }
//
//    public List<Members> getAllMembers() {
//        return repository.findAll();
//    }
//
//    public Members getMemberById(int id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    public String deleteMember(int id) {
//        repository.deleteById(id);
//        return "product removed !! " + id;
//    }
//
//    public Members updateMember(Members emp) {
//        Members member = repository.findById(emp.getId()).orElse(null);
//        member.setName(emp.getName());
//        member.setAge(emp.getAge());
//        member.setRole(emp.getRole());
//        member.setSalary(emp.getSalary());
//        member.setJoiningDate(emp.getJoiningDate());
//        member.setTeamId(emp.getTeamId());
//        member.setTotalHoursWorked(emp.getTotalHoursWorked());
//        member.setTotalWorkload(emp.getTotalWorkload());
//
//        return repository.save(member);
//    }
//}
