package com.api.inventox.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventox.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
