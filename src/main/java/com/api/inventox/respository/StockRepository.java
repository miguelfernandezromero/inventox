package com.api.inventox.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventox.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Long>{

}
