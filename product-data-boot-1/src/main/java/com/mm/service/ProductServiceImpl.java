package com.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.dto.ProductDto;
import com.mm.entity.Product;
import com.mm.repo.ProductRepository;
import com.mm.util.ProductNotFoundException;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void save(ProductDto p) {
	    Product pro= new Product();
	    pro.setCode(p.getCode());
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setCategory(p.getCategory());
		repo.save(pro);
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public Product getByCode(int code) {
		return repo.findById(code).orElseThrow(()->new RuntimeException("Product not found r id"));
	}

	@Override
	public void delete(int code) {
         repo.deleteById(code);		
	}

	@Override
	public List<Product> listByCategory(String cat) {
		// TODO Auto-generated method stub
		return repo.findByCategory(cat);
	}

	@Override
	public List<Product> listByPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> listByPriceLowToHigh() {
		// TODO Auto-generated method stub
		return repo.findByPrice();
	}

}
