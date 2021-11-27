package com.example.grocery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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
import java.util.*;
import java.util.Optional;
import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@Controller
@RequestMapping("/cart")
class OrderController {

  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;
  private final UserRepository userRepository;
  private final ItemRepository itemRepository;
  
  private final OrderModelAssembly orderAssembler;
  private final OrderItemModelAssembly orderItemAssembler;
  private final UserModelAssembly userAssembler;

  OrderController(OrderRepository orderRepository, OrderItemRepository orderItemRepository, UserRepository userRepository, ItemRepository itemRepository,
                  OrderModelAssembly orderAssembler, OrderItemModelAssembly orderItemAssembler, UserModelAssembly userAssembler
                  ) {
    this.orderRepository = orderRepository;
    this.orderItemRepository = orderItemRepository;
    this.userRepository = userRepository;
    this.itemRepository = itemRepository;

    this.orderAssembler = orderAssembler;
    this.orderItemAssembler = orderItemAssembler;
    this.userAssembler = userAssembler;
  }

  @GetMapping("/orders")
  public List<Order> all() {

    List<Order> orders = orderRepository.findAll();

  return orders;
  }

  @PostMapping("/orders")
  public String newOrder(@RequestBody Order newOrder) {

    orderRepository.save(newOrder);

    return "Order saved";
  }

  @GetMapping("/orders/{id}")
  public Order one(@PathVariable Long id) {

    Order order = orderRepository.findById(id) //
        .orElseThrow(() -> new OrderNotFoundException(id));

    return order;
  }

  @PutMapping("/orders/{id}")
  public String replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

    Order updatedOrder = orderRepository.findById(id) //
        .map(order -> {
          order.setUserId(newOrder.getUserId());
          order.setTotal(newOrder.getTotal());
          order.setPaymentId(newOrder.getPaymentId());
          order.setPaymentStatus(newOrder.getPaymentStatus());
          order.setDeliveryStatus(newOrder.getDeliveryStatus());
          return orderRepository.save(order);
        }) //
        .orElseGet(() -> {
          newOrder.setId(id);
          return orderRepository.save(newOrder);
        });

