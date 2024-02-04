package com.api.inventox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventox.entity.StockEntity;
import com.api.inventox.respository.StockRepository;
import com.api.inventox.service.IStockService;

@Service
public class StockService implements IStockService {

	@Autowired
	private StockRepository repository;
	
	@Override
	public List<StockEntity> getAllStock() {
		return repository.findAll();
	}

	@Override
	public StockEntity getStockById(String id) {
		return repository.findById(Long.valueOf(id)).orElse(null);
	}

	@Override
	public StockEntity createStock(StockEntity brand) {
		return repository.save(brand);
	}

	@Override
	public StockEntity updateStock(String id, StockEntity brand) {
		if (repository.existsById(Long.valueOf(id))) {
			brand.setId(Long.valueOf(id));
			return repository.save(brand);
		}
		return null;
	}

	@Override
	public boolean deleteStock(String id) {
		if (repository.existsById(Long.valueOf(id))) {
			repository.deleteById(Long.valueOf(id));
			return true;
		}
		return false;
	}

}
