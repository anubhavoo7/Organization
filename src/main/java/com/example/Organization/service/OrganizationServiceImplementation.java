package com.example.Organization.service;

import com.example.Organization.dao.OrganizationDao;
import com.example.Organization.entity.*;
import com.example.Organization.exception.ApplicationErrorCode;
import com.example.Organization.exception.RequestConflictError;
import com.example.Organization.exception.ResourceNotFoundException;
import com.example.Organization.filter.Filter;
import com.example.Organization.model.BatchDelete;
import com.example.Organization.model.SearchResponseRepresentation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Setter
@Getter
public class OrganizationServiceImplementation implements OrganizationServiceInterface {
  @Autowired private OrganizationDao dao;

  @Override
  public ResponseBody<Employee> addEmp(
      Employee employee) throws RequestConflictError {

    if (Boolean.TRUE.equals((dao.isExists(employee.getEmpName())))) {
      log.error("Account Name Already Exist");
      throw new RequestConflictError(
          "Already Exist.", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    } else {
      employee.setEmpId("employee-" + UUID.randomUUID());
      employee.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(
          HttpStatus.OK,
              dao.saveEmp(employee));
    }
  }

  @Override
  public ResponseBody<Member> addMember(
          Member member) throws RequestConflictError {
    try {
      member.setMemberId("member-" + UUID.randomUUID());
      member.setMemberName(member.getMemberName());
      member.setCreatedDttm(ZonedDateTime.now());


      return new ResponseBody<>(HttpStatus.OK, dao.saveMember(member));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }
  @Override
  public ResponseBody<Team> addTeam(
          Team team) {
    try {

      team.setTeamId("team-" + UUID.randomUUID());
//      team.setCreatedDttm(ZonedDateTime.now());
      return new ResponseBody<>(
              HttpStatus.OK,dao.saveTeam(team));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Recheck request!", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.RESET_CONTENT);
    }
  }
//

//  @Override
//  public ResponseBody<Employee> softdeleteOrganization(String accountId) {
//    try {
//
//      Employee movie = dao.getByMovieId(movieID);
//      if (Objects.nonNull(movie)) {
//        movie.setIsActive(true);
//      }
//      MovieView movieView = dao.softdeleteOrganization(accountId);
//      return new ResponseBody<>(HttpStatus.OK, movieView);
//    } catch (Exception e) {
//      throw new ResourceNotFoundException(
//          "Failed to Delete Organization",
//          ApplicationErrorCode.RESOURCE_NOT_FOUND,
//          HttpStatus.NOT_FOUND);
//    }
//  }

  @Override
  public ResponseBody<Integer> softdeleteEmp(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteEmp(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      e.printStackTrace();
      throw new ResourceNotFoundException(
          "Failed to Delete Account",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Integer> softdeleteMember(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete contactIds1 : batchDeleteList) {
        list.add(contactIds1.getId());
      }
      int count = dao.softdeleteMember(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new ResourceNotFoundException(
          "Failed to Delete Member",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }



  @Override
  public ResponseBody<Integer> softdeleteTeam(
      List<BatchDelete> batchDeleteList) {
    try {
      List<String> list = new ArrayList<>();
      for (BatchDelete list1 : batchDeleteList) {
        list.add(list1.getId());
      }
      int count = dao.softdeleteTeam(list);
      if (count > 0) {
        return new ResponseBody<>(HttpStatus.OK, count);
      } else {
        return new ResponseBody<>(HttpStatus.NOT_IMPLEMENTED, count);
      }

    } catch (Exception e) {
      throw new ResourceNotFoundException(
          "Failed to Delete Install",
          ApplicationErrorCode.RESOURCE_NOT_FOUND,
          HttpStatus.NOT_FOUND);
    }
  }



  @Override
  public ResponseBody<Employee> updateEmp(
          Employee employee1, String movieId) {
    try {
      Employee employee = dao.getByEmpId(movieId);
      employee.setEmpId(employee1.getEmpId());
      employee.setEmpName(employee1.getEmpName());
      employee.setEmpAge(employee1.getEmpAge());
      employee.setEmpJoiningDate(employee1.getEmpJoiningDate());
      employee.setIsActive(employee1.getIsActive());
      employee.setDeleted(employee1.getDeleted());
      return new ResponseBody<>(
              HttpStatus.OK, (dao.saveEmp(employee)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public ResponseBody<Member> updateMember(
          Member member, String actorId) {
    try {
      Member member1 = dao.getByMemberId(actorId);
      member1.setMemberId(member.getMemberId());
      member.setMemberName(member.getMemberName());
      member1.setMemberAge(member.getMemberAge());
      member1.setManagerId(member.getManagerId());
      member1.setMemberJoiningDate(member.getMemberJoiningDate());
      member1.setMemberSalary(member.getMemberSalary());
      member1.setMemberTotalHoursWorked(member.getMemberTotalHoursWorked());
      member1.setMemberTotalWorkload(member.getMemberTotalWorkload());
      member1.setIsActive(member.getIsActive());
      return new ResponseBody<>(
              HttpStatus.OK,(dao.saveMember(member1)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }


  @Override
  public ResponseBody<Team> updateTeam(
          Team team, String genreId) {
    try {
      Team team1 = dao.getByTeamId(genreId);
      team1.setTeamId(team.getTeamId());
      team1.setTeamName(team.getTeamName());
      team1.setManagerId(team.getManagerId());

      return new ResponseBody<>(
              HttpStatus.OK, (dao.saveTeam(team1)));
    } catch (Exception e) {
      throw new RequestConflictError(
          "Failed to Update", ApplicationErrorCode.RESOURCE_CONFLICT, HttpStatus.BAD_REQUEST);
    }
  }



  @Override
  public ResponseBody<Employee> getByEmpId(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByEmpId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Member> getByMemberId(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByMemberId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<Team> getByTeamId(String id) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,(dao.getByTeamId(id)));
    } catch (Exception e) {
      log.info("Not Found!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }


  @Override
public ResponseBody<SearchResponseRepresentation<Employee>> searchEmployee(
        int pageNo, int pageSize, String sort, Filter filter) {
  try {
    return new ResponseBody<>(
            HttpStatus.OK,
            new SearchResponseRepresentation<>(
                    dao.getEmpCount(pageNo, pageSize, filter),
                    dao.getAllEmp(filter, sort)));

  } catch (Exception e) {
    e.printStackTrace();
    log.info("Unable to locate Attribute with the the given name!");
    throw new ResourceNotFoundException(
            "Not found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
  }
}

  @Override
  public ResponseBody<SearchResponseRepresentation<Member>> searchMember(
      int pageNo, int pageSize, String sort, Filter filter) {
    try {
      return new ResponseBody<>(
              HttpStatus.OK,
          new SearchResponseRepresentation<>(
              dao.getMemberCount(pageNo, pageSize, filter),
              dao.getAllMember(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Unable to locate Attribute  with the the given name!");
      throw new ResourceNotFoundException(
          "Not Found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseBody<SearchResponseRepresentation<Team>> searchTeam(
      int pageNo, int pageSize, String sort, Filter filter) {

    try {
      return new ResponseBody<>(
              HttpStatus.OK,
          new SearchResponseRepresentation<>(
              dao.getTeamCount(pageNo, pageSize, filter),
              dao.getAllTeam(filter, sort)));

    } catch (Exception e) {
      e.printStackTrace();
      log.info("Unable to locate Attribute  with the the given name!");
      throw new ResourceNotFoundException(
          "Not found!", ApplicationErrorCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
  }


}
