package com.mm.service;

import java.util.List;

import com.mm.utility.User;

public interface UserService {
  
	public void save(User u);
	public User fetch(int id);
	public List<User> list();
}
