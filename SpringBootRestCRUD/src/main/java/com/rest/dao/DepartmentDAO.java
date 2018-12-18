package com.rest.dao;

import com.rest.entity.Department;
import com.rest.entity.Employee;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
public interface DepartmentDAO {
    void create(Department department);

    Department getDepartmentById(long id);

    void update(Department department);

    void delete(Department department);
}

