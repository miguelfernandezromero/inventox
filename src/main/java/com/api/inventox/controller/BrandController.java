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

import com.api.inventox.api.BrandApi;
import com.api.inventox.entity.BrandEntity;
import com.api.inventox.entity.ProductEntity;
import com.api.inventox.service.IBrandService;

@RestController
@RequestMapping("/marcas")
public class BrandController implements BrandApi{
	
	@Autowired
	private IBrandService service;

	@Override
	@GetMapping
	public ResponseEntity<Object> getAllBrand(BrandEntity result) {
		return new ResponseEntity<>(service.getAllBrands(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBranById(@PathVariable String id, BrandEntity result) {
		BrandEntity brand = service.getBrandById(id);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@PostMapping
	public ResponseEntity<Object> createBrand(@RequestBody BrandEntity brand, BrandEntity result) {
		return new ResponseEntity<>(service.createBrand(brand), HttpStatus.CREATED);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateBrand(@PathVariable String id, @RequestBody BrandEntity brand, BrandEntity result) {
		BrandEntity updateBrand = service.updateBrand(id, brand);
        if (updateBrand != null) {
            return new ResponseEntity<>(updateBrand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBrand(@PathVariable String id, BrandEntity result) {
		boolean deleted = service.deleteBrand(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}



}
