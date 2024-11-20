package com.mm.service;

import java.util.List;

import com.mm.utility.Todo;

public interface TodoService{
	public void save(Todo t,int id);
	public Todo fetch(int id);
	public List<Todo> list();
	public List<Todo> ByUser(int userId);
	public List<Todo> ByStatus(String status);
	public void updateByStatus(int id);
	public void updateAllByStatus();
	
}
