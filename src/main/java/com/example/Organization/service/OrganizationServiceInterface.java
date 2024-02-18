package com.example.Organization.service;

import com.example.Organization.entity.*;
import com.example.Organization.filter.Filter;
import com.example.Organization.model.*;
import com.example.Organization.model.SearchResponseRepresentation;
import com.example.Organization.exception.RequestConflictError;
import java.util.List;

public interface OrganizationServiceInterface {

  ResponseBody<Employee> addEmp(
      Employee employee) throws RequestConflictError;


  ResponseBody<Member> addMember(
          Member member) throws RequestConflictError;


  ResponseBody<Team> addTeam(
          Team team);
  ResponseBody<Integer> softdeleteEmp(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteMember(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Integer> softdeleteTeam(
      List<BatchDelete> batchDeleteList);

  ResponseBody<Employee> updateEmp(
          Employee employee1, String movieId);

  ResponseBody<Member> updateMember(
          Member member, String actorId);
  ResponseBody<Team> updateTeam(
          Team team,String genreId);
  ResponseBody<Employee> getByEmpId(String id);

  ResponseBody<Member> getByMemberId(String id);


  ResponseBody<Team> getByTeamId(String id);


  ResponseBody<SearchResponseRepresentation<Employee>> searchEmployee(
          int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Member>> searchMember(
      int pageNo, int pageSize, String sort, Filter filter);

  ResponseBody<SearchResponseRepresentation<Team>> searchTeam(
      int pageNo, int pageSize, String sort, Filter filter);

}
