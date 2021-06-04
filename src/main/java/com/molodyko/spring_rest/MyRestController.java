package com.molodyko.spring_rest;

import com.molodyko.spring_rest.Entity.Employee;
import com.molodyko.spring_rest.exception_handler.EmployeeIncorrectData;
import com.molodyko.spring_rest.exception_handler.NoSuchEmployee;
import com.molodyko.spring_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null){
            throw new NoSuchEmployee("employee with this id "+id + " is not exist");
        }
        return employee;
    }


}
