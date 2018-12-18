package com.rest.controller;

import com.rest.entity.Department;
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

import java.util.Map;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@RestController
@RequestMapping("/api/department")
@EnableAutoConfiguration
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/")
    public ResponseEntity<String> createDepartment(@RequestBody Map department_json) {
        String name = (String)department_json.get("name");
        logger.info("Creating department with name " + name);
        try {
            Department department = new Department(name);
            departmentService.saveDepartment(department);
            return new ResponseEntity<String>("Added department with id: " + department.getDepartmentId(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while creating a new department", e);
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDepartment(@PathVariable String id) {
        logger.info("Getting department with id {}", id);
        Department department = departmentService.findById(Long.parseLong(id));
        if (department == null) {
            logger.error("Department with id {} not found", id);
            return new ResponseEntity<String>("Department with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

}
