package com.example.Organization.service;


import com.example.Organization.Repositories.EmpRepository;
import com.example.Organization.Repositories.MemberRepository;
import com.example.Organization.Repositories.TeamRepository;
import com.example.Organization.entity.Members;
import com.example.Organization.entity.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {
    @Autowired
    private TeamRepository repository;
    @Autowired
    private EmpRepository repository1;
    @Autowired
    private MemberRepository repository2;

    public Teams saveTeam(Teams emp) {
        return repository.save(emp);
    }

    public List<Teams> InitializeTeam(List<Teams> emps) {
        return repository.saveAll(emps);
    }

    public List<Teams> getAllTeams() {
        return repository.findAll();
    }


    public Teams getTeamById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String  getManagerByTeamId(int teamId) {
        Teams team=repository.findById(teamId).orElse(null);
        int ManagerID=team.getManager_Id();
        Members m=repository2.findById(ManagerID).orElse(null);
        String name =m.getName();
        return  name;
    }



    public String deleteEmp(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public List<Members> getAllMembersByTeamId(int teamId) {
        Teams team = repository.findById(teamId).orElse(null);
        if (team != null) {
            return repository2.findByTeamId(teamId);
        } else {
            throw new RuntimeException("Team not found with ID: " + teamId);
        }
    }



}