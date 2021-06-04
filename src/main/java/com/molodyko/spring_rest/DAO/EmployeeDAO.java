package com.molodyko.spring_rest.DAO;


import com.molodyko.spring_rest.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    Employee getEmployee(int id);
}
