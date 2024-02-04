package com.api.inventox.service;

import java.util.List;

import com.api.inventox.entity.BrandEntity;

public interface IBrandService {

	List<BrandEntity> getAllBrands();

	BrandEntity getBrandById(String id);

	BrandEntity createBrand(BrandEntity brand);

	BrandEntity updateBrand(String id, BrandEntity brand);

	boolean deleteBrand(String id);

}
