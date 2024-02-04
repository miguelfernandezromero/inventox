package com.api.inventox.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import com.api.inventox.entity.ProductEntity;
import io.swagger.annotations.ApiParam;

public interface ProductApi {

	public ResponseEntity<Object> getAllProducts(
			BindingResult result);
	
	public ResponseEntity<Object> getProductById(
			@ApiParam(name = "Id", value = "Id del producto", required = true) 
			String id,
			ProductEntity result);
	
	public ResponseEntity<Object> createProduct(
			@ApiParam(name = "Producto", value = "Informacion de prodcuto a crear", required = true) 
			ProductEntity product,
			ProductEntity result);
	
	public ResponseEntity<Object> updateProduct(
			@ApiParam(name = "Producto", value = "Informacion de prodcuto para actualizar", required = true) 
			String id, ProductEntity product,
			ProductEntity result);
	
	public ResponseEntity<Object> deleteProduct(
			@ApiParam(name = "Id", value = "Id del producto a eliminar", required = true) 
			String id,
			ProductEntity result);
}
