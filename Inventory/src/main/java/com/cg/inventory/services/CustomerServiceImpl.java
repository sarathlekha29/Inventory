package com.cg.inventory.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.inventory.exceptions.ResourceNotFoundException;
import com.cg.inventory.model.Customer;
import com.cg.inventory.repositories.CustomersRepository;

/**
 * The CustomerServiceImpl class provides access to JPA methods to create, remove,
 * view, and update customers
 * 
 * @author sarath lekha
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomersRepository customersRepository;

	/**
	 * This method returns list of all Customers
	 * 
	 * @return list of Customers
	 */
	@Override
	public List<Customer> viewAllCustomers() {
		return customersRepository.findAll();
	}

	/**
	 * This method takes Customer details and creates a new Customer
	 * 
	 * @param customer
	 * @return Customer entity details
	 */
	@Override
	public Customer createCustomer(Customer customer) {
		return customersRepository.saveAndFlush(customer);
	}

	/**
	 * This method takes Customer Id and deletes the Customer
	 * 
	 * @param customerId
	 */
	@Override
	public void removeCustomer(Long customerId) {
		customersRepository.deleteById(customerId);
	}

	/**
	 * This method returns Customers by searching with specific Customer Id
	 * 
	 * @param customerId
	 * @return Customer details if found or else throw exception
	 */
	@Override
	public Customer viewCustomerById(Long customerId) {
		return customersRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this Id : " + customerId));
	}

	/**
	 * This method updates Customer details by searching with Customer Id
	 * 
	 * @param customerId
	 * @param Customer
	 * @return Customer details if found or else throw exception
	 */
	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		Customer existingCustomer = customersRepository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this Id : " + customerId));
		BeanUtils.copyProperties(customer, existingCustomer, "customerId");
		return customersRepository.saveAndFlush(existingCustomer);
	}
}
