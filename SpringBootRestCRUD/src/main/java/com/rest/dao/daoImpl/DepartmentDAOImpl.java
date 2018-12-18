package com.rest.dao.daoImpl;

import com.rest.dao.DepartmentDAO;
import com.rest.dao.EmployeeDAO;
import com.rest.entity.Department;
import com.rest.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Department department) {
        entityManager.persist(department);
    }

    @Override
    public Department getDepartmentById(long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public void update(Department department) {
        entityManager.merge(department);
    }

    @Override
    public void delete(Department department) {
        entityManager.remove(department);
    }
}
