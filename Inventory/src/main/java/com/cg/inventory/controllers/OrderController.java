package com.cg.inventory.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import com.cg.inventory.model.Order;
import com.cg.inventory.services.OrderServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The OrderController class provides restful services to client like GET, POST,
 * DELETE, and PUT
 * 
 * @author sharique nooman
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("/api/v1/orders")
public class OrderController {

	@Autowired
	private OrderServiceImpl orderService;

	/**
	 * GET method to view all orders
	 * 
	 * @return List of all orders
	 */
	
    @GetMapping
	public List<Order> viewAllOrders() {
		return orderService.viewAllOrders();
	}

	
	/**
	 * POST method to create a new order
	 * 
	 * @param order
	 * @return Order object
	 */
    @PostMapping("{orderId}")
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderService.createOrder(order);
	}

	
	/**
	 * DELETE method to remove an order
	 * 
	 * @param orderId
	 */

	@DeleteMapping("{orderId}")
	public void deleteOrder(@PathVariable @Positive Long orderId) {
		orderService.deleteOrder(orderId);
	}

	
	/**
	 * GET method to view order by Id
	 * 
	 * @param orderId
	 * @return Order object
	 */
	
    @GetMapping("{orderId}")
	public Order viewOrderById(@PathVariable @Positive Long orderId) {
		return orderService.viewOrderById(orderId);
	}

	/**
	 * PUT method to update order
	 * 
	 * @param orderId
	 * @param order
	 * @return Order object
	 */
	
	@PutMapping("{orderId}")
	public Order updateOrder(@PathVariable @Positive Long orderId, @Valid @RequestBody Order order) {
		return orderService.updateOrder(orderId, order);
	}
}