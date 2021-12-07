package com.example.springcustomers;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64.Encoder;
//import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;


import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.springcustomers.*;




@Slf4j
@RestController
public class CustomerController {


    
    @Autowired
    CustomerService customerService;

    @Autowired
    ProcessService processService;

    @GetMapping("/ping")
    public ResponseEntity<String> ping () {
        return ResponseEntity.ok("login backend is alive !");
    }


    /* Create a new Customer */
    @PostMapping("/customer")
    Long newCustomer(@RequestBody Customers customers) {

        //Customers nCustomer = new Customers(name,password);
        
        log.info("Costomer: " + customers);

        customerService.save(customers);

        Customers newcustomer = customerService.findCustomerById(customerService.count());

        log.info("Added Customer: " + newcustomer);
        
        Process p = new Process(newcustomer.getId());
        processService.save(p);
        return newcustomer.getId();//returns the new customer's id
    }


    /*Get details of a Customer*/
    @GetMapping("/customer")
    Customers getOne(@RequestBody Customers customers, HttpServletResponse response) {

        Customers target = customerService.findByName(customers.getName());
        log.info("target: " + target);
        if(target == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer Not Found!");
        return target;
    }

    /*Authenticate a Customer*/
    @PostMapping("customer/authenticate")
    Long activate(@RequestBody Customers customers, HttpServletResponse response){

        Customers target = customerService.findByName(customers.getName());

        if(target == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer Not Found!" );
        }


        if(target.getPassword().equals(customers.getPassword())){
            
            Process p = new Process(target.getId());
            processService.save(p);
            
            return target.getId();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Password Not Valid!" );
        }
        
    }


    /*Logout a Customer*/
    @PostMapping("customer/logout")
    String logout(@RequestBody Customers customer, HttpServletResponse response){

        // Customers name = repository.findByName(customer.getName());
        // if(name.isAuthenticated()){
        //     name.setAuthenticated(false);
        //     repository.save(name);//added this code to save change to db
        // } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer needs to login first!" );

        return "Logout Successful";
    }
}