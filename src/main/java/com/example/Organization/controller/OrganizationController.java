package com.example.Organization.controller;

import com.example.Organization.entity.*;
import com.example.Organization.filter.Filter;
import com.example.Organization.model.BatchDelete;
import com.example.Organization.model.SearchResponseRepresentation;
import com.example.Organization.service.OrganizationServiceInterface;
import com.example.Organization.service.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrganizationController {

  @Autowired private OrganizationServiceInterface organizationServiceInterface;

  @PostMapping("/addEmp")
  public ResponseEntity<Employee> addEmp(
      @RequestBody Employee employee){
    ResponseBody<Employee> emp1 =
            organizationServiceInterface.addEmp(employee);
    return new ResponseEntity<>(
            emp1.getPayload(), emp1.getStatus());
  }


  @PostMapping("/addMember")
  public ResponseEntity<Member> addMember(
      @RequestBody Member member) {
    ResponseBody<Member> meber1 =
        organizationServiceInterface.addMember(member);
    return new ResponseEntity<>(
            meber1.getPayload(),meber1.getStatus());
  }



  @PostMapping("/addTeam")
  public ResponseEntity<Team> addTeam(
      @RequestBody Team team) {
    ResponseBody<Team> team1 =
        organizationServiceInterface.addTeam(team);
    return new ResponseEntity<>(
            team1.getPayload(), team1.getStatus());
  }

  @PostMapping("/deleteEmployee")
  public ResponseEntity<Integer> softdeleteEmp(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> emp =
        organizationServiceInterface.softdeleteEmp(batchDeleteList);
    return new ResponseEntity<>(
            emp.getPayload(), emp.getStatus());
  }

  @PostMapping("/deleteMember")
  public ResponseEntity<Integer> softdeleteMember(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> member =
        organizationServiceInterface.softdeleteMember(batchDeleteList);
    return new ResponseEntity<>(
            member.getPayload(), member.getStatus());
  }

  @PostMapping("/deleteTeam")
  public ResponseEntity<Integer> softdeleteTeam(
      @RequestBody List<BatchDelete> batchDeleteList){
    ResponseBody<Integer> team =
        organizationServiceInterface.softdeleteTeam(batchDeleteList);
    return new ResponseEntity<>(
            team.getPayload(), team.getStatus());
  }


  @PutMapping("/empUpdate/{id}")
  public ResponseEntity<Employee> updateEmp(
      @RequestBody Employee employee,
      @PathVariable(value = "id") String id) {
    ResponseBody<Employee> emp =
        organizationServiceInterface.updateEmp(employee, id);
    return new ResponseEntity<>(
            emp.getPayload(), emp.getStatus());
  }

  @PutMapping("/memberUpdate/{id}")
  public ResponseEntity<Member> updateMember(
      @RequestBody Member member,
      @PathVariable(value = "id") String id) {
    ResponseBody<Member> member1 =
        organizationServiceInterface.updateMember(member, id);
    return new ResponseEntity<>(
            member1.getPayload(), member1.getStatus());
  }


  @PutMapping("/teamUpdate/{id}")
  public ResponseEntity<Team> updateTeam(
      @RequestBody Team team,
      @PathVariable(value = "id") String id) {
    ResponseBody<Team> team1 =
        organizationServiceInterface.updateTeam(team, id);
    return new ResponseEntity<>(
            team1.getPayload(), team1.getStatus());
  }

  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee> getEmployee(@PathVariable String id) {
    ResponseBody<Employee> employee =
        organizationServiceInterface.getByEmpId(id);
    return new ResponseEntity<>(
            employee.getPayload(), employee.getStatus());
  }

  @GetMapping("/member/{id}")
  public ResponseEntity<Member> getMember(
      @PathVariable String id) {
    return new ResponseEntity<>(
        organizationServiceInterface.getByMemberId(id).getPayload(),
        organizationServiceInterface.getByMemberId(id).getStatus());
  }


  @GetMapping("/team/{id}")
  public ResponseEntity<Team> getTeam(
      @PathVariable String id){
    return new ResponseEntity<>(
        organizationServiceInterface.getByTeamId(id).getPayload(),
        organizationServiceInterface.getByTeamId(id).getStatus());
  }


@PostMapping("/Employees")
public ResponseEntity<SearchResponseRepresentation<Employee>> searchEmployees(
        @RequestBody(required = false) Filter filter,
        @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
        @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
        @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

  ResponseBody<SearchResponseRepresentation<Employee>> Searchedemp =
          organizationServiceInterface.searchEmployee(pageNo, pageSize, sort, filter);

  return new ResponseEntity<>(Searchedemp.getPayload(), Searchedemp.getStatus());
}

  @PostMapping("/Members")
  public ResponseEntity<SearchResponseRepresentation<Member>> searchMember(
      @RequestBody(required = false) Filter filter,
      @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
      @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
      @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

    ResponseBody<SearchResponseRepresentation<Member>> member =
        organizationServiceInterface.searchMember(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(member.getPayload(), member.getStatus());
  }


  @PostMapping("/Teams")
  public ResponseEntity<SearchResponseRepresentation<Team>> searchTeams(
      @RequestBody(required = false) Filter filter,
      @RequestParam(name = "pageNo", defaultValue = "1", required = false) int pageNo,
      @RequestParam(name = "pageSize", defaultValue = "100", required = false) int pageSize,
      @RequestParam(name = "sort", defaultValue = "createdDttm", required = false) String sort) {

    ResponseBody<SearchResponseRepresentation<Team>> team =
        organizationServiceInterface.searchTeam(pageNo, pageSize, sort, filter);

    return new ResponseEntity<>(team.getPayload(), team.getStatus());
  }

}
