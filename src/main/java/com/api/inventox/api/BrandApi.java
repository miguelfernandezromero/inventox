package com.api.inventox.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.api.inventox.entity.BrandEntity;

import io.swagger.annotations.ApiParam;

public interface BrandApi {
	
	public ResponseEntity<Object> getAllBrand(
			BrandEntity result);
	
	public ResponseEntity<Object> getBranById(
			@ApiParam(name = "Id", value = "Id de la marca", required = true) 
			String id,
			BrandEntity result);
	
	public ResponseEntity<Object> createBrand(
			@ApiParam(name = "Marca", value = "Informacion de la marca a crear", required = true) 
			BrandEntity brand,
			BrandEntity result);
	
	public ResponseEntity<Object> updateBrand(
			@ApiParam(name = "Marca", value = "Informacion de la marca para actualizar", required = true) 
			String id, BrandEntity brand,
			BrandEntity result);
	
	public ResponseEntity<Object> deleteBrand(
			@ApiParam(name = "Id", value = "Id de la marcas a eliminar", required = true) 
			String id,
			BrandEntity result);

}
