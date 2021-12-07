package com.example.springcustomers;

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

// import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//import org.springframework.hateoas.IanaLinkRelations;
//import org.springframework.hateoas.CollectionModel;
// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.Links;
// import org.springframework.hateoas.MediaTypes;
// import org.springframework.hateoas.mediatype.problem.Problem;

import java.lang.Long;
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

import com.example.springcustomers.*;
import com.example.springcustomers.OrderService;


@Slf4j
@RestController
@Controller
@RequestMapping()
class OrderController {

  @Autowired
  OrderService orderServices ;

  @Autowired
  ProcessService processService;

  private ItemsInventory inventory = new ItemsInventory();

  @GetMapping("/catalog/items")
  public List<Item> all() {

    List<Item> items = inventory.getItemsInventory();

    return items;
  }


  // @GetMapping("/cart/orders")
  // public List<Order> all() {

  //   List<Order> orders = orderRepository.findAll();

  // return orders;
  // }

  // @PostMapping("/cart/orders")
  // public String newOrder(@RequestBody Order newOrder) {

  //   orderRepository.save(newOrder);

  //   return "Order saved";
  // }

  // @GetMapping("/cart/orders/{id}")
  // public Order one(@PathVariable Long id) {

  //   Order order = orderRepository.findById(id) //
  //       .orElseThrow(() -> new OrderNotFoundException(id));

  //   return order;
  // }

  // @PutMapping("/cart/orders/{id}")
  // public String replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {

  //   Order updatedOrder = orderRepository.findById(id) //
  //       .map(order -> {
  //         order.setUserId(newOrder.getUserId());
  //         order.setTotal(newOrder.getTotal());
  //         order.setPaymentId(newOrder.getPaymentId());
  //         order.setPaymentStatus(newOrder.getPaymentStatus());
  //         order.setDeliveryStatus(newOrder.getDeliveryStatus());
  //         return orderRepository.save(order);
  //       }) //
  //       .orElseGet(() -> {
  //         newOrder.setId(id);
  //         return orderRepository.save(newOrder);
  //       });

  //       return "Order updated";
  // }
  
  // @DeleteMapping("/cart/orders/{id}")
  // public String deleteOrder(@PathVariable Long id) {

  //   orderRepository.deleteById(id);

  //   return "Order deleted";
  // }

  // To add item to cart, userId is passed in as variable, item info is passed in as body
  @PostMapping("/cart/ordersItem/{id}")
  public String addToCart(@RequestBody catalogCommand command, @PathVariable Long id){


    int itemid = command.getItemId();
    int  quantity = command.getQuantity();

    List<Item> inv = inventory.getItemsInventory();

    Item item = inv.get(itemid);

    String orderDetails = item.getName() + " x "+ "1";

    Long curProcessId = processService.count();

    Process p = processService.findById(curProcessId);

    Orders newOrder = new Orders(p.getCustomerid(), orderDetails, item.getPrice(), "ORDER CREATED" );
 
    orderServices.save(newOrder);

    Long orderid = Long.valueOf(orderServices.count());

    processService.updateProcess(orderid, curProcessId);
    
    return "Order has created with order id: " + String.valueOf(orderid);
  }

  // // Get all item ordered by a customer
  // @GetMapping("/cart/ordersItem/{id}")
  // public List<Order_item> cart(@PathVariable Long id){
  //   Order userOrder = new Order();
  //   List<Order> orders = orderRepository.findAll();
  //   boolean found = false;
  //   for(Order o: orders){
  //     if(o.getUserId() == id){
  //       userOrder = o;
  //       found = true;
  //       break;
  //     }
  //   }

  //   Order_item newOrderItem = new Order_item();
  //   List<Order_item> orderItems = orderItemRepository.findAll();
  //   List<Order_item> ans = new ArrayList<>();
  //   for(Order_item i: orderItems){
  //     if(i.getOrderId() == userOrder.getId()){
  //       ans.add(i);
  //     }
  //   }

  //   return ans;
  // }

  // @PutMapping("/cart/ordersItem/{id}")
  // public String updateOrder(@RequestBody Order_item orderItem, @PathVariable Long id) {
  //   Order userOrder = new Order();
  //   List<Order> orders = orderRepository.findAll();
  //   boolean found = false;
  //   for(Order o: orders){
  //     if(o.getUserId() == id){
  //       userOrder = o;
  //       found = true;
  //       break;
  //     }
  //   }

  //   Order_item newOrderItem = new Order_item();
  //   List<Order_item> orderItems = orderItemRepository.findAll();
  //   found = false;
  //   for(Order_item i: orderItems){
  //     if(i.getOrderId() == userOrder.getId() && i.getItemId() == orderItem.getItemId()){
  //       newOrderItem = i;
  //       found = true;
  //       break;
  //     }
  //   }
  //   if((!found)){
  //     return "Item ordered not found in cart";
  //   }
  //   else{
  //     System.out.println( "Item ordered found in cart" ) ;
  //     double newTotal = newOrderItem.getTotal() / newOrderItem.getQuantity() * orderItem.getQuantity();
  //     newOrderItem.setQuantity(orderItem.getQuantity());
  //     newOrderItem.setTotal(newTotal);
  //     if(newOrderItem.getQuantity() <= 0){
  //       orderItemRepository.deleteById(newOrderItem.getId());
  //       System.out.println( "Item ordered is deleted from user cart" ) ;
  //     }
  //     else{
  //       orderItemRepository.save(newOrderItem);
  //       System.out.println( "Item ordered quantity is updated in user cart" ) ;
  //     }
  //   }

  //   // Update order total
  //   updateOrderTotal(userOrder);

  //   return "Updated cart and order";
  // }

  // // Update order total based on total of all ordered items by a customer
  // public void updateOrderTotal(Order userOrder){
  //   List<Order_item> orderItems = orderItemRepository.findAll();
  //   List<Order_item> ans = new ArrayList<>();
  //   double total = 0;
  //   for(Order_item i: orderItems){
  //     if(i.getOrderId() == userOrder.getId()){
  //       total += i.getTotal();
  //     }
  //   }

  //   userOrder.setTotal(total);
  //   orderRepository.save(userOrder);
  // }
}