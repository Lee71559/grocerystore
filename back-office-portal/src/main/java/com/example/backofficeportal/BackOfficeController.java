package com.example.backofficeportal;

import java.util.*;  // for log.info

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
public class BackOfficeController {


	@Autowired
	private OrderRepository orderRepository ;
	private CustomerRepository customerRepository ;

	@GetMapping
	public String getAction (@ModelAttribute ("command") BackOfficeCommand command, Model model) {

		
        log.info( "Command: " + command ) ;


        orderRepository.save(new Order("Soap", "1", "2.30", "SHIPPING"));
        orderRepository.save(new Order("Sause Pan", "1", "14.99", "PENDING"));
        orderRepository.save(new Order("Bathroom Cleaner", "2", "5.98", "DELIVERED"));
        orderRepository.save(new Order("Disinfecting Wipes", "1", "6.99", "SHIPPING"));

        customerRepository.save(new Customer("James Smith"));
        customerRepository.save(new Customer("Maria Garcia"));
        customerRepository.save(new Customer("Maria Rodriguez"));
        customerRepository.save(new Customer("James Johnson"));
        customerRepository.save(new Customer("Jane Wilson"));


		return "home" ;
	}

	@PostMapping()
    public String postAction(@Valid @ModelAttribute("command") BackOfficeCommand command,  
        @RequestParam(value="action", required=true) String action,
        Errors errors, Model model, HttpServletRequest request) { 

		log.info( "Action: " + action ) ;
		log.info( "Command: " + command ) ;

		if (action.equals("Search Orders")){

			model.addAttribute("command.orderid", "THAT's ALL ORDERS");
			return "home";
		}

		if (action.equals("Search customer")){
			model.addAttribute("command.customername", "THAT's ALL NAMES");
			return "home";
		}

        return "home";

	}


}