package com.mm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.service.TodoService;
import com.mm.utility.Todo;



@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService service;
	@PostMapping(value="/save/{id}",consumes = "application/json")
	public String  save(@RequestBody Todo t,@PathVariable int id) {
		service.save(t, id);
		return "todo saved";
	}
	
	@GetMapping(value="/fetch/{id}",produces="application/json")
	public Todo fetch(@PathVariable int id) {
		return service.fetch(id);
	}
	
	@GetMapping(value="/list",produces ="application/json")
	public List<Todo> list(){
		return service.list();
	}
	
	@GetMapping(value="/byuser",produces = "application/json")
	public List<Todo> byUser(int userid){
		return service.ByUser(userid);
	}
	
	@GetMapping(value="/bystatus",produces = "application/json")
	public List<Todo> byStatus(String status) {
		return service.ByStatus(status);
	}
	
	@GetMapping(value="/update/{id}")
	public String updateStatus(@PathVariable int id) {
		service.updateByStatus(id);
		return "Status updated";
	}
	
	@GetMapping(value="/updateAll")
	public String updateAll() {
		service.updateAllByStatus();
		return "Status updated";
	}
}
