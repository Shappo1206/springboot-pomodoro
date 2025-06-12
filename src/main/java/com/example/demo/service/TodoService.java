package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.AddTodoRequestDto;
import com.example.demo.model.dto.AddTodoResponseDto;
import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.entity.Todo;
import com.example.demo.repository.TodoRepository;

@Service
public interface TodoService {

	// 查詢所有 Todo
    public List<TodoDto> findAllTodos();

    // 查詢單筆 Todo
    public TodoDto getTodoById(Integer todoId);

    // 新增 Todo（使用 AddTodoRequestDto 做新增請求，回傳 AddTodoResponseDto）
    public AddTodoResponseDto addTodo(AddTodoRequestDto requestDto);

    // 修改 Todo
    public void updateTodo(Integer todoId, AddTodoRequestDto requestDto);

    // 刪除 Todo
    public void deleteTodo(Integer todoId);
}