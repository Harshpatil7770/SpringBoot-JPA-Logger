package com.crud.ecart.service;

import java.util.List;
import java.util.Optional;

import com.crud.ecart.model.Category;

public interface CategoryService {

	 String addNewCategory(Category category);
	
	 String addNewListOfCategories(List<Category> categories);
	 
	 String updateCategory(Category category);
	 
	 String deleteCategory(int categoryId);
	 
	 Optional<Category> findById(int categoryId);
	 
	 List<Category> fetchAllCategories();
}
