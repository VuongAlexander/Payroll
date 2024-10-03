package com.example.Payroll.Repository;

import com.example.Payroll.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//used to grab any methods from JPARepository, specifying the domain type as Employee and id as Long
//extending JPARepository makes it possible to do Basic CRUD operations
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //you can implement new methods here if JPA does not fulfill your needs

}
