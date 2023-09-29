package com.crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.crud.model.Category;
import com.crud.repositiory.CategoryRepository;
import com.crud.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCatagory(Category category) {
		Category catagories = categoryRepository.save(category);
		return catagories;
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> categoriesList = categoryRepository.findAll();
		return categoriesList;
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = categoryRepository.findById(id);
		return category;
	}

	@Override
	public Category updateCategoryById(Category category, int id) {
		Category category1 = categoryRepository.findById(id);
		category1.setCategoryName(category.getCategoryName());
		Category categoryId = categoryRepository.save(category1);
		return categoryId;
	}

	@Override
	public void deleteCategoryById(int id) {
		categoryRepository.deleteById(id);

	}

	@Override
	public Page<Category> getAllCategories(int page, int pageSize) {
		PageRequest pageRequest = PageRequest.of(page, pageSize);
		return categoryRepository.findAll(pageRequest);
	}

}
