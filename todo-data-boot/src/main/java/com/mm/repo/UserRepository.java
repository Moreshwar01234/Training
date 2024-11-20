package com.mm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.utility.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
