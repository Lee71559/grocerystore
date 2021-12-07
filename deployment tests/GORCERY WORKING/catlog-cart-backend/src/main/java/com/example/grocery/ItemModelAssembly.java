package com.example.grocery;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class ItemModelAssembly implements RepresentationModelAssembler<Item, EntityModel<Item>> {

  @Override
  public EntityModel<Item> toModel(Item item) {

    return EntityModel.of(item, //
        linkTo(methodOn(ItemController.class).one(item.getId())).withSelfRel(),
        linkTo(methodOn(ItemController.class).all()).withRel("items"));
  }
}