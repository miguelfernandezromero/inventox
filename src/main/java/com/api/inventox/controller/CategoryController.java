package com.api.inventox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventox.api.CategoryApi;
import com.api.inventox.entity.BrandEntity;
import com.api.inventox.entity.CategoryEntity;
import com.api.inventox.service.ICategoryService;

@RestController
@RequestMapping("/categorias")
public class CategoryController implements CategoryApi{
	
	@Autowired
	private ICategoryService service;

	@Override
	@GetMapping
	public ResponseEntity<Object> getAllCategorys(BindingResult result) {
		return new ResponseEntity<>(service.getAllCategorys(), HttpStatus.OK);

	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable String id, CategoryEntity result) {
		CategoryEntity category = service.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> createCategory(@RequestBody CategoryEntity category, CategoryEntity result) {
		return new ResponseEntity<>(service.createCategory(category), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable String id, @RequestBody CategoryEntity categorys, CategoryEntity result) {
		CategoryEntity update = service.updateCategory(id, categorys);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable String id, CategoryEntity result) {
		boolean deleted = service.deleteCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

}
