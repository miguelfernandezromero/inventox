package com.api.inventox.controller;

import java.util.List;

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

import com.api.inventox.api.ProductApi;
import com.api.inventox.entity.ProductEntity;
import com.api.inventox.service.IProductService;

@RestController
@RequestMapping("/productos")
public class ProductController implements ProductApi {
	
	@Autowired
	private IProductService service;

	@Override
	@GetMapping
	public ResponseEntity<Object> getAllProducts(BindingResult result) {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable String id, ProductEntity result) {
		ProductEntity producto = service.getProductById(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> createProduct(@RequestBody ProductEntity product, ProductEntity result) {
        return new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody ProductEntity product, ProductEntity result) {
		ProductEntity updatedProducto = service.updateProduct(id, product);
        if (updatedProducto != null) {
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable String id, ProductEntity result) {
		boolean deleted = service.deleteProduct(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

}
