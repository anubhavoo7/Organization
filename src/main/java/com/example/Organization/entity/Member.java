package com.example.Organization.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name="member")
public class Member {

    @Id
    @Column(name="member_id")
    private String memberId;

    @Column(name="member_name")
    private String memberName;
    @Column(name="reports_to_id")
    private String managerId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name="manager_name")
    private String managerName;

    @Column(name="member_age")
    private int memberAge;

    @Column(name="member_joining_date")
    private Date memberJoiningDate;

    @Column(name="member_salary")
    private double memberSalary;


    @ManyToOne
    @JoinColumn(name = "employee_reports_to_id")
    private Employee employeeReportsTo;

    @Column(name="total_hours_worked")
    private double memberTotalHoursWorked;

    @Column(name = "total_worked")
    private double memberTotalWorkload;

    @Column(name="created_dttm")
    private ZonedDateTime createdDttm;


    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private Boolean deleted = false;



}
