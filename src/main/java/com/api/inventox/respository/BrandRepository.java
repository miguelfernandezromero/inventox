package com.api.inventox.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventox.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Long>{

}
