package com.example;

import com.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    void showEmployeesSalaryReport(List<Employee> employees);

    void showWorkGroupBasedEmployeeCountReport(List<Employee> employees);

    void showWorkGroupBasedTotalSalaryReport(List<Employee> employees);

    void loadEmployees(List<Employee> employees);
}
