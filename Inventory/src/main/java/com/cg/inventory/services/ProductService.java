package com.cg.inventory.services;

import java.util.List;

import com.cg.inventory.model.Product;

/**
 * This is an interface for ProductService class, it has all the abstract methods
 * 
 * @author dinesh
 *
 */
public interface ProductService {

	Product addProduct(Product product);

	List<Product> viewAllProducts();

	Product updateProduct(Long productId, Product product);

	void removeProduct(Long productId);

	Product viewProductById(Long productId);

}