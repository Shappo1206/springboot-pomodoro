package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Todo;

//Spring JPA
@Repository
public interface UserRepository extends JpaRepository<Todo, Integer> {
	
}
