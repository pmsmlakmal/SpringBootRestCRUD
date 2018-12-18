package com.rest.service.serviceImpl;

import com.rest.dao.EmployeeDAO;
import com.rest.entity.Employee;
import com.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.update(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.delete(employee);
    }
}
