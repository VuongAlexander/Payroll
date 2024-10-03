package com.example.Payroll.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

//@Entity is used to make object ready for storage in JPA based data store
@Entity
public class Employee {

    //the attributes Employees will contain
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String role;

    Employee() {}

    //custom constructor when needed to create a new instance but do not yet have an id
    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

    //Getters and Setters

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getRole(){
        return this.role;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) &&
                Objects.equals(this.name, employee.name) &&
                Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
