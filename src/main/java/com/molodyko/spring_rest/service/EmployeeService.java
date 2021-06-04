package com.molodyko.spring_rest.service;

import com.molodyko.spring_rest.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int id);
}
