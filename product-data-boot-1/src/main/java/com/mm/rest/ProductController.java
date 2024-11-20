package com.mm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.dto.ProductDto;
import com.mm.entity.Product;
import com.mm.service.ProductService;
import com.mm.util.ProductNotFoundException;


@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
 
	@Autowired
	private ProductService service;
	
	
	@PostMapping(value ="/save",consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody ProductDto p) {		
		service.save(p);
		return new ResponseEntity<String>("product save",HttpStatus.OK);
	}
	
	@GetMapping(value="/fetch/{code}",produces = "application/json")
	public ResponseEntity<Product> fetch(@PathVariable int code)  {
		
		return new ResponseEntity<Product>(service.getByCode(code),HttpStatus.OK);
		
		
	}
	
	@GetMapping(value="/list",produces="application/json")
	public ResponseEntity<List<Product>> list() {
		return new ResponseEntity<List<Product>>(service.list(),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/remove/{code}")
	public ResponseEntity<String> remove(@PathVariable int code) {
		service.delete(code);
		return new ResponseEntity<String>("Product Removed",HttpStatus.OK);
	}
	
	@GetMapping(value="/byCustomer/{cat}",produces = "application/json")
	public ResponseEntity<List<Product>> fetchByProduct(@PathVariable String cat){
		return new ResponseEntity<List<Product>>( service.listByCategory(cat),HttpStatus.OK);
	}
	
    @GetMapping(value = "/byrange/{min}/{max}",produces = "application/json")
    public ResponseEntity<List<Product>> fetchByRange(@PathVariable int min,@PathVariable int max){
    	return new ResponseEntity<List<Product>>(service.listByPriceRange(min, max),HttpStatus.OK);
    }
	
    @GetMapping(value = "/byPrice",produces = "application/json")
    public ResponseEntity<List<Product>> fetchByPrice(){
    	return new ResponseEntity<List<Product>>(service.listByPriceLowToHigh(),HttpStatus.OK);
    }
}
