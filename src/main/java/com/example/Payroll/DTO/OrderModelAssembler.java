package com.example.Payroll.DTO;

import com.example.Payroll.Controller.OrderController;
import com.example.Payroll.Enum.Status;
import com.example.Payroll.Model.Order;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order){

        //unconditional links to single item resource and aggregate root
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).getOrdersById(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).getAllOrders()).withRel("orders"));

        if (order.getStatus() == Status.IN_PROGRESS){
            orderModel.add(linkTo(methodOn(OrderController.class).cancelOrder(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderController.class).completeOrder(order.getId())).withRel("complete"));

        }
        return orderModel;
    }
}
