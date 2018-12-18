package com.rest.service.serviceImpl;

import com.rest.dao.DepartmentDAO;
import com.rest.entity.Department;
import com.rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public Department findById(long id) {
        return departmentDAO.getDepartmentById(id);
    }

}
