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

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return "success";
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee){
        if (employee.getId()==0){
            throw new NoSuchEmployee("Request body has not employee.id for update");
        }
        employeeService.saveEmployee(employee);
        return "success";
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employeeForDelete = employeeService.getEmployee(id);
        if (employeeForDelete==null){
            throw new NoSuchEmployee("The employee with id "+id+" not found ");
        }
        employeeService.deleteEmployee(employeeForDelete);

        return "success";
    }


}
