package com.cg.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.inventory.model.Product;

/**
 * This is an interface which defines CRUD methods for Product JPA repository
 * 
 * @author dinesh
 *
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {

}
