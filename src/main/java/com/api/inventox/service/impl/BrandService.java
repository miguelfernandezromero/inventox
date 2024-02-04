package com.api.inventox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventox.entity.BrandEntity;
import com.api.inventox.respository.BrandRepository;
import com.api.inventox.service.IBrandService;

@Service
public class BrandService implements IBrandService {

	@Autowired
	private BrandRepository repository;

	@Override
	public List<BrandEntity> getAllBrands() {
		return repository.findAll();
	}

	@Override
	public BrandEntity getBrandById(String id) {
		return repository.findById(Long.valueOf(id)).orElse(null);
	}

	@Override
	public BrandEntity createBrand(BrandEntity brand) {
		return repository.save(brand);
	}

	@Override
	public BrandEntity updateBrand(String id, BrandEntity brand) {
		if (repository.existsById(Long.valueOf(id))) {
			brand.setId(Long.valueOf(id));
			return repository.save(brand);
		}
		return null;
	}

	@Override
	public boolean deleteBrand(String id) {
		if (repository.existsById(Long.valueOf(id))) {
			repository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

}
