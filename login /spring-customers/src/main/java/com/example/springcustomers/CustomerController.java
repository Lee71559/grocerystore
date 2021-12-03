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

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins ="http://localhost:3000")//added to fix CORS Error
@RestController
public class CustomerController {
    private  CustomerRepository repository;


    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    private static String key = "kwRg54x2Go9iEdl49jFENRM12Mp711QI" ;

    private static String hmac_sha256(String secretKey, String data) {
      try {
        Mac mac = Mac.getInstance("HmacSHA256") ;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256") ;
        mac.init(secretKeySpec) ;
        byte[] digest = mac.doFinal(data.getBytes()) ;
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String hashString = encoder.encodeToString(digest);
        return hashString ;
      } catch (InvalidKeyException e1) {
        throw new RuntimeException("Invalid key exception while converting to HMAC SHA256") ;
      } catch (NoSuchAlgorithmException e2) {
        throw new RuntimeException("Java Exception Initializing HMAC Crypto Algorithm") ;
      }
    }   


    /* Create a new Customer */
    @PostMapping("/customers")
    Long newCustomer(@RequestBody Customer customer) {
        Customer newcustomer = customer;

        Customer name = repository.findByName(newcustomer.getName());
        if(name!=null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer exists already!");
        }

        String text = newcustomer.getName() + "/" + newcustomer.getPassword();
        String hashString = hmac_sha256(key, text);
        System.out.println(hashString);
        newcustomer.setPassword(hashString);
        repository.save( newcustomer );
        return newcustomer.getId();//returns the new customer's id
    }

    /*Get list of Customers*/
    @GetMapping("/customers")
        List<Customer> all() {
            return repository.findAll();
        }


    /*Get details of a Customer*/
    @GetMapping("/customer/{name}")
    Customer getOne(@PathVariable String name, HttpServletResponse response) {
        Customer customer = repository.findByName(name);
        if(customer == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer Not Found!");
        return customer;
    }

    /*Authenticate a Customer*/
    @PostMapping("customer/authenticate/{name}/{password}")
    Customer activate(@PathVariable String name, @PathVariable String password, HttpServletResponse response){
        Customer customer = repository.findByName(name);
        if(customer == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer Not Found!" );

        if(customer.isAuthenticated())
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer is Already logged in!" );            
            
        String text = customer.getName() + "/" + password;
        String hashString = hmac_sha256(key, text);
            
        if(customer.getPassword().equals(hashString) ){
            customer.setAuthenticated(true);
            repository.save(customer);
        } else { 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Password Not Valid!" );
        }
        return customer;
    }

    /*Logout a Customer*/
    @PostMapping("customer/logout/{name}")
    Customer logout(@PathVariable String name, HttpServletResponse response){
        Customer customer = repository.findByName(name);
        if(customer.isAuthenticated()){
            customer.setAuthenticated(false);
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer needs to login first!" );

        return customer;
    }

}




    //Customers are stored in memory
    // private HashMap <String, Customer> customers = new HashMap<>();
  
           // customers.put( newcustomer.getName(), newcustomer );

        // Customer customer = customers.get(name);
        // if(customer == null)
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Customer Not Found!");
        // return String.valueOf(customer.getId());


    // /*Get List of Customers*/
    // @GetMapping("/customers")
    // List<Customer> all(){
    //     return repository.findAll();
    // }







    /*Create a new Starbucks Order*/
  /*  @PostMapping("/customer/{customername}")
    @ResponseStatus(HttpStatus.CREATED)
    Customer newCustomer(@PathVariable String customername, @RequestBody Customer customer) {
        System.out.println("Register (Customer name = " + customername + ") => " + customer);

        // //check input
        // if(customer.getName().equals("") || customer.getPassword().equals("")){
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid customer creation!");
        // }
 
        //save customer
        Customer new_customer = repository.save(customer);
        customers.put(customername, new_customer);
        return new_customer;
    }

    /*Get Details of Customer*/
    /*@GetMapping("customer/{customername}")   
    Customer getCustomer(@PathVariable String customername, HttpServletResponse response) {
        Customer active = customers.get(customername);
        if (active != null){
            return active;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer Not Found!");
        }
    }
*/
    


 

 



    


