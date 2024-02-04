package com.api.inventox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventox.entity.ProductEntity;
import com.api.inventox.respository.ProductRepository;
import com.api.inventox.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public List<ProductEntity> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public ProductEntity getProductById(String id) {
		return repository.findById(Long.valueOf(id)).orElse(null);
	}

	@Override
	public ProductEntity createProduct(ProductEntity product) {
		return repository.save(product);
	}

	@Override
	public ProductEntity updateProduct(String id, ProductEntity product) {
		
		 if (repository.existsById(Long.valueOf(id))) {
	            product.setId(Long.valueOf(id));
	            return repository.save(product);
	        }
	        return null;
	}

	@Override
	public boolean deleteProduct(String id) {
		if (repository.existsById(Long.valueOf(id))) {
			repository.deleteById(Long.valueOf(id));
            return true;
        }
        return false;
	}

}
