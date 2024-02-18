package com.example.Organization.model;

import com.example.Organization.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
  private Employee employee;
  private Member member;
  private Team team;
}
