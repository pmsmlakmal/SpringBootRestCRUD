package com.rest.controller;

import com.rest.entity.Employee;
import com.rest.service.DepartmentService;
import com.rest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@RestController
@RequestMapping("/api/employee")
@EnableAutoConfiguration
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        try {
            employeeService.saveEmployee(employee);
            logger.info("Added employee {}", employee);
            return new ResponseEntity<String>("Added employee with id: " + employee.getEmployeeId(), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error occurred while creating a new employee", e);
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEmployee(@PathVariable String id) {
        logger.info("Getting employee with id {}", id);

        Employee employee = employeeService.findById(Long.parseLong(id));
        if (employee == null) {
            logger.error("Employee with id {} not found", id);
            return new ResponseEntity<String>("Employee with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        logger.info("Updating Employee with id {}", id);

        Employee currentEmployee = employeeService.findById(Long.parseLong(id));
        if (currentEmployee == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity<String>("Unable to upate. Employee with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }

        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setDepartment(employee.getDepartment());

        employeeService.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        logger.info("Fetching & Deleting Employee with id {}", id);

        Employee employee = employeeService.findById(Long.parseLong(id));
        if (employee == null) {
            logger.error("Unable to delete. Employee with id {} not found.", id);
            return new ResponseEntity<String>("Unable to delete. Employee with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

}
