package com.api.inventox.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.api.inventox.entity.StockEntity;

import io.swagger.annotations.ApiParam;

public interface StockApi {

	public ResponseEntity<Object> getAll(
			BindingResult result);
	
	public ResponseEntity<Object> getStockById(
			@ApiParam(name = "Id", value = "Id de la categoria", required = true) 
			String id,
			StockEntity result);
	
	public ResponseEntity<Object> createStock(
			@ApiParam(name = "Stock", value = "Informacion de Stock a crear", required = true) 
			StockEntity stock,
			StockEntity result);
	
	public ResponseEntity<Object> updateStock(
			@ApiParam(name = "Stock", value = "Informacion de Stock para actualizar", required = true) 
			String id, StockEntity stock,
			StockEntity result);
	
	public ResponseEntity<Object> deleteStock(
			@ApiParam(name = "Id", value = "Id de Stock a eliminar", required = true) 
			String id,
			StockEntity result);
}
