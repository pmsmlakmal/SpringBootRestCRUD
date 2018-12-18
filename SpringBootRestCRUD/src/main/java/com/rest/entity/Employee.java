package com.rest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by Supun Madhusanka on 12/18/2018.
 */
@Entity
@Table(name="Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String firstName;
    private String lastName;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="departmentId", scope=Department.class) // to resolve cyclic dependencies in an object graph during serialization/deserialization by Jackson.
    @ManyToOne(cascade= CascadeType.MERGE)
    private Department department;

    public Employee(){}

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + this.employeeId + ", firstname=" + this.firstName + ", lastname=" + this.lastName + ", department=" + this.department + "]";
    }

}

