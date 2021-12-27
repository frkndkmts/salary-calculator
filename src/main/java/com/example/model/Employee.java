package com.example.model;

public abstract class Employee {

  private int empId;
  private String fullname;

  public Employee() {
    this.empId = 0;
    this.fullname = "";
  }

  public Employee(int empId, String fullname) {
    this.empId = empId;
    this.fullname = fullname;
  }

  public abstract double calculatePay();

  public int getEmpId() {
    return empId;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
}
