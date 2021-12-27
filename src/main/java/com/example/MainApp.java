package com.example;

import com.example.model.Employee;
import com.example.model.FullTime;
import com.example.model.Intern;
import com.example.model.PartTime;
import com.example.model.Trainee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

  public static void main(String[] args) {

    EmployeeService employeeService = new EmployeeServiceImpl();
    List<Employee> employees = new ArrayList<>();
    employeeService.loadEmployees(employees);

    Scanner scan = new Scanner(System.in);
    UI choice = new UI();

    while (true) {
      choice.option();
      int op = scan.nextInt();
      if (op == 1) {
        while (true) {
          choice.subEmployeeOption();
          int subOp = scan.nextInt();
          if (subOp == 1) {
            System.out.println(
                "(Full-Time)Enter new Employee's Name,Id, Salary Constant, Work Hour respectively: ");
            scan.nextLine();
            String name = scan.nextLine();
            int id = scan.nextInt();
            double salaryConstant = scan.nextDouble();
            double workHour = scan.nextDouble();

            Employee fullTime = new FullTime(id, name, salaryConstant, workHour);
            employees.add(fullTime);
            break;
          } else if (subOp == 2) {
            System.out.println(
                "(Part-Time)Enter new Employee's Name,Id respectively: ");
            scan.nextLine();
            String n = scan.nextLine();
            int i = scan.nextInt();

            Employee partTime = new PartTime();
            partTime.setFullname(n);
            partTime.setEmpId(i);
            employees.add(partTime);

            break;
          } else if (subOp == 3) {
            System.out.println(
                "(Trainee)Enter new Employee's Name,Id respectively: ");
            scan.nextLine();
            String name = scan.nextLine();
            int empId = scan.nextInt();

            Employee traineeEmployee = new Trainee();
            traineeEmployee.setEmpId(empId);
            traineeEmployee.setFullname(name);

            employees.add(traineeEmployee);
            break;
          } else if (subOp == 4) {
            System.out.println(
                "(Intern)Enter new Employee's Name,Id respectively: ");
            scan.nextLine();
            String name = scan.nextLine();
            int empId = scan.nextInt();

            Employee intern = new Intern();
            intern.setEmpId(empId);
            intern.setFullname(name);

            employees.add(intern);
            break;
          } else {
            System.out.println("Wrong key pressed! Please try again.");
          }
        }
      } else if (op == 2) {
        employeeService.showEmployeesSalaryReport(employees);
      } else if (op == 3) {
        System.out.println("Work Group Based Employee Count Report: ");
        employeeService.showWorkGroupBasedEmployeeCountReport(employees);
      } else if (op == 4) {
        System.out.println("Work Group Based Total Salary Report");
        employeeService.showWorkGroupBasedTotalSalaryReport(employees);
      } else if (op == 0) {
        break;
      } else {
        System.out.println("Wrong key pressed! Please try again.");
      }
    }
  }


}
