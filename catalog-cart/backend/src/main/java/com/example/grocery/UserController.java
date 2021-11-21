package com.example.grocery;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

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

@RestController
class UserController {

  private final UserRepository repository;
  private final UserModelAssembly assembler;

  UserController(UserRepository repository, UserModelAssembly assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/users")
  public List<User> all() {

    List<User> users = repository.findAll();

    return users;
  }

  @GetMapping("/users/{id}")
  public User one(@PathVariable Long id) {

    User user = repository.findById(id) //
        .orElseThrow(() -> new ItemNotFoundException(id));

    return user;
  }
}