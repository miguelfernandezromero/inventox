package com.api.inventox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventox.entity.CategoryEntity;
import com.api.inventox.respository.CategoryRepository;
import com.api.inventox.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public List<CategoryEntity> getAllCategorys() {
		return repository.findAll();
	}

	@Override
	public CategoryEntity getCategoryById(String id) {
		return repository.findById(Long.valueOf(id)).orElse(null);
	}

	@Override
	public CategoryEntity createCategory(CategoryEntity category) {
		return repository.save(category);
	}

	@Override
	public CategoryEntity updateCategory(String id, CategoryEntity category) {
		if (repository.existsById(Long.valueOf(id))) {
			category.setId(Long.valueOf(id));
			return repository.save(category);
		}
		return null;
	}

	@Override
	public boolean deleteCategory(String id) {
		if (repository.existsById(Long.valueOf(id))) {
			repository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

}
