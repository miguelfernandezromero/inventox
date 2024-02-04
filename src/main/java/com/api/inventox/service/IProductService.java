package com.api.inventox.service;

import java.util.List;

import com.api.inventox.entity.ProductEntity;

public interface IProductService {
	
	List<ProductEntity> getAllProducts();
	
	ProductEntity getProductById(String id);
	
	ProductEntity createProduct(ProductEntity product);
	
	ProductEntity updateProduct(String id, ProductEntity product);
	
	boolean deleteProduct(String id);

}
