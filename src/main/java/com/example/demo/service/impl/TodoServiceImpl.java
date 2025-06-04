package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.entity.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

public class TodoServiceImpl implements TodoService{

		//注入
		@Autowired
		private TodoRepository todoRepository;
		
		//查詢所有待辦事項
		@Override
		public List<TodoDto> findAllTodos() {
			return todoRepository.findAll()
					.stream()
					.map(entity -> new TodoDto(
//							entity.getUserId(), // Id
							entity.getTodoId(),
							entity.getProjectId(),
							entity.getTitle(),
							entity.getDescription(),
							entity.isCompleted(),
							entity.getEstimatePomodoroCount(),
							entity.getCreatedTime()
							))
					        .collect(Collectors.toList());
		}

		@Override
		public TodoDto getTodoById(Integer todoId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void addTodo(TodoDto todoDto) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTodo(Integer todoId, String todoTitle, Integer estimatePomodoroCount) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTodo(Integer todoId, TodoDto todoDto) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTodo(Integer todoId, String todoTitle, Integer estimatePomodoroCount) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteTodo(Integer todoId) {
			// TODO Auto-generated method stub
			
		}
		
		
}
