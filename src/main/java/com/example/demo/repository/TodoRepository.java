package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> { // TodoEntity: entity, Integer: @Id 的型別

	//顯示使用者的待辦給前端，查詢
	
	
}
