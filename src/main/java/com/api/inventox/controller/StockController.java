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

import com.api.inventox.api.StockApi;
import com.api.inventox.entity.CategoryEntity;
import com.api.inventox.entity.ProductEntity;
import com.api.inventox.entity.StockEntity;
import com.api.inventox.service.IStockService;

@RestController
@RequestMapping("/stock")
public class StockController implements StockApi{
	
	@Autowired
	private IStockService service;

	@Override
	@GetMapping
	public ResponseEntity<Object> getAll(BindingResult result) {
		return new ResponseEntity<>(service.getAllStock(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Object> getStockById(@PathVariable String id, StockEntity result) {
		StockEntity stock = service.getStockById(id);
        if (stock != null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> createStock(@RequestBody StockEntity stock, StockEntity result) {
		return new ResponseEntity<>(service.createStock(stock), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStock(@PathVariable String id, @RequestBody StockEntity stock, StockEntity result) {
		StockEntity update = service.updateStock(id, stock);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStock(@PathVariable String id, StockEntity result) {
		boolean delete = service.deleteStock(id);
        if (delete) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

}
