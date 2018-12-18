package com.rest.service;

import com.rest.entity.Department;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
public interface DepartmentService {

    void saveDepartment(Department department);

    Department findById(long id);

}
