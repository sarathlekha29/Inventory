package com.cg.inventory.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.inventory.model.Customer;
import com.cg.inventory.model.Login;
import com.cg.inventory.services.CustomerServiceImpl;

/**
 * The CustomerController class provides restful services to client like GET,
 * POST, DELETE, and PUT
 * 
 * @author sarath lekha
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
//	Logger logger = Logger.getLogger(Customer.class);

	/**
	 * GET method to view all Customers
	 * 
	 * @return List of all Customers
	 */
	@GetMapping
	public List<Customer> viewAllCustomers() {
		return customerService.viewAllCustomers();
	}

	/**
	 * POST method to add a new Customer
	 * 
	 * @param customer
	 * @return Customer object
	 */
	@PostMapping
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	/**
	 * DELETE method to remove an Customer
	 * 
	 * @param customerId
	 */
	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable @Positive Long customerId) {
		customerService.removeCustomer(customerId);
	}

	/**
	 * GET method to view Customer by Id
	 * 
	 * @param customerId
	 * @return Customer object
	 */
	@GetMapping("{customerId}")
	public Customer viewCustomerById(@PathVariable @Positive Long customerId) {
		return customerService.viewCustomerById(customerId);
	}

	/**
	 * PUT method to update Customer
	 * 
	 * @param customerId
	 * @param customer
	 * @return Customer object
	 */
	@PutMapping("{customerId}")
	public Customer updateCustomer(@PathVariable @Positive Long customerId, @Valid @RequestBody Customer customer) {
		return customerService.updateCustomer(customerId, customer);
	}
}
