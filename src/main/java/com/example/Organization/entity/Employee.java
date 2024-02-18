package com.example.Organization.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Employee")
public class Employee {
  @Id
  @Column(name = "emp_id")
  private String empId;

  @Column(name = "emp_name")
  private String empName;


  @Column(name = "emp_age")
  private int empAge;

  @Column(name = "emp_joining_date")
  private Date empJoiningDate;

  @Column(name="salary")
  private double salary;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(name = "is_active")
  private Boolean isActive = true;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(name = "is_deleted")
  private Boolean deleted = false;

  @Column(name="created_dttm")
  private ZonedDateTime createdDttm;
}
