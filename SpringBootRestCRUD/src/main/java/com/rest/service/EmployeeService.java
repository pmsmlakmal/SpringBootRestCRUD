package com.rest.service;

import com.rest.entity.Employee;

import java.util.List;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee findById(long id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}