package com.example.grocery;

class ItemNotFoundException extends RuntimeException {

  ItemNotFoundException(Long id) {
    super("Could not find item " + id);
  }
}