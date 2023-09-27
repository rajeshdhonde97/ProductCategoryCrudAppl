package com.crud.service;

import java.util.List;

import com.crud.model.Category;

public interface CategoryService {

	// Create New Category or save Category
	public Category saveCatagory(Category category);

	// Get All the Categories
	public List<Category> getAllCategories();

	// Get Category By Id
	public Category getCategoryById(int id);

	// update Category By Id
	public Category updateCategoryById(Category category, int id);

	// Delete Category By Id
	public void deleteCategoryById(int id);

}
