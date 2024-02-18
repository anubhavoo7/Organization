package com.example.Organization.dao;

import com.example.Organization.entity.*;
import com.example.Organization.filter.Filter;
import com.example.Organization.model.Pageable;
import java.util.List;

public interface OrganizationDao {

  Employee saveEmp(Employee employee);

  Boolean isExists(String movieTitleToCheck);

  Member saveMember(Member member);


  Team saveTeam(Team team);


  Pageable getEmpCount(int pageNo, int pageSize, Filter filter);

  Pageable getMemberCount(int pageNo, int pageSize, Filter filter);

  Pageable getTeamCount(int pageNo, int pageSize, Filter filter);

  List<Employee> getAllEmp(Filter filter, String sort);


  List<Member> getAllMember(Filter filter, String sort);


  List<Team> getAllTeam(Filter filter, String sort);

  Employee getByEmpId(String id);


  Member getByMemberId(String id);

  Team getByTeamId(String id);

  int softdeleteEmp(List<String> idList);

  int softdeleteMember(List<String> batchDeleteList);

  int softdeleteTeam(List<String> batchDeleteList);

}
