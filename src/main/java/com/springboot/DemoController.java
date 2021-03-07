package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Customer;
import com.springboot.repository.CustomerRepository;

@RestController
public class DemoController {
	
	@Autowired
	private CustomerRepository repository;
	
   @PostMapping(path = "/createCustomer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
    	
    	repository.save(customer);
		return ResponseEntity.ok("saved successfully !!!");
    	
       
    }
   
   @GetMapping(path = "/retrieveCustomer", produces = "application/json")
   public ResponseEntity<List<Customer>> retrieveCustomer(){
   	
   	List<Customer> customers = repository.findAll();
   	
   	return ResponseEntity.ok(customers);
   }
}
