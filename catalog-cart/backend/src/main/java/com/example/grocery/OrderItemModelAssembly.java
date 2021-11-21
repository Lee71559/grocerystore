package com.example.grocery;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class OrderItemModelAssembly implements RepresentationModelAssembler<Order_item, EntityModel<Order_item>> {

  @Override
  public EntityModel<Order_item> toModel(Order_item orderItem) {

    return EntityModel.of(orderItem, //
        linkTo(methodOn(OrderController.class).one(orderItem.getId())).withSelfRel(),
        linkTo(methodOn(OrderController.class).all()).withRel("orders_item"));
  }
}