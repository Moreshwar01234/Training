package com.mm.service;

import java.util.List;

import com.mm.dto.ProductDto;
import com.mm.entity.Product;
import com.mm.util.ProductNotFoundException;

public interface ProductService {

	void save(ProductDto p);
	
	List<Product> list();
	
	Product getByCode(int code);
	
	void delete(int code);
	
	List<Product> listByCategory(String cat);
	
	List<Product> listByPriceRange(double min,double max);
	
	List<Product> listByPriceLowToHigh();
}
