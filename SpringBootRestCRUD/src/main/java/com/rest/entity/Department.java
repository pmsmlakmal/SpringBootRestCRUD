package com.rest.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@Entity
@Table(name="Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;
    private String name;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="department")
    private Collection<Employee> employees=new ArrayList<Employee>();

    public Department(){}

    public Department(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + this.departmentId + ", name=" + this.name + "]";
    }

}
