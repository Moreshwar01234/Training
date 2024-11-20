package com.mm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mm.utility.Todo;

import jakarta.transaction.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query("FROM Todo WHERE user.id=:userId")
	public List<Todo> taskByUser(@Param("userId") int id);
	
	@Query("FROM Todo todo WHERE todo.status=:status")
	public List<Todo> taskByStatus(@Param("status") String status);
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE Team t SET t.status = 'completed' WHERE t.id =:tid")
//	public void updateByStatus(@Param("tid") int id);
}
