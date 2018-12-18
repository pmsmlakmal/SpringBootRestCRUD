package com.rest.dao;

import com.rest.entity.Employee;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
public interface EmployeeDAO {
    void create(Employee employee);

    Employee getEmployeeById(long id);

    void update(Employee employee);

    void delete(Employee employee);
}

