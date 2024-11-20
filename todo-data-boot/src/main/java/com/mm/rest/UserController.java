package com.mm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.service.UserService;
import com.mm.utility.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value="/save",consumes = "application/json")
	public String  save(@RequestBody User u) {
		service.save(u);
		return "user saved";
	}
	
	@GetMapping(value="/fetch/{id}",produces="application/json")
	public User fetch(@PathVariable int id) {
		return service.fetch(id);
	}
	
	@GetMapping(value="/list",produces ="application/json")
	public List<User> list(){
		return service.list();
	}
	
	
}
