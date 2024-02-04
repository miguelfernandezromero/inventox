package com.api.inventox.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.api.inventox.entity.CategoryEntity;

import io.swagger.annotations.ApiParam;

public interface CategoryApi {
	
	public ResponseEntity<Object> getAllCategorys(
			BindingResult result);
	
	public ResponseEntity<Object> getCategoryById(
			@ApiParam(name = "Id", value = "Id de la categoria", required = true) 
			String id,
			CategoryEntity result);
	
	public ResponseEntity<Object> createCategory(
			@ApiParam(name = "Categoria", value = "Informacion de la categoria a crear", required = true) 
			CategoryEntity category,
			CategoryEntity result);
	
	public ResponseEntity<Object> updateCategory(
			@ApiParam(name = "Categoria", value = "Informacion de la categoria para actualizar", required = true) 
			String id, CategoryEntity categorys,
			CategoryEntity result);
	
	public ResponseEntity<Object> deleteCategory(
			@ApiParam(name = "Id", value = "Id de la categoria a eliminar", required = true) 
			String id,
			CategoryEntity result);

}
