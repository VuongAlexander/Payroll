package com.example.Payroll.Database;

import com.example.Payroll.Enum.Status;
import com.example.Payroll.Model.Employee;
import com.example.Payroll.Model.Order;
import com.example.Payroll.Repository.EmployeeRepository;
import com.example.Payroll.Repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final OrderRepository orderRepository;

    public LoadDatabase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository){
        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));

            employeeRepository.findAll().forEach(employee ->
                    log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone 12", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order ->
                    log.info("Preloaded " + order));

        };
    }
}
