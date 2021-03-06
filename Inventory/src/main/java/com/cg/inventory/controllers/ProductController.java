package com.cg.inventory.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

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

import com.cg.inventory.model.Product;
import com.cg.inventory.services.CategoryServiceImpl;
import com.cg.inventory.services.ProductServiceImpl;

/**
 * The ProductController class provides restful services to client like GET,
 * POST, DELETE, and PUT
 * 
 * @author dinesh
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	

	/**
	 * GET method to view all products
	 * 
	 * @return List of all products
	 */
	@GetMapping("/getAllProducts")
	public List<Product> viewAllProducts() {
		return productService.viewAllProducts();
	}

	/**
	 * POST method to create a new product
	 * 
	 * @param product
	 * @return Product object
	 */
	@PostMapping("/createProduct")
	public Product addProduct( @RequestBody Product product) {
		return productService.addProduct(product);
	}
	

	/**
	 * DELETE method to remove an product
	 * 
	 * @param productId
	 */
	@DeleteMapping("/deleteProduct/{productId}")
	public void removeProduct(@PathVariable @Positive Long productId) {
		productService.removeProduct(productId);
	}

	/**
	 * GET method to view product by Id
	 * 
	 * @param productId
	 * @return Product object
	 */
	@GetMapping("/getProductById/{productId}")
	public Product viewProductById(@PathVariable @Positive Long productId) {
		return productService.viewProductById(productId);
	}

	/**
	 * PUT method to update product
	 * 
	 * @param productId
	 * @param product
	 * @return Product object
	 */
	@PutMapping("/updateProduct/{productId}")
	public Product updateProduct(@PathVariable @Positive Long productId, @Valid @RequestBody Product product) {
		return productService.updateProduct(productId, product);
	}
}