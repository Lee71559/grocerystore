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

import lombok.Data;
import lombok.extern.slf4j.Slf4j;		// for log.info



@Slf4j
@Controller
@RequestMapping("/home")
public class PortalController {

	@Autowired
	CustomersRepository customersRepository ;

	@Autowired
	OrdersRepository ordersRepository ;

	@GetMapping
	public String getAction () {

		// preload db:
		preloadDatabase();

		return "home";
	}

	@GetMapping("/orders")
	public String getOrders (@ModelAttribute("command") PortalCommand command, Model model) {

		model.addAttribute("command", command);

		return "orders";
	}

	@GetMapping("/customers")
	public String getCustomers (@ModelAttribute("command") PortalCommand command, Model model) {

		model.addAttribute("command", command);

		return "customers";
	}


	@PostMapping("/customers")
	public String customersPostAction ( @Valid @ModelAttribute("command") PortalCommand command,  
                            @RequestParam(value="action", required=true) String action,
                            Errors errors, Model model, HttpServletRequest request ) {

		log.info( "Action: " + action ) ;
		log.info("Command", command.getCustomerid());

		MessageList msgList = new MessageList();

		if (command.getCustomerid().equals("")){
			
			/* RETURN ALL CUSTOMERS*/
			
			List<Customers> customerlist = new ArrayList<Customers>();
			customerlist = findAllCustomers() ;
			for (Customers c:customerlist){
				msgList.add(c.getId() + " " + c.getName());
			}

			model.addAttribute ("messages", msgList.getMessages());

			return "/customers" ;


		}else if(Long.valueOf(command.getCustomerid()) > (customersRepository.count())) {
			
			/* RETURN NOT FOUND */

			msgList.add ("Customer Not Found");

			model.addAttribute ("messages", msgList.getMessages());

			return "/customers" ;

		} else {

			/* RETURN CUSTOMER BY ID*/

			Customers c = new Customers();
			
			c = findCustomerById(command.getCustomerid()) ;
			
			msgList.add(c.getId() + "  " + c.getName());
			

			model.addAttribute ("messages", msgList.getMessages());
			return "/customers" ;
		}

	}



	@PostMapping("/orders")
	public String ordersPostAction ( @Valid @ModelAttribute("command") PortalCommand command,  
                            @RequestParam(value="action", required=true) String action,
                            Errors errors, Model model, HttpServletRequest request ) {


		MessageList msgList = new MessageList();


		if (command.getOrderid().equals("")){
			
			/* RETURN ALL ORDERS*/
			
			List<Orders> orderlist = new ArrayList<Orders>();
			orderlist = findAllOrders() ;
			for (Orders o:orderlist){
				msgList.add(o.getId() + " " + o.getItems() + " " + 
							o.getAmount() + " " + o.getPaymentStatus() + " " + 
							o.getPaymentMethod() + " " + o.getDeliveryStatus() );
			}

			model.addAttribute ("messages", msgList.getMessages());

			return "/orders" ;


		}else if(Long.valueOf(command.getOrderid()) > (ordersRepository.count())) {
			
			/* RETURN NOT FOUND */

			msgList.add ("Order Not Found");

			model.addAttribute ("messages", msgList.getMessages());

			return "/orders" ;

		} else {

			/* RETURN ORDER BY ID*/

			Orders o = new Orders();
			
			o = findOrderById(command.getOrderid()) ;
			
			msgList.add(o.getId() + " " + o.getItems() + " " + 
							o.getAmount() + " " + o.getPaymentStatus() + " " + 
							o.getPaymentMethod() + " " + o.getDeliveryStatus() );
			

			model.addAttribute ("messages", msgList.getMessages());
			return "/orders" ;
		}
		

	}




	private void preloadDatabase () {

		/* customers: */
		Customers customer1 = new Customers();
		customer1.setName("James");

		Customers customer2 = new Customers();
		customer2.setName("Anni");

		Customers customer3 = new Customers();
		customer3.setName("Josh");

		customersRepository.save(customer1) ;
		customersRepository.save(customer2) ;
		customersRepository.save(customer3) ;

		/* orders: */
		ordersRepository.save(new Orders("Broccoli", "15.00", "PENDING", "CREDITCARD", "READY TO DELIVERY") );
		ordersRepository.save(new Orders("Bacon", "9.00", "PENDING", "CREDITCARD", "DELIVERYING") );
		ordersRepository.save(new Orders("Milk", "22.00", "AUTHORIZED", "CREDITCARD", "READY TO DELIVERY") );
		ordersRepository.save(new Orders("Soda", "11.00", "PENDING", "CREDITCARD", "READY TO DELIVERY") );
		ordersRepository.save(new Orders("Soap", "26.00", "AUTHORIZED", "CREDITCARD", "READY TO DELIVERY") );


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

	private List<Customers> findAllCustomers() {
		List <Customers> c = new ArrayList<>();
		customersRepository.findAll().forEach(c::add);
		return c;
	}

	
	private Customers findCustomerById(String customerId) {

		Integer id = Integer.valueOf(customerId);

		Optional <Customers> oc = customersRepository.findById(id) ;

		Customers c = oc.get();
		
		return c ;
		
	}

	private List<Orders> findAllOrders() {
		List <Orders> o = new ArrayList<>();
		ordersRepository.findAll().forEach(o::add);
		return o;
	}

	
	private Orders findOrderById(String orderId) {

		Integer id = Integer.valueOf(orderId);

		Optional <Orders> oo = ordersRepository.findById(id) ;

		Orders o = oo.get();
		
		return o ;
		
	}
	



}























