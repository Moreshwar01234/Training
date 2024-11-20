package com.mm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.repo.TodoRepository;
import com.mm.utility.Todo;
import com.mm.utility.User;
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private UserService service;
	@Autowired
	private TodoRepository repo;
	@Override
	public void save(Todo t,int id) {
        User u=service.fetch(id);
        t.setUser(u);
        t.setStatus("pending");
        repo.save(t);
	}

	@Override
	public Todo fetch(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Todo> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Todo> ByUser(int userId) {
		// TODO Auto-generated method stub
		return repo.taskByUser(userId);
	}

	@Override
	public List<Todo> ByStatus(String status) {
		// TODO Auto-generated method stub
		return repo.taskByStatus(status);
	}

	@Override
	public void updateByStatus(int id) {
		Todo t=repo.findById(id).get();
        t.setStatus("completed");
        repo.save(t);
	}

	@Override
	public void updateAllByStatus() {
         List<Todo> t=repo.findAll();
		 for(Todo todo:t) {
			 todo.setStatus("completed");
			 repo.save(todo);
		 }
		 
	}

}
