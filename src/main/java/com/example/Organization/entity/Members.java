//package com.example.Organization.entity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name="members")
//public class Members {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    private double salary;
//    private int age;
//    private Date joiningDate;
//    private int teamId;
//    private int reportsTo;
//    private int totalHoursWorked;
//    private int totalWorkload;
//    private String Role;
//
//    public Members(int id, String name, double salary, int age, Date joiningDate, int teamId, int reportsTo,
//                   int totalHoursWorked, int totalWorkload, String role) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//        this.age = age;
//        this.joiningDate = joiningDate;
//        this.teamId = teamId;
//        this.reportsTo = reportsTo;
//        this.totalHoursWorked = totalHoursWorked;
//        this.totalWorkload = totalWorkload;
//        Role = role;
//    }
//    public Members() {
//
//    }
//    public int getId() {
//        return id;
//    }
//    public void setId(int id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public double getSalary() {
//        return salary;
//    }
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }
//    public Date getJoiningDate() {
//        return joiningDate;
//    }
//    public void setJoiningDate(Date joiningDate) {
//        this.joiningDate = joiningDate;
//    }
//    public int getTeamId() {
//        return teamId;
//    }
//    public void setTeamId(int teamId) {
//        this.teamId = teamId;
//    }
//    public int getReportsTo() {
//        return reportsTo;
//    }
//    public void setReportsTo(int reportsTo) {
//        this.reportsTo = reportsTo;
//    }
//    public int getTotalHoursWorked() {
//        return totalHoursWorked;
//    }
//    public void setTotalHoursWorked(int totalHoursWorked) {
//        this.totalHoursWorked = totalHoursWorked;
//    }
//    public int getTotalWorkload() {
//        return totalWorkload;
//    }
//    public void setTotalWorkload(int totalWorkload) {
//        this.totalWorkload = totalWorkload;
//    }
//    public String getRole() {
//        return Role;
//    }
//    public void setRole(String role) {
//        Role = role;
//    }
//
//}