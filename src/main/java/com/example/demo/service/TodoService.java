package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public interface TodoService {
	
	public List<TodoDto> findAllTodos(); // 查詢所有 Todo
	
	public TodoDto getTodoById(Integer todoId); // 查詢單筆 Todo
	
	public void addTodo(TodoDto todoDto); // 新增 Todo
	
	public void addTodo(Integer todoId, String todoTitle, Integer estimatePomodoroCount); // 新增 Todo
	
	public void updateTodo(Integer todoId, TodoDto todoDto); // 修改 Todo
	
	public void updateTodo(Integer todoId, String todoTitle, Integer estimatePomodoroCount); // 修改 Todo
	
	public void deleteTodo(Integer todoId); // 刪除 Todo

	
}
