package com.example.grocery;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@Controller
@RequestMapping("/catalog")
class ItemController {

  private final ItemRepository repository;
  private final ItemModelAssembly assembler;

  ItemController(ItemRepository repository, ItemModelAssembly assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/items")
  public List<Item> all() {

    List<Item> items = repository.findAll();

    return items;
  }

  @PostMapping("/items")
  public String newItem(@RequestBody Item item) {

    repository.save(item);

    return "Item saved";
  }

  @GetMapping("/items/{id}")
  public Item one(@PathVariable Long id) {

    Item item = repository.findById(id) //
        .orElseThrow(() -> new ItemNotFoundException(id));

    return item;
  }

  @PutMapping("/items/{id}")
  public String replaceItem(@RequestBody Item newItem, @PathVariable Long id) {

    Item updatedItem = repository.findById(id) //
        .map(item -> {
          item.setName(newItem.getName());
          item.setPrice(newItem.getPrice());
          item.setDescription(newItem.getDescription());
          item.setInventory(newItem.getInventory());
          return repository.save(item);
        }) //
        .orElseGet(() -> {
          newItem.setId(id);
          return repository.save(newItem);
        });

        return "Item updated";
  }
  
  @DeleteMapping("/items/{id}")
  public String deleteItem(@PathVariable Long id) {

    repository.deleteById(id);

    return "Item deleted";
  }
}