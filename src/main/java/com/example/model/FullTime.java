package com.example.model;

public class FullTime extends Employee {

  private double salaryConstant;
  private double workHour;

  public FullTime(int empId, String fullname, double salaryConstant, double workHour) {
    super(empId, fullname);
    this.salaryConstant = salaryConstant;
    this.workHour = workHour;
  }

  @Override
  public double calculatePay() {
    return salaryConstant * workHour;
  }

  public double getSalaryConstant() {
    return salaryConstant;
  }

  public void setSalaryConstant(double salaryConstant) {
    this.salaryConstant = salaryConstant;
  }

  public double getWorkHour() {
    return workHour;
  }

  public void setWorkHour(double workHour) {
    this.workHour = workHour;
  }

}
