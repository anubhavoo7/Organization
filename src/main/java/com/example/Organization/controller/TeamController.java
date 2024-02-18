//package com.example.Organization.controller;
//
//
//import com.example.Organization.entity.Members;
//import com.example.Organization.entity.Teams;
//import com.example.Organization.service.TeamsService;
//import org.springframework.beans.factory.annotation.*;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class TeamController {
//
//    @Autowired
//    private TeamsService service1;
//
//    @PostMapping("/addTeams")
//    public Teams addTeam(@RequestBody Teams t) {
//        return service1.saveTeam(t);
//    }
//
//    @PostMapping("/InitialLize")
//    public List<Teams> InitializeTeam(List<Teams> teams) {
//        return service1.InitializeTeam(teams);
//    }
//    @GetMapping("/getAllTeam")
//    public List<Teams> getAllTeams() {
//        return service1.getAllTeams();
//    }
//    @GetMapping("/getManager")
//    public String  getManagerByTeamId(@RequestBody int teamId) {
//        return service1.getManagerByTeamId(teamId);
//    }
//    @GetMapping("/getTeamMember")
//    public List<Members> getAllMembersByTeamId(@RequestBody int teamId){
//
//        return service1.getAllMembersByTeamId(teamId);
//    }
//}