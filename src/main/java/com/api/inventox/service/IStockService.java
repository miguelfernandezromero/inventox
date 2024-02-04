package com.api.inventox.service;

import java.util.List;

import com.api.inventox.entity.StockEntity;

public interface IStockService {
	
	List<StockEntity> getAllStock();

	StockEntity getStockById(String id);

	StockEntity createStock(StockEntity brand);

	StockEntity updateStock(String id, StockEntity brand);

	boolean deleteStock(String id);

}
