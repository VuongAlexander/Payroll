package com.example.Payroll.DTO;

import com.example.Payroll.Controller.EmployeeController;
import com.example.Payroll.Model.Employee;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    //Link Creation
    @Override
    public EntityModel<Employee> toModel(Employee employee) {

        //unconditional links to single item resource and aggregate root
        return EntityModel.of(employee,
                WebMvcLinkBuilder.linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees"));
    }
}
