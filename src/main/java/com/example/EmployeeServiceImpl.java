package com.example;

import com.example.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

  @Override
  public void showEmployeesSalaryReport(List<Employee> employees) {
    System.out.println("Work Group Type-Employee Id-Fullname-Salary");
    employees.forEach(employee -> {
      String workGroupType = employee.getClass().getSimpleName();
      String message = String.format("%s-%s-%s-%s", workGroupType, employee.getEmpId(),
          employee.getFullname(),
          employee.calculatePay());

      System.out.println(message);
    });
  }


  @Override
  public void showWorkGroupBasedEmployeeCountReport(List<Employee> employees) {



    /*
    Map<String, Long> map = new HashMap<>();
    for (Employee employee : employees){
      String empGroupName = employee.getClass().getSimpleName();
      if ( map.containsKey(empGroupName)){
        Long count  = map.get(empGroupName);
        map.replace(empGroupName, count++);
      }else {
        map.put(empGroupName, 1L);
      }
    }*/


    final Map<String, Long> employeeCountByEmpGroup = employees.stream()
        .collect(
            Collectors.groupingBy(employee -> employee.getClass().getSimpleName(),
                Collectors.counting()));

    System.out.println("Group Name-Count");
    employeeCountByEmpGroup.forEach((groupName, count) -> {
      final String format = String.format("%s-%s", groupName, count);
      System.out.println(format);
    });

  }

  @Override
  public void showWorkGroupBasedTotalSalaryReport(List<Employee> employees) {

    final Map<String, Double> salariesByEmpGroup = employees.stream().collect(
        Collectors.groupingBy(employee -> employee.getClass().getSimpleName(),
            Collectors.summingDouble(Employee::calculatePay)
        )
    );

    System.out.println("Group Name-Total Salary");
    salariesByEmpGroup.forEach((groupName, totalSalary) -> {
      final String format = String.format("%s-%s", groupName, totalSalary);
      System.out.println(format);
    });


  }



  @Override
  public void loadEmployees(List<Employee> employees) {

    for (int i = 0; i < 30; i++) {
      int empId = Util.faker().random().nextInt(2000, 3000);
      String name = Util.faker().name().name();
      double salaryConstant = Util.faker().random().nextDouble();
      double workHour = Util.faker().random().nextInt(200, 250);

      FullTime fullTime = new FullTime(empId, name, salaryConstant, workHour);
      employees.add(fullTime);
    }

    for (int i = 0; i < 3; i++) {
      int empId = Util.faker().random().nextInt(100, 200);
      String name = Util.faker().name().name();

      PartTime partTime = new PartTime();
      partTime.setFullname(name);
      partTime.setEmpId(empId);
      employees.add(partTime);
    }

    for (int i = 0; i < 4; i++) {
      int empId = Util.faker().random().nextInt(300, 500);
      String name = Util.faker().name().name();

      Trainee trainee = new Trainee();
      trainee.setFullname(name);
      trainee.setEmpId(empId);
      employees.add(trainee);
    }

    for (int i = 0; i < 5; i++) {
      int empId = Util.faker().random().nextInt(6000, 7000);
      String name = Util.faker().name().name();

      Intern intern = new Intern();
      intern.setFullname(name);
      intern.setEmpId(empId);
      employees.add(intern);
    }


  }
}


