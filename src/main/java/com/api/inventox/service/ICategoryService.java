package com.api.inventox.service;

import java.util.List;

import com.api.inventox.entity.CategoryEntity;

public interface ICategoryService {
	
	List<CategoryEntity> getAllCategorys();

	CategoryEntity getCategoryById(String id);

	CategoryEntity createCategory(CategoryEntity category);

	CategoryEntity updateCategory(String id, CategoryEntity category);

	boolean deleteCategory(String id);

}
