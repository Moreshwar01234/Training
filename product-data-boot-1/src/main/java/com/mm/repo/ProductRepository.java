package com.mm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByPriceBetween(double min,double max);
	List<Product> findByCategory(String category);
	@Query("FROM Product ORDER BY price")
	List<Product> findByPrice();
}
