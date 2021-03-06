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

import com.cg.inventory.model.Category;
import com.cg.inventory.services.CategoryServiceImpl;

/**
 * The CategoryController class provides restful services to client like GET,
 * POST, DELETE, and PUT
 * 
 * @author abhiram
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Validated
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	/**
	 * GET method to view all categories
	 * 
	 * @return List of all categories
	 */
	@GetMapping
	public List<Category> viewAllCategories() {
		return categoryService.viewAllCategories();
	}

	/**
	 * POST method to create a new category
	 * 
	 * @param category
	 * @return Category object
	 */
	@PostMapping
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	/**
	 * DELETE method to remove an category
	 * 
	 * @param categoryId
	 */
	@DeleteMapping("{categoryId}")
	public void deleteCategory(@PathVariable @Positive Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}

	/**
	 * GET method to view category by Id
	 * 
	 * @param categoryId
	 * @return Category object
	 */
	@GetMapping("{categoryId}")
	public Category viewCategoryById(@PathVariable @Positive Long categoryId) {
		return categoryService.viewCategoryById(categoryId);
	}

	/**
	 * PUT method to update category
	 * 
	 * @param categoryId
	 * @param category
	 * @return Category object
	 */
	@PutMapping("{categoryId}")
	public Category updateCategory(@PathVariable @Positive Long categoryId, @Valid @RequestBody Category category) {
		return categoryService.updateCategory(categoryId, category);
	}
}