        return "Order updated";
  }
  
  @DeleteMapping("/orders/{id}")
  public String deleteOrder(@PathVariable Long id) {

    orderRepository.deleteById(id);

    return "Order deleted";
  }

  // To add item to cart, userId is passed in as variable, item info is passed in as body
  @PostMapping("/ordersItem/{id}")
  public Order_item addToCart(@RequestBody Order_item orderItem, @PathVariable Long id){
    /*
    Order userOrder = new Order();
    userOrder.setUserId(id);
    Example<Order> userOrderEx = Example.of(userOrder);
    Optional<Order> userOrderRes = orderRepository.findOne(userOrderEx);
    if(userOrderRes.isPresent()){
      System.out.println( "User Order found using user ID" ) ;
      userOrder = userOrderRes.get();
    }
    else{
      System.out.println( "User Order not found using user ID" ) ;
      userOrder = new Order();
      userOrder.setUserId(id);
      userOrder.setTotal(0.00);
      orderRepository.save(userOrder);
      System.out.println( "New order is created using user ID" ) ;
    }
    */
    Order userOrder = new Order();
    List<Order> orders = orderRepository.findAll();
    boolean found = false;
    for(Order o: orders){
      if(o.getUserId() == id){
        userOrder = o;
        found = true;
        break;
      }
    }
    if((!found)){
      userOrder = new Order();
      userOrder.setUserId(id);
      userOrder.setTotal(0.00);
      orderRepository.save(userOrder);
      System.out.println( "New order is created using user ID" ) ;
    }
    else{
      System.out.println( "Order is found using user ID" ) ;
    }

    // get item id from database to save in order_item (make sure item exists in db)
    /*
    Item item = new Item();
    item.setName(newItem.getName());
    Example<Item> itemEx = Example.of(item);
    Optional<Item> itemRes = itemRepository.findOne(itemEx);
    if(itemRes.isPresent()){
      System.out.println( "Ordered item found" ) ;
      item = itemRes.get();
    }
    else{
      System.out.println("Ordered item not found in db");
    }
    */
    Item item = new Item();
    List<Item> items = itemRepository.findAll();
    found = false;
    for(Item i: items){
      if(i.getId() == orderItem.getItemId()){
        item = i;
        found = true;
        break;
      }
    }
    if((!found)){
      System.out.println( "Ordered item not found in db" ) ;
      return null;
    }
    else{
      System.out.println( "Ordered item found" ) ;
    }

    // get order_item from database to update the order, or create one if not exists
    /*
    Order_item orderItem = new Order_item();
    orderItem.setOrderId(userOrder.getId());
    Example<Order_item> orderItemEx = Example.of(orderItem);
    Optional<Order_item> orderItemRes = orderItemRepository.findOne(orderItemEx);
    
    if(orderItemRes.isPresent()){
      System.out.println( "Item ordered quantity is added by 1 in user cart" ) ;
      orderItem = orderItemRes.get();
      orderItem.setQuantity(orderItem.getQuantity() + 1);
    }
    else{
      System.out.println( "Item ordered not found in cart" ) ;
      orderItem = new Order_item();
      orderItem.setOrderId(userOrder.getId());
      orderItem.setItemId(item.getId());
      orderItem.setQuantity(1);
      System.out.println( "Item is added to cart using order ID" ) ;
    }
    orderItem.setTotal(orderItem.getQuantity() * item.getPrice());
    orderItemRepository.save(orderItem);
    */
    Order_item newOrderItem = new Order_item();
    List<Order_item> orderItems = orderItemRepository.findAll();
    found = false;
    for(Order_item i: orderItems){
      if(i.getOrderId() == userOrder.getId() && i.getItemId() == orderItem.getItemId()){
        newOrderItem = i;
        found = true;
        break;
      }
    }
    if((!found)){
      System.out.println( "Item ordered not found in cart" ) ;
      newOrderItem = orderItem;
      newOrderItem.setOrderId(userOrder.getId());
      newOrderItem.setItemName(item.getName());
      newOrderItem.setTotal(newOrderItem.getQuantity() * item.getPrice());
      orderItemRepository.save(newOrderItem);
      System.out.println( "Item is added to cart using order ID" ) ;
    }
    else{
      System.out.println( "Item ordered found in cart" ) ;
      newOrderItem.setQuantity(newOrderItem.getQuantity() + orderItem.getQuantity());
      newOrderItem.setTotal(newOrderItem.getQuantity() * item.getPrice());
      orderItemRepository.save(newOrderItem);
      System.out.println( "Item ordered quantity is added by 1 in user cart" ) ;
    }

    /* Update order total
    userOrder.setTotal(userOrder.getTotal() + (orderItem.getQuantity() * item.getPrice()));
    orderRepository.save(userOrder);
    */
    updateOrderTotal(userOrder);

    return newOrderItem;
  }

  // Get all item ordered by a customer
  @GetMapping("/ordersItem/{id}")
  public List<Order_item> cart(@PathVariable Long id){
    Order userOrder = new Order();
    List<Order> orders = orderRepository.findAll();
    boolean found = false;
    for(Order o: orders){
      if(o.getUserId() == id){
        userOrder = o;
        found = true;
        break;
      }
    }

    Order_item newOrderItem = new Order_item();
    List<Order_item> orderItems = orderItemRepository.findAll();
    List<Order_item> ans = new ArrayList<>();
    for(Order_item i: orderItems){
      if(i.getOrderId() == userOrder.getId()){
        ans.add(i);
      }
    }

    return ans;
  }

  @PutMapping("/ordersItem/{id}")
  public String updateOrder(@RequestBody Order_item orderItem, @PathVariable Long id) {
    Order userOrder = new Order();
    List<Order> orders = orderRepository.findAll();
    boolean found = false;
    for(Order o: orders){
      if(o.getUserId() == id){
        userOrder = o;
        found = true;
        break;
      }
    }

    Order_item newOrderItem = new Order_item();
    List<Order_item> orderItems = orderItemRepository.findAll();
    found = false;
    for(Order_item i: orderItems){
      if(i.getOrderId() == userOrder.getId() && i.getItemId() == orderItem.getItemId()){
        newOrderItem = i;
        found = true;
        break;
      }
    }
    if((!found)){
      return "Item ordered not found in cart";
    }
    else{
      System.out.println( "Item ordered found in cart" ) ;
      double newTotal = newOrderItem.getTotal() / newOrderItem.getQuantity() * orderItem.getQuantity();
      newOrderItem.setQuantity(orderItem.getQuantity());
      newOrderItem.setTotal(newTotal);
      if(newOrderItem.getQuantity() <= 0){
        orderItemRepository.deleteById(newOrderItem.getId());
        System.out.println( "Item ordered is deleted from user cart" ) ;
      }
      else{
        orderItemRepository.save(newOrderItem);
        System.out.println( "Item ordered quantity is updated in user cart" ) ;
      }
    }

    // Update order total
    updateOrderTotal(userOrder);

    return "Updated cart and order";
  }

  // Update order total based on total of all ordered items by a customer
  public void updateOrderTotal(Order userOrder){
    List<Order_item> orderItems = orderItemRepository.findAll();
    List<Order_item> ans = new ArrayList<>();
    double total = 0;
    for(Order_item i: orderItems){
      if(i.getOrderId() == userOrder.getId()){
        total += i.getTotal();
      }
    }

    userOrder.setTotal(total);
    orderRepository.save(userOrder);
  }
}