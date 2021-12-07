package com.example.backofficeportal;

import java.util.*;  
import java.util.Optional;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;		// for log.info



@Slf4j
@Controller
@RequestMapping("/")
public class PortalController {

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderService	orderService;

	@GetMapping
	public String getAction (Model model) {

		return "hello";
	}

	@GetMapping("/ping")
	public ResponseEntity<String> ping(){
		return ResponseEntity.ok("Back Office Portal is Alive!");
	}


	@GetMapping("/home/customers")
	public String getCustomers (@ModelAttribute("command") PortalCommand command, Model model) {

		model.addAttribute("command", command);

		return "customers";
	}

	@GetMapping("/home/orders")
	public String getOrders (@ModelAttribute("command") PortalCommand command, Model model) {

		model.addAttribute("command", command);

		return "orders";
	}



	@PostMapping("/home/customers")
	public String viewAllCustomers( @Valid @ModelAttribute("command") PortalCommand command,  
                             @RequestParam(value="action", required=true) String action,
                             Errors errors, Model model, HttpServletRequest request ){

		log.info( "Action: " + action ) ;
		log.info("Command: ", command.getCustomerid());

		if (action.equals("View Customers")){
			
			log.info( "Action: " + action ) ;
			log.info("Command: ", command.getCustomerid());


			 if (command.getCustomerid().equals("")) {
			
				List<Customers> customerlist = customerService.listAllCustomers();

				MessageList msgList = new MessageList();
				
				for (Customers c:customerlist){
					msgList.add(c.getId() + " " + c.getName());
				} 

				model.addAttribute ("messages", msgList.getMessages());
				
				return "customers" ;
			
			} else if (Long.valueOf(command.getCustomerid()) > (customerService.count())) {
				
				MessageList msgList = new MessageList();
				msgList.add("Customer ID not found");
				model.addAttribute ("messages", msgList.getMessages());
				
				return "customers" ;
			
			} else {

				Customers customer = customerService.findCustomerById(Long.parseLong(command.getCustomerid()));
			
				MessageList msgList = new MessageList();
				msgList.add(customer.getId() + " " + customer.getName());

				model.addAttribute ("messages", msgList.getMessages());
				model.addAttribute ("command.customerid", customer.getId());
				
				return "customers" ;
			
			}
		
		}else if (action.equals("Update Customer")){


			log.info("update customer command: "+ command.getCustomerid() );
			log.info("update customer command: "+ command.getCustomername() );
			log.info("update customer command: "+ command.getCustomerpassword() );

			customerService.updateCustomer(command.getCustomername(),command.getCustomerpassword(), Long.parseLong(command.getCustomerid()));

			Customers customer = customerService.findCustomerById(Long.parseLong(command.getCustomerid()));
		
			MessageList msgList = new MessageList();
			msgList.add( "Customer ID: " + customer.getId() + " | New Name: " + customer.getName() + " | New Password: " + customer.getPassword());

			model.addAttribute ("messages", msgList.getMessages());

			return "customers" ;
			
		} 

		return "customers" ;

		
	}



	@PostMapping("/home/orders")
	public String ordersPostAction ( @Valid @ModelAttribute("command") PortalCommand command,  
                            @RequestParam(value="action", required=true) String action,
                            Errors errors, Model model, HttpServletRequest request ) {
		
		log.info( "Action: " + action ) ;
		log.info("Command: ", command.getCustomerid());


		if (action.equals("View Orders")){

			if (command.getOrderid().equals("")) {
			
				/* RETURN ALL ORDERS*/
				
				List<Orders> orders = orderService.listAllOrders();
			
				MessageList msgList = new MessageList();

				for (Orders o:orders){
					msgList.add("Order ID:" + o.getId() + " Customer ID:" + o.getCustomerid() + 
								" Order Details:" + o.getDetails() +  
								" Amount:" + o.getAmount() + " Status:" + o.getStatus());
				}

				model.addAttribute ("messages", msgList.getMessages());

				return "orders" ;


			} else if(Long.valueOf(command.getOrderid()) > (orderService.count())) {
				
				/* RETURN NOT FOUND */

				MessageList msgList = new MessageList();

				msgList.add ("Order Not Found");

				model.addAttribute ("messages", msgList.getMessages());

				return "orders" ;

			} else {

				/* RETURN ORDER BY ID*/

				Orders o = orderService.findOrderById(Long.parseLong(command.getOrderid()));
				
				MessageList msgList = new MessageList();

				msgList.add("Order ID:" + o.getId() + " Customer ID:" + o.getCustomerid() + 
								" Order Details:" + o.getDetails() +  
								" Amount:" + o.getAmount() + " Status:" + o.getStatus());

				model.addAttribute ("messages", msgList.getMessages());

				model.addAttribute ("command.customerid", o.getCustomerid());
				model.addAttribute ("command.orderid", o.getId());
				model.addAttribute ("command.amount", o.getAmount());
				model.addAttribute ("command.details", o.getDetails());
				model.addAttribute ("command.status", o.getStatus());
				
				return "orders" ;
			
			}

		} else if (action.equals("Update Order")){

			log.info("update order command: " + command.getOrderid());
			log.info("update order command: " + command.getAmount());
			log.info("update order command: " + command.getDetails());
			log.info("update order command: " + command.getStatus());

			Orders updateOrder = orderService.findOrderById(Long.parseLong(command.getOrderid()));

			if (!command.getAmount().equals("")){
				updateOrder.setAmount(Double.parseDouble(command.getAmount()));
			} else if (!command.getDetails().equals("")){
				updateOrder.setDetails(command.getDetails());
			} else if (!command.getStatus().equals("")){
				updateOrder.setStatus(command.getStatus());
			} 


			orderService.updateOrder(updateOrder.getDetails(),  updateOrder.getAmount(), updateOrder.getStatus(), updateOrder.getId());


			Orders o = orderService.findOrderById(Long.parseLong(command.getOrderid()));

			MessageList msgList = new MessageList();

			msgList.add("Order ID:" + o.getId() + " Customer ID:" + o.getCustomerid() + 
								" Order Details:" + o.getDetails() +  
								" Amount:" + o.getAmount() + " Status:" + o.getStatus());

			model.addAttribute ("messages", msgList.getMessages());

			return "orders";

		}

		return "orders";	

	}


	@Data
	class Message{
		private String msg ;
		public Message (String m) {msg = m;}
	}

	class MessageList {
		private ArrayList<Message> messages = new ArrayList<Message>();
        public void add (String msg) {messages.add(new Message(msg)) ; }
        public ArrayList<Message> getMessages() { return messages ; }
        public void print() {
            for (Message m : messages) {
                System.out.println(m.msg) ;
            }
        }
	}


}























