package com.example.Organization.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "team")
public class Team {

    @Id
    @Column(name="team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String teamId;

    @Column(name="team_name")
    private String teamName;



    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee managerId;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Member> members;



}
